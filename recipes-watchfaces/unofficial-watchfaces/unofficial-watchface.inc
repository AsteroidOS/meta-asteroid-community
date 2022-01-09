SUMMARY = "unofficial watchface template for AsteroidOS."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/"

SRC_URI = "git://github.com/AsteroidOS/unofficial-watchfaces.git;protocol=https"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

DEPENDS += "unofficial-watchface-common"

FILES:${PN} = "/usr/share/asteroid-launcher/ /usr/share/fonts/"

do_install() {
    install -d ${D}/usr/share/
    cp -r ${S}/${PN}/usr/share/ ${D}/usr/
    rm -f ${D}/usr/share/asteroid-launcher/watchfaces-img/asteroid-logo.svg
}
