SUMMARY = "A stroboscope app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-pulsar"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-pulsar.git;protocol=https;branch=main"
SRCREV = "a9cdafaf0567007a30b57fc4788bd788a99c6d07"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "nemo-keepalive qml-asteroid qttools-native qtdeclarative-native"

FILES:${PN} += "/usr/lib/asteroid-pulsar.so /usr/share/translations/"
