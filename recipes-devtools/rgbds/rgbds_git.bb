SUMMARY = "gpsp GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=80084fe85efbf5d63cf2541801d78dfa"

SRC_URI = "git://github.com/rednex/rgbds.git;protocol=https;branch=master"
SRCREV = "9d993d84e85eeb8dd304e48463d89865795e97ed"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

inherit pkgconfig

FILES:${PN} = "${D}${prefix}/* ${D}${bindir}/*"

EXTRA_OEMAKE += "\
    'DESTDIR=${D}' \
    'prefix=${prefix}' \
    'bindir=${bindir}' \
    'sharedir=${datadir}' \
    'sysconfdir=${sysconfdir}' \
"

do_compile:prepend() {
        sed -i "/PREFIX		:/aDESTDIR?=\"\"" Makefile
        sed -i "s@PREFIX		:= /usr/local@prefix?=\"\"@" Makefile
        sed -i "s@bindir		:=@bindir?=\"\"@" Makefile
        sed -i "s@PREFIX@prefix@" Makefile
        sed -i "s/Q		:= @/Q		:= /" Makefile
        sed -i "s@LDFLAGS		:=@LDFLAGS?=\"\"@" Makefile
}

do_install() {
    oe_runmake install
}
INSANE_SKIP:${PN} = "already-stripped"


DEPENDS += " bison-native libpng-native"
RDEPENDS:${PN}:append:class-target = " libpng-native libpng"
RDEPENDS:${PN} += " libpng-native libpng"

BBCLASSEXTEND = "native nativesdk"
