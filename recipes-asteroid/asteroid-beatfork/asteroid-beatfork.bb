SUMMARY = "A metronome and tuning fork app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-beatfork"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
SRC_URI = "git://github.com/moWerk/asteroid-beatfork.git;protocol=https;branch=master"
SRCREV = "0e2365c4cb4f2f92fb3dfedb485b1607668ac4a4"
PR = "r1"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"
inherit cmake_qt5 pkgconfig
DEPENDS += "nemo-keepalive qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
do_install:append() {
    install -d ${D}/usr/share/sounds
    install -m 0644 ${S}/src/tick.wav      ${D}/usr/share/sounds
    install -m 0644 ${S}/src/392hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/415hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/432hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/440hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/442hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/444hz.wav     ${D}/usr/share/sounds
    install -m 0644 ${S}/src/452hz.wav     ${D}/usr/share/sounds
}
FILES:${PN} += "/usr/share/translations/ /usr/share/sounds/"

