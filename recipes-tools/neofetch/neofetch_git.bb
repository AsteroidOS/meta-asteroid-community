SUMMARY = "A CLI system information tool written in BASH."
HOMEPAGE = "https://github.com/dylanaraps/neofetch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=8f17a22b547171a026d82ce845165f40"

SRC_URI = "git://github.com/dylanaraps/neofetch.git;protocol=https;branch=master"

SRCREV = "ccd5d9f52609bbdcd5d8fa78c4fdb0f12954125f"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/neofetch ${D}${bindir}
}

DEPENDS = "bash"
RDEPENDS:${PN} += "bash"
