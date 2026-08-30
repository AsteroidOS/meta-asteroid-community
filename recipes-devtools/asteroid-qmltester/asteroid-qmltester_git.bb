SUMMARY = "Asteroid's qmltester app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-qmltester.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-qmltester.git;protocol=https;branch=master"
SRCREV = "b397ebfa77025ddbf093fa4cbab7d5d218cc8624"
PR = "r1"
PV = "+git${SRCPV}"
inherit qt6-cmake

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
FILES:${PN} += "/usr/share/translations/"
