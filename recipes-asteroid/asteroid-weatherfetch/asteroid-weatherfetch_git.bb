SUMMARY = "Fetch weather forecast data for asteroid-weather"
HOMEPAGE = "https://github.com/beroset/asteroid-weatherfetch.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/beroset/asteroid-weatherfetch.git;protocol=https;branch=master"
SRCREV = "a20036a78cb1d9a84e97aed545794a1afedc9046"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native glibmm"
RDEPENDS:${PN} += "nemo-qml-plugin-notifications asteroid-virtualkeyboard"
FILES:${PN} += "/usr/share/translations/"
