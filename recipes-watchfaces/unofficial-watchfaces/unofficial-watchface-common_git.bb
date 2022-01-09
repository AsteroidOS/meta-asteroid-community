SUMMARY = "unofficial watchface common files for AsteroidOS."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"

SRC_URI = "git://github.com/AsteroidOS/unofficial-watchfaces.git;protocol=https"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

FILES:${PN} = "/usr/share/asteroid-launcher/"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/watchfaces-img/
    cp ${S}/logo-45degree/usr/share/asteroid-launcher/watchfaces-img/asteroid-logo.svg ${D}/usr/share/asteroid-launcher/watchfaces-img/asteroid-logo.svg
}
