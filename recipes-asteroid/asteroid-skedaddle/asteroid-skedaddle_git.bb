SUMMARY = "A running log application for AsteroidOS"
HOMEPAGE = "https://github.com/beroset/asteroid-skedaddle"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/beroset/asteroid-skedaddle.git;protocol=https;branch=main"

PV = "2.0+git"
SRCREV = "915921447263361468e49f2be068bf9a261bcd35"

S = "${WORKDIR}/git"

inherit qt6-cmake

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native qtlocation espeak"
RDEPENDS:${PN} += "espeak qtlocation-qmlplugins"
FILES:${PN} += "/usr/share/translations/"
