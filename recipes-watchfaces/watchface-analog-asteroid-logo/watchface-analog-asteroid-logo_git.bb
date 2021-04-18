SUMMARY = "An analog watchface with the AsteroidOS logo."
HOMEPAGE = "https://github.com/AsteroidOS/unofficial-watchfaces/blob/master/analog-asteroid-logo/usr/share/asteroid-launcher/watchfaces/analog-asteroid-logo.qml"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://analog-asteroid-logo/usr/share/asteroid-launcher/watchfaces/analog-asteroid-logo.qml;beginline=1;endline=22;md5=c1bb899c7df465f79a891877a09ee720"

SRC_URI = "git://github.com/AsteroidOS/unofficial-watchfaces.git;protocol=https"

SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

FILES_${PN} += "/usr/share/asteroid-launcher/watchfaces/analog-asteroid-logo.qml /usr/share/asteroid-launcher/watchfaces/asteroid_logo.png"

do_install() {
    install -d ${D}/usr/share/asteroid-launcher/watchfaces
    cp ${S}/analog-asteroid-logo/usr/share/asteroid-launcher/watchfaces/analog-asteroid-logo.qml ${D}/usr/share/asteroid-launcher/watchfaces/analog-asteroid-logo.qml
    cp ${S}/analog-asteroid-logo/usr/share/asteroid-launcher/watchfaces/asteroid_logo.png ${D}/usr/share/asteroid-launcher/watchfaces/asteroid_logo.png
}
