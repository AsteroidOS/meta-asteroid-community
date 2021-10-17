SUMMARY = "Gambatte GB/GBC emulator"
HOMEPAGE = "https://github.com/sinamas/gambatte"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/sinamas/gambatte.git;protocol=https \
    file://0001-yocto-paths-fix.patch \
    file://0002-sdl-to-sdl2.patch \
    file://0003-rtc-fix.patch \
    file://0004-center-video.patch \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit pkgconfig scons

TARGET_CC_ARCH += "${LDFLAGS}"


EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

scons_do_compile() {
    cd libgambatte
    ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} ${EXTRA_OESCONS} || \
    die "scons build execution failed."

    cd ..
    cd gambatte_sdl
    ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} ${EXTRA_OESCONS} || \
    die "scons build execution failed."
}

do_install() {
    install -d ${D}${bindir}
    cp gambatte_sdl/gambatte_sdl ${D}${bindir}
}

DEPENDS += "libsdl2 zlib libhybris android libconfig"
RDEPENDS:${PN} += "libsdl2 zlib libhybris libconfig"
