SUMMARY = "gpSP frontend for AsteroidOS"
HOMEPAGE = "https://github.com/MagneFire/gpsp-menu.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/gpsp-menu.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid qtdeclarative-native"
RDEPENDS_${PN} += "qtsensors qtsensors-qmlplugins qtsensors-plugins gpsp"
