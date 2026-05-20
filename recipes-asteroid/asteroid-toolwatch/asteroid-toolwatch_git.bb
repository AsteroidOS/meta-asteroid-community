SUMMARY = "An app for showing sensor data on AsteroidOS"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-toolwatch"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-toolwatch.git;protocol=https;branch=master"
SRCREV = "07b6675ae6e4734fee7971d4f4a22a9637f5f1a9"
PV = "2.1.0"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " qml-asteroid asteroid-generate-desktop-native qtsensors qttools-native qtdeclarative-native"

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
