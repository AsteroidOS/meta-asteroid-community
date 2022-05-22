SUMMARY = "gpSP/Gearboy frontend for AsteroidOS"
HOMEPAGE = "https://github.com/MagneFire/gpsp-menu.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/gpsp-menu.git;protocol=https;branch=master"
SRCREV = "737a1875a01c3d79113e01035345ef5616a14c11"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

FILES:${PN} += "/usr/share/icons/asteroid/"
FILES:${PN} += "/usr/share/translations/"

DEPENDS += "qml-asteroid asteroid-generate-desktop-native libsdl2 qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "qtsensors libsdl2 qtsensors-qmlplugins qtsensors-plugins"

do_install:append() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/i18n/gameboy.svg ${D}/usr/share/icons/asteroid/
}