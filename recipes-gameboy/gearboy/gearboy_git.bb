SUMMARY = "Gearboy GB/GBC emulator"
HOMEPAGE = "https://github.com/MagneFire/gearboy"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/MagneFire/Gearboy.git;protocol=https \
    file://gearboy.service \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

FILES_${PN} += "/usr/lib/systemd/user/"

inherit pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"


EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

do_compile() {
    oe_runmake -C platforms/asteroid all
}

do_install() {
    install -d ${D}${bindir}
    cp platforms/asteroid/gearboy ${D}${bindir}

    install -d ${D}/usr/lib/systemd/user/
    cp ../gearboy.service ${D}/usr/lib/systemd/user/
}

DEPENDS += "libsdl zlib libhybris android libconfig"
RDEPENDS_${PN} += "libsdl zlib libhybris libconfig"
