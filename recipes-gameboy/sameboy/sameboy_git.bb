SUMMARY = "SameBoy GB/GBC emulator"
HOMEPAGE = "https://github.com/LIJI32/SameBoy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4118d8da21068e5aabfd211aa1ff75bb"

SRC_URI = "git://github.com/LIJI32/SameBoy.git;protocol=https;branch=master \
    file://0001-compilation-runtime-fix.patch \
"
SRCREV = "bb37f8d2f0a7dbfa5814e2d9faa897b52fdfd230"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"


FILES:${PN} += "/usr/share/games/sameboy/"

inherit pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

do_compile() {
    oe_runmake sdl DATA_DIR=/usr/share/games/sameboy/
}

do_install() {
    install -d ${D}${bindir}
    cp build/bin/SDL/sameboy ${D}${bindir}
	find build/bin/SDL -type f -not -executable | while read f; do
		install -Dm644 "$f" "${D}/usr/share/games/sameboy/${f#build/bin/SDL/}"
	done
}

DEPENDS += "rgbds-native libpng-native libsdl2 zlib libhybris android"
RDEPENDS:${PN} += "libsdl2 zlib libhybris"
