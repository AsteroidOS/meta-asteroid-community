SUMMARY = "gpSP/Gearboy frontend for AsteroidOS"
HOMEPAGE = "https://github.com/MagneFire/gpsp-menu.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/gpsp-menu.git;protocol=https;branch=main \
           file://gpsp.conf \
           "
SRCREV = "fe997a620a3560ddf872c70d732502ff25bea352"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

UPSTREAM_CHECK_COMMITS = "1"

inherit cmake_qt5 pkgconfig

FILES:${PN} += "/usr/share/icons/asteroid/"
FILES:${PN} += "/usr/share/translations/"
FILES:${PN} += "/usr/lib/systemd/user/"
FILES:${PN} += "/usr/share/gpsp/"

DEPENDS += "qml-asteroid asteroid-generate-desktop-native libsdl2 qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "qtsensors libsdl2 qtsensors-qmlplugins qtsensors-plugins"

do_install:append() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/i18n/gameboy.svg ${D}/usr/share/icons/asteroid/

    install -d ${D}/usr/share/gpsp/
    install -m 0644 ${UNPACKDIR}/gpsp.conf ${D}/usr/share/gpsp/
}