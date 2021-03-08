SUMMARY = "A CLI system information tool written in BASH."
HOMEPAGE = "https://github.com/jrtberlin/neofetch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=d300b86297c170b6498705fbb6794e3f"

SRC_URI = "git://github.com/jrtberlin/neofetch.git;protocol=https"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/neofetch ${D}${bindir}
}

DEPENDS = "bash"
