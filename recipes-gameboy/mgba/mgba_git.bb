SUMMARY = "mGBA open-source Game Boy emulator"
HOMEPAGE = "https://github.com/mgba-emu/mgba.git"

LICENSE = "MPL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad"

SRC_URI = "git://github.com/mgba-emu/mgba.git;protocol=https \
"
SRCREV = "3e86eeda7004757be9926876224af026a07f7eca"


PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit pkgconfig cmake

EXTRA_OECMAKE += " -DBUILD_SDL=on"
EXTRA_OECMAKE += " -DBUILD_QT=off"
EXTRA_OECMAKE += " -DBUILD_GLES3=off"
EXTRA_OECMAKE += " -DUSE_FFMPEG=off"
EXTRA_OECMAKE += " -DBUILD_GL=on"
EXTRA_OECMAKE += " -DBUILD_GLES2=on"
EXTRA_OECMAKE += " -DUSE_DEBUGGERS=off"


TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "/usr/share/icons"

EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

DEPENDS += "libsdl2 zlib libpng libhybris android libconfig"
RDEPENDS_${PN} += "libsdl2 zlib libpng libhybris libconfig"
