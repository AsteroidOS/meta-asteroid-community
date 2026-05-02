SUMMARY = "The Asteroid Blaster Game for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-blaster"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/moWerk/asteroid-blaster.git;protocol=https;branch=main"
SRCREV = "d4d8a069e369e97bbae59999f6869079327a2563"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS:append = " qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /usr/share/icons/asteroid/asteroid-blaster.svg"
