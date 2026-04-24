SUMMARY = "A simple shopping list app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-shopper"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-shopper.git;protocol=https;branch=master"
SRCREV = "a6a522720c307bbf0281916d250b5044781d970d"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig asteroid-users

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

do_install:append() {
    install -g ${CERES_GID} -o ${CERES_UID} -d ${D}/home/ceres
    install -g ${CERES_GID} -o ${CERES_UID} -m 0644 ${S}/src/default-shopper.txt ${D}/home/ceres
}

FILES:${PN} += "/usr/share/translations/ /home/ceres/default-shopper.txt"
