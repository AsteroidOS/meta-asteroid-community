SUMMARY = "A rendering benchmark for AsteroidOS watches"
HOMEPAGE = "https://github.com/moWerk/benchymark"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/benchymark.git;protocol=https;branch=main"
# v0.2
SRCREV = "63b7d141210b7b9c1fce2e82ccb75826a4e86714"
PV = "0.2"
S = "${WORKDIR}/git"

inherit qt6-cmake

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

# The app library, the shader pair it loads at runtime and the icon are not
# covered by the default packaging globs.
FILES:${PN} += "/usr/share/translations/ ${libdir}/${PN}.so \
                ${datadir}/benchymark ${datadir}/icons/asteroid"
