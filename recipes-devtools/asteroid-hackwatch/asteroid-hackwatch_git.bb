SUMMARY = "Asteroid HackWatch app"
HOMEPAGE = "https://github.com/Snoarlax/asteroid-hack"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

PV = "0.0.1"
PR = "r1"

SRC_URI = "git://github.com/Snoarlax/asteroid-hack.git;protocol=https;branch=master"
SRCREV = "5bbb1c5e6a0020334791314f8db4f511edf0ca1e"

S = "${WORKDIR}/git"
EXTRA_OECMAKE += "-DCPACK_PACKAGE_CONTACT='snoarsec@gmail.com'"
inherit cmake_qt5

DEPENDS = "qml-asteroid qtbase qtdeclarative extra-cmake-modules asteroid-generate-desktop-native"

RDEPENDS:${PN} = "qtbase qtdeclarative asteroid-launcher"

FILES:${PN} += "/usr/lib/libasteroid-hack.so"
FILES:${PN}-dev = ""
