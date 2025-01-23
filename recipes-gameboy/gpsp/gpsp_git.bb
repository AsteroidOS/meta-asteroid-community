SUMMARY = "gpsp GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://github.com/MagneFire/gpsp.git;protocol=https;branch=main"
SRCREV = "d74f472b447ddd646c09c929bd7fd2419f1842f7"
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
    install -m 0777 asteroidos/gpsp ${D}${bindir}

    install -d ${D}/usr/share/gpsp/
    install -m 0644 ${S}/game_config.txt ${D}/usr/share/gpsp/
}

DEPENDS += "libsdl2 mcedevel dbus"
RDEPENDS:${PN} += "libsdl2"
