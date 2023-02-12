SUMMARY = "Asteroid's qmltester app"
HOMEPAGE = "https://github.com/MagneFire/asteroid-qmltester.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/asteroid-qmltester.git;protocol=https;branch=master"
SRCREV = "de2672f6da72699112839e2151ef6a3ac83f52c6"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
FILES:${PN} += "/usr/share/translations/"
