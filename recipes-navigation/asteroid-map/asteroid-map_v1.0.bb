SUMMARY = "Map app for AsteroidOS"
HOMEPAGE = "https://git.dodorad.io/dodoradio/asteroid-map/about"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-map.git;protocol=https;branch=master"
SRCREV = "56a456a967b8658bcc836ed2484564e3697ee1de"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native qtlocation"
RDEPENDS:${PN} += "qtlocation qtlocation-plugins qtlocation-qmlplugins"

FILES:${PN} += "/usr/share/icons/asteroid"

do_install:append() {
    # This app only uses translations for the desktop shortcut.
    rm -rvf ${D}/usr/share/translations/
}

