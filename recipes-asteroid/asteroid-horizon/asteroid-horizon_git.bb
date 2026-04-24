SUMMARY = "Precision spirit level and angle meter for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-horizon"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-horizon.git;protocol=https;branch=main"
SRCREV = "8a100a1915411f52066c8bc45371f806636dd1e5"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " qml-asteroid qtsensors nemo-keepalive qttools-native qtdeclarative-native"

FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /usr/share/icons/asteroid/asteroid-horizon.svg"
