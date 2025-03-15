SUMMARY = "A simple shopping list app for AsteroidOS"
HOMEPAGE = "https://github.com/eLtMosen/asteroid-shopper"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/eLtMosen/asteroid-shopper.git;protocol=https;branch=master"
SRCREV = "75b52e94013d306bb1cd1a6ad48a8339286e0758"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

FILES:${PN} += "/usr/share/translations/ /home/ceres/shopper.txt"
