SUMMARY = "Quake 1 first-person shooter game"
HOMEPAGE = "https://github.com/MagneFire/lp-public"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/MagneFire/lp-public.git;protocol=https \
    file://quake.desktop \
"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

INSANE_SKIP:${PN} += "already-stripped"

inherit pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"


EXTRA_OECONF = " --includedir=${STAGING_INCDIR} "


do_compile() {
    mkdir -p Ports/Quake1/Premake/Build-Linux/gmake/build
    cp Ports/Quake1/Premake/Build-Linux/gmake/Makefile Ports/Quake1/Premake/Build-Linux/gmake/build
    cp Ports/Quake1/Premake/Build-Linux/gmake/quake-gles1.make Ports/Quake1/Premake/Build-Linux/gmake/build
    cp Ports/Quake1/Premake/Build-Linux/gmake/quake-gles2.make Ports/Quake1/Premake/Build-Linux/gmake/build
    oe_runmake -C Ports/Quake1/Premake/Build-Linux/gmake/build all
}

do_install() {
    install -d ${D}${bindir}
    cp Ports/Quake1/Output/Targets/Linux-x86-32/Release/bin/* ${D}${bindir}

    install -d ${D}/usr/share/applications/
    cp ../quake.desktop ${D}/usr/share/applications/
}

DEPENDS += "libsdl2 zlib libhybris android"
RDEPENDS:${PN} += "libsdl2 zlib libhybris"
