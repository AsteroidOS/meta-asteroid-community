SUMMARY = "Asteroid Touchdown — lander game for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-touchdown"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/moWerk/asteroid-touchdown.git;protocol=https;branch=main"
SRCREV = "e9c9717b74df015a6fa3b96eeac320cd68193803"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS:append = " qml-asteroid qttools-native qtdeclarative-native"

FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /usr/share/icons/asteroid/asteroid-touchdown.svg"
