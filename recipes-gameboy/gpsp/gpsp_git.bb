SUMMARY = "gpsp GB/GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.DOC;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://github.com/MagneFire/gpsp.git;protocol=https \
    file://gpsp.conf \
    file://gpsp.service \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"


FILES_${PN} += "/usr/share/gpsp/ /usr/lib/systemd/user/"

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
    #chown ceres:ceres ${D}/usr/share/gpsp/
    cp game_config.txt ${D}/usr/share/gpsp/
    cp ../gpsp.conf ${D}/usr/share/gpsp/

    install -d ${D}/usr/lib/systemd/user/
    cp ../gpsp.service ${D}/usr/lib/systemd/user/
}

DEPENDS += "libsdl zlib libhybris android"
RDEPENDS_${PN} += "libsdl zlib libhybris"
