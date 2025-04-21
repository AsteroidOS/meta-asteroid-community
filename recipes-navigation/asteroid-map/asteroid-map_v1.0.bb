SUMMARY = "Map app for AsteroidOS"
iHOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-map/about"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-map.git;protocol=https;branch=master"
SRCREV = "79c43f735fedc45fae6c5d72ade70f0012cef530"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native qtlocation"
RDEPENDS:${PN} += "qtlocation"

FILES:${PN} += "/usr/share/icons/asteroid"

do_install:append() {
    # This app only uses translations for the desktop shortcut.
    rm -rvf ${D}/usr/share/translations/
}

