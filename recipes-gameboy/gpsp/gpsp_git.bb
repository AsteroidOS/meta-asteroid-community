SUMMARY = "gpsp GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://github.com/MagneFire/gpsp.git;protocol=https;branch=master"
SRCREV = "322fca7e7aeeceb95658c3daeeecf8d958fb3cbb"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"


FILES:${PN} += "/usr/share/gpsp/"

inherit pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"


EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

do_compile() {
    oe_runmake -C asteroidos all
}

do_install() {
    install -d ${D}${bindir}
    cp asteroidos/gpsp ${D}${bindir}

    install -d ${D}/usr/share/gpsp/
    cp game_config.txt ${D}/usr/share/gpsp/
}

DEPENDS += "libsdl2"
RDEPENDS:${PN} += "libsdl2"
