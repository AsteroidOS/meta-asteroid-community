SUMMARY = "A health tracker backend for AsteroidOS"
HOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-sensorlogd"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/AsteroidOS/asteroid-sensorlogd.git;protocol=https;branch=master"
SRCREV = "bdc9f0bb0fd6ef39f08fb01697d95cb2b98c86b6"
PR = "r1"
PV = "0.91+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools qtdeclarative-native qttools-native qtsensors mlite"
FILES:${PN} += "/usr/lib/"
RDEPENDS:${PN} += ""

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    ln -s /usr/lib/systemd/user/asteroid-sensorlogd.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-sensorlogd.service
}

