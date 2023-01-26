SUMMARY = "tree"
DESCRIPTION = "list contents of directories in a tree-like format"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"
SRC_URI = "git://gitlab.com/OldManProgrammer/unix-tree;protocol=https;branch=master"
PV = "1.0+git${SRCPV}"
SRCREV = "22a2e268206b8d2238a686458c4702f9b3689e5b"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' \
   'CFLAGS=${CFLAGS} -I${S}/. -DWITHOUT_XATTR' 'BUILDDIR=${S}'"

do_compile () {
	oe_runmake
}

do_install () {
        install -d ${D}${bindir}
        install -m 0755 tree ${D}${bindir}
}

