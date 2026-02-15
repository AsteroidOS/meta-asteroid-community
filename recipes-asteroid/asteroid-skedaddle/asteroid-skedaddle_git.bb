SUMMARY = "A running log application for AsteroidOS"
HOMEPAGE = "https://github.com/beroset/asteroid-skedaddle"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/beroset/asteroid-skedaddle.git;protocol=https;branch=main"

PV = "1.0+git"
SRCREV = "19e8e6f572d44b4ce6580c6eb930d8eb479408c3"

S = "${WORKDIR}/git"

inherit cmake_qt5

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native qtlocation espeak"
RDEPENDS:${PN} += "espeak qtlocation-qmlplugins"
FILES:${PN} += "/usr/share/translations/"
