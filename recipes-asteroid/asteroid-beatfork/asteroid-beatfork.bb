SUMMARY = "A metronome and tuning fork app for AsteroidOS"
HOMEPAGE = "https://github.com/moWerk/asteroid-beatfork"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"
SRC_URI = "git://github.com/moWerk/asteroid-beatfork.git;protocol=https;branch=master"
SRCREV = "cb81362f2c07ffb7ee07a0198f144c4069185c7c"
PR = "r1"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qt6-cmake pkgconfig
DEPENDS += "nemo-keepalive qtmultimedia qml-asteroid asteroid-generate-desktop-native qttools-native qtdeclarative-native"
do_install:append() {
    install -d ${D}/usr/share/sounds
    install -m 0644 ${S}/src/tick.wav      ${D}/usr/share/sounds
}
FILES:${PN} += "/usr/share/translations/ /usr/share/sounds/"

