SUMMARY = "tree"
DESCRIPTION = "list contents of directories in a tree-like format"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"
SRC_URI = "git://gitlab.com/OldManProgrammer/unix-tree;protocol=https;branch=master"
PV = "2.1.1"
SRCREV = "84fa3ddff51b30835a0f9c4a9e4c9225970f9aff"

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

