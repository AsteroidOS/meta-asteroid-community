SUMMARY = "gpsp GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://github.com/MagneFire/gpsp.git;protocol=https;branch=master"
SRCREV = "cc286647af745543d0583ac9398b32427a581ef4"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

FILES:${PN} += "/usr/share/gpsp/"

UPSTREAM_CHECK_COMMITS = "1"

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

DEPENDS += "libsdl2 mcedevel dbus"
RDEPENDS:${PN} += "libsdl2"
