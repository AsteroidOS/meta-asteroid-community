SUMMARY = "A simple shopping list app for AsteroidOS"
HOMEPAGE = "https://github.com/eLtMosen/asteroid-shopper"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/eLtMosen/asteroid-shopper.git;protocol=https;branch=master"
SRCREV = "4104340d57dccd6c59c283f50436cd9d3345535c"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit cmake_qt5 pkgconfig asteroid-users

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

do_install:append() {
    install -g ${CERES_GID} -o ${CERES_UID} -d ${D}/home/ceres
    install -g ${CERES_GID} -o ${CERES_UID} -m 0644 ${S}/src/shopper.txt ${D}/home/ceres
}

FILES:${PN} += "/usr/share/translations/ /home/ceres/shopper.txt"
