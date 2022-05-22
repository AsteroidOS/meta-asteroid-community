SUMMARY = "Visual Boy Advance GB/GBC/GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/visualboyadvance-m"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://doc/License.txt;md5=ad8ac3e11cc39f83fcaa6cd492075985"

SRC_URI = "git://github.com/MagneFire/visualboyadvance-m.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit pkgconfig cmake

EXTRA_OECMAKE += " -DENABLE_SDL=on"
EXTRA_OECMAKE += " -DENABLE_WX=off"
EXTRA_OECMAKE += " -DENABLE_NLS=off"
EXTRA_OECMAKE += " -DENABLE_FFMPEG=off"
EXTRA_OECMAKE += " -DENABLE_ONLINEUPDATES=off"
EXTRA_OECMAKE += " -DENABLE_GBA_LOGGING=off"
EXTRA_OECMAKE += " -DENABLE_ASM_SCALERS=off"
EXTRA_OECMAKE += " -DENABLE_GLES=on"


TARGET_CC_ARCH += "${LDFLAGS}"

FILES:${PN} += "/usr/share/ /usr/etc/vbam.cfg"

EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

DEPENDS += "libsdl2 zlib libpng libhybris android"
RDEPENDS:${PN} += "libsdl2 zlib libpng libhybris"
