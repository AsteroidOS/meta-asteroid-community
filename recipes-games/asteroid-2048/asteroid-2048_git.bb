SUMMARY = "2048 game for AsteroidOS"
HOMEPAGE = "https://github.com/MagneFire/asteroid-2048.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "git://github.com/MagneFire/asteroid-2048.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

FILES:${PN} += "/usr/share/icons/asteroid/"
FILES:${PN} += "/usr/share/translations/"
FILES:${PN} += "/usr/share/asteroid-launcher/watchfaces"

DEPENDS += "qml-asteroid qttools-native qtdeclarative-native"
RDEPENDS:${PN} += "qtsensors qtsensors-qmlplugins qtsensors-plugins"

do_install:append() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/i18n/2048.svg ${D}/usr/share/icons/asteroid/

    lrelease -idbased ${S}/i18n/${PN}.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/${PN}.*.qm ${D}/usr/share/translations/

    install -d ${D}/usr/share/asteroid-launcher/watchfaces/
    cp ${S}/Game.qml ${D}/usr/share/asteroid-launcher/watchfaces/099-2048.qml
}