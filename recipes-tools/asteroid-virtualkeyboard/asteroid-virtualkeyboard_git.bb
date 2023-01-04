SUMMARY = "Asteroid's virtual keyboard"
HOMEPAGE = "https://github.com/beroset/asteroid-virtualkeyboard.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/beroset/asteroid-virtualkeyboard.git;protocol=https;branch=main"
SRCREV = "85b266f561dc6ac78bf58cb52b0b89f10bc79227"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: AsteroidApp ECM
inherit cmake_qt5 

DEPENDS += "qml-asteroid qttools-native qtdeclarative-native"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""
FILES:${PN} += "/usr/lib/qml/QtQuick/VirtualKeyboard/Styles/watch/"

