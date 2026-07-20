SUMMARY = "Precision spirit level and angle meter for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-horizon"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-horizon.git;protocol=https;branch=main"
SRCREV = "3339b36ab549e11949f3399e49ced07e1035ee96"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " qml-asteroid qtsensors nemo-keepalive qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "qtsensors-qmlplugins"

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /usr/share/icons/asteroid/asteroid-horizon.svg"
