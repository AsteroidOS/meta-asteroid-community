SUMMARY = "Fetch weather forecast data for asteroid-weather"
HOMEPAGE = "https://github.com/beroset/asteroid-weatherfetch.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/beroset/asteroid-weatherfetch.git;protocol=https;branch=master"
SRCREV = "67a9e1de043d23cc8599c85cb0383eb10323ca6e"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native glibmm"
RDEPENDS:${PN} += "nemo-qml-plugin-notifications asteroid-virtualkeyboard"
FILES:${PN} += "/usr/share/translations/"
