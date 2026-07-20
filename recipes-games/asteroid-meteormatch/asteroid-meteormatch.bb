SUMMARY = "A block-matching puzzle game for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-meteormatch"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=45bc9c5afb8cda60dfa1f74c3e6d618d"

SRC_URI = "git://github.com/moWerk/asteroid-meteormatch.git;protocol=https;branch=main"
SRCREV = "3a597047d1e4021d8eddf715e4c6e110c04080d1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " nemo-qml-plugin-configuration qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
