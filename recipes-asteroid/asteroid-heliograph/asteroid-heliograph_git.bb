SUMMARY = "A scrolling light message app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-heliograph"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-heliograph.git;protocol=https;branch=main"
SRCREV = "d01b81d809ad2c3eaf20d33d9288b40aa50228b0"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig

DEPENDS += "nemo-keepalive qml-asteroid qtsensors qttools-native qtdeclarative-native"

FILES:${PN} += "/usr/lib/asteroid-heliograph.so /usr/share/translations/"
