#!/bin/bash

output="../recipes-watchfaces/unofficial-watchfaces/"

git clone "https://github.com/AsteroidOS/unofficial-watchfaces.git"

cd unofficial-watchfaces

rm -r ${output}
mkdir -p ${output}

wf=`find . -maxdepth 1 -type d -not -name ".*"  -exec echo {} \;`

declare -a common=("/usr/share/asteroid-launcher/watchfaces-img/asteroid-logo.svg")
declare -a common_src=()

for f in ${common[*]}; do
    path=`find . -path "*${f}" -print -quit`
    path=${path:2}
    path=(${path//\// })
    common_src+=${path}
done

for i in ${wf}; do
    gnu=`cat "${i}/usr/share/asteroid-launcher/watchfaces/${i}.qml" | grep "GNU Lesser General Public License"`
    bsd=`cat "${i}/usr/share/asteroid-launcher/watchfaces/${i}.qml" | grep "BSD license"`
    if [[ ! -z "$gnu" ]]; then
cat << EOF > "${output}${i:2}_git.bb"
SUMMARY = "${i:2} unofficial watchface."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://\${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"
EOF
    elif [[ ! -z "$bsd" ]]; then
cat << EOF > "${output}${i:2}_git.bb"
SUMMARY = "${i:2} unofficial watchface."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://\${COMMON_LICENSE_DIR}/BSD;md5=3775480a712fc46a69647678acb234cb"
EOF
    else
cat << EOF > "${output}${i:2}_git.bb"
SUMMARY = "${i:2} unofficial watchface."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "CLOSED"
EOF
    fi

    echo "require unofficial-watchface.inc" >> "${output}${i:2}_git.bb"
done

cat << EOF > ${output}unofficial-watchfaces_git.bb
SUMMARY = "A meta recipe for all unofficial watchfaces."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://\${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

ALLOW_EMPTY:\${PN} = "1"

def get_watchface_depends(d):
    task = "do_package_write_ipk"
    package_feed = d.getVar('WATCHFACES')
    return oe.utils.build_depends_string(package_feed, task)

do_build[depends] += "\${@get_watchface_depends(d)}"
EOF

for i in ${wf}; do
    # Ensure that the watchface package is created during build time.
    echo "WATCHFACES += \"${i:2}\"" >> ${output}unofficial-watchfaces_git.bb
done

cat << EOF > ${output}unofficial-watchface.inc
SUMMARY = "unofficial watchface template for AsteroidOS."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"

SRC_URI = "git://github.com/AsteroidOS/unofficial-watchfaces.git;protocol=https;branch=master"

SRCREV = "\${AUTOREV}"
PR = "r1"
PV = "+git\${SRCPV}"
S = "\${WORKDIR}/git"

DEPENDS += "unofficial-watchface-common"

FILES:\${PN} = "/usr/share/asteroid-launcher/ /usr/share/fonts/"

do_install() {
    install -d \${D}/usr/share/
    cp -r \${S}/\${PN}/usr/share/ \${D}/usr/
EOF

for f in ${common[*]}; do
    echo "    rm -f \${D}$f" >> ${output}unofficial-watchface.inc
done
echo "}" >> ${output}unofficial-watchface.inc

cat << EOF > ${output}unofficial-watchface-common_git.bb
SUMMARY = "unofficial watchface common files for AsteroidOS."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://\${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "git://github.com/AsteroidOS/unofficial-watchfaces.git;protocol=https;branch=master"

SRCREV = "\${AUTOREV}"
PR = "r1"
PV = "+git\${SRCPV}"
S = "\${WORKDIR}/git"

FILES:\${PN} = "/usr/share/asteroid-launcher/"

do_install() {
    install -d \${D}/usr/share/asteroid-launcher/watchfaces-img/
EOF
for i in ${!common[@]}; do
    echo "    cp \${S}/${common_src[i]}${common[i]} \${D}${common[i]}" >> ${output}unofficial-watchface-common_git.bb
done
echo "}" >> ${output}unofficial-watchface-common_git.bb

cd ..
rm -rf unofficial-watchfaces