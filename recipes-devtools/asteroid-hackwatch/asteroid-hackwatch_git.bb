SUMMARY = "Asteroid HackWatch app"
HOMEPAGE = "https://github.com/Snoarlax/asteroid-hack"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

PV = "1.0.0+git${SRCPV}"
PR = "r0"

SRC_URI = "git://github.com/Snoarlax/asteroid-hack;protocol=https;branch=master"
SRCREV = "b2af485c78e26e18e950e3e064584b0765c163e5"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DCPACK_PACKAGE_CONTACT='snoarsec@gmail.com'"
inherit cmake_qt5

DEPENDS = "qml-asteroid qtbase qtdeclarative extra-cmake-modules asteroid-generate-desktop-native"
RDEPENDS:${PN} = "qtbase qtdeclarative asteroid-launcher sudo"

do_compile:append() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/src/utilities/keyboard_interface.c -o ${B}/keyboard_interface
}

do_install:append() {
    install -d ${D}/usr/bin/
    install -m 0755 ${B}/keyboard_interface ${D}/usr/bin/keyboard_interface
}

FILES:${PN} += "/usr/lib/libasteroid-hack.so /usr/bin/keyboard_interface"
FILES:${PN}-dev = ""
