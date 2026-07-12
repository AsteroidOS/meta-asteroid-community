SUMMARY = "A health app for AsteroidOS"
HOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-health"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-health.git;protocol=https;branch=master"
SRCREV = "3e78747b68d3867608a3d8e2c24463839039d235"
PR = "r1"
PV = "0.91+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools qtsensors asteroid-sensorlogd qttools-native qtdeclarative-native"
FILES:${PN} += "/usr/lib/ /usr/share/translations/"
RDEPENDS:${PN} += "asteroid-sensorlogd"

