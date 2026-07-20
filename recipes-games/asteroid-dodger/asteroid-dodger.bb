SUMMARY = "A thrilling survival game for AsteroidOS where you tilt your watch to surf through an ever-denser asteroid field"
HOMEPAGE = "https://github.com/moWerk/asteroid-dodger"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-dodger.git;protocol=https;branch=master"
SRCREV = "9643d40db9c609a006ed89a87dc1afd907492af1"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "qtsensors-qmlplugins"

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /usr/share/icons/"
