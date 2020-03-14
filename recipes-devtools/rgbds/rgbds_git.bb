SUMMARY = "gpsp GBA emulator"
HOMEPAGE = "https://github.com/MagneFire/gpsp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a2a25a073c835eb33b16475c81802ed5"

SRC_URI = "git://github.com/rednex/rgbds.git;protocol=https \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"


#FILES_${PN} += "/usr/share/gpsp/ /usr/lib/systemd/user/"

inherit pkgconfig

#TARGET_CC_ARCH += "${LDFLAGS}"


#EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "

#FILES_${PN}_append_class-nativesdk = " ${SDKPATHNATIVE}"
FILES_${PN} = "${D}${prefix}/* ${D}${bindir}/*"

EXTRA_OEMAKE += "\
    'DESTDIR=${D}' \
    'prefix=${prefix}' \
    'bindir=${bindir}' \
    'sharedir=${datadir}' \
    'sysconfdir=${sysconfdir}' \
"

do_compile_prepend() {
        sed -i "/PREFIX		:/aDESTDIR?=\"\"" Makefile
        sed -i "s@PREFIX		:= /usr/local@prefix?=\"\"@" Makefile
        sed -i "s@bindir		:=@bindir?=\"\"@" Makefile
        sed -i "s@PREFIX@prefix@" Makefile
        sed -i "s/Q		:= @/Q		:= /" Makefile
        sed -i "s@LDFLAGS		:=@LDFLAGS?=\"\"@" Makefile
        
        
#        sed -i "s@PREFIX		:= /usr/local@PREFIX?=${prefix}@" Makefile
#        sed -i "/PREFIX		:/aDESTDIR?=${DESTDIR}" Makefile
#        sed -i "s@PREFIX		:= /usr/local@prefix?=@" Makefile
#        sed -i "s@PREFIX@prefix@" Makefile
#        sed -i "s@bindir		:=@bindir?=@" Makefile
#        sed -i "/PREFIX		:/aDESTDIR ?= " Makefile
}

#do_compile() {
#    oe_runmake
#    oe_runmake all
#}

do_install() {
    oe_runmake install
}
INSANE_SKIP_${PN}  = "already-stripped"


DEPENDS += " bison-native libpng-native"
#DEPENDS_virtclass-native = ""
RDEPENDS_${PN}_append_class-target += "libpng-native  libpng"
RDEPENDS_${PN} += " libpng-native libpng"

BBCLASSEXTEND = "native nativesdk"
