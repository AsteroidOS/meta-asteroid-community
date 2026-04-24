SUMMARY = "A simple shopping list app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-shopper"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-shopper.git;protocol=https;branch=master"
SRCREV = "06e9dcc3de8c8b249569ad5c99703d9538c90cbc"
PR = "r2"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig asteroid-users

DEPENDS += "qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"

do_install:append() {
    install -g ${CERES_GID} -o ${CERES_UID} -d ${D}/home/ceres/.local/share/asteroid-shopper
    install -g ${CERES_GID} -o ${CERES_UID} -m 0644 ${S}/src/default-shopper.txt ${D}/home/ceres/.local/share/asteroid-shopper/default-shopper.txt
}

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /home/ceres/.local/share/asteroid-shopper/default-shopper.txt"
