SUMMARY = "A health app for AsteroidOS"
HOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-health"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-health.git;protocol=https;branch=master"
SRCREV = "5dd341b6aef969cac3f601d32e91b2f39809cd8a"
PR = "r1"
PV = "0.9+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools qtsensors asteroid-sensorlogd"
FILES:${PN} += "/usr/lib/"
RDEPENDS:${PN} += "asteroid-sensorlogd"

