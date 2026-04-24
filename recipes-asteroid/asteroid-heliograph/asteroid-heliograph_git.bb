SUMMARY = "A scrolling light message app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-heliograph"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/moWerk/asteroid-heliograph.git;protocol=https;branch=main"
SRCREV = "675d2289f628e9b3f7d164f004db0b6053425b1e"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit qt6-cmake pkgconfig

DEPENDS:append = " nemo-keepalive qml-asteroid qtsensors qttools-native qtdeclarative-native"

do_install:append() {
    install -d ${D}/home/ceres/.local/share/asteroid-heliograph
    install -m 0644 ${S}/custom.txt ${D}/home/ceres/.local/share/asteroid-heliograph/custom.txt
}

FILES:${PN}:append = " ${libdir}"
FILES:${PN}:append = " /usr/share/translations/"
FILES:${PN}:append = " /home/ceres/.local/share/asteroid-heliograph/custom.txt"
