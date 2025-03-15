SUMMARY = "A thrilling survival game for AsteroidOS where you tilt your watch to surf through an ever-denser asteroid field"
HOMEPAGE = "https://github.com/eLtMosen/asteroid-dodger"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/eLtMosen/asteroid-dodger.git;protocol=https;branch=master"
SRCREV = "30d788dd7ba0a3354f0c933d9b43adcf6bb8f2b1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

FILES:${PN} += "/usr/share/translations/"
FILES:${PN} += "/usr/share/icons/"
