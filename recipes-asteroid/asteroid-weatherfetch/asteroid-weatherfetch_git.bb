SUMMARY = "Fetch weather forecast data for asteroid-weather"
HOMEPAGE = "https://github.com/beroset/asteroid-weatherfetch.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/beroset/asteroid-weatherfetch.git;protocol=https;branch=master"
SRCREV = "70044bb4904d22f521fa7eb7448d5007bd863f97"
PV = "3.0.0"

inherit qt6-cmake pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native mlite qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "nemo-qml-plugin-notifications asteroid-virtualkeyboard asteroid-btsyncd"
FILES:${PN} += "/usr/share/translations/"
