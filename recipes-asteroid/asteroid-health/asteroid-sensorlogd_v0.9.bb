SUMMARY = "A health tracker backend for AsteroidOS"
HOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-sensorlogd"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://git.dodorad.io/dodoradio/asteroid-sensorlogd/;protocol=https;branch=master"
SRCREV = "f46ac73ac2398f9dbb069012b3cf6d569760bcf0"
PR = "r1"
PV = "0.9+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools qtdeclarative-native qttools-native qtsensors"
FILES:${PN} += "/usr/lib/"
RDEPENDS:${PN} += ""

do_install:append() {
    install -d ${D}/usr/lib/systemd/user/
    install -d ${D}/usr/lib/systemd/user/default.target.wants/
    ln -s /usr/lib/systemd/user/asteroid-sensorlogd.service ${D}/usr/lib/systemd/user/default.target.wants/asteroid-sensorlogd.service
}

