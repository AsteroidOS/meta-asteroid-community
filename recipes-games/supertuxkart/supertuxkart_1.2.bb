DESCRIPTION = "SuperTuxKart is a kart racing game featuring Tux and his friends"
HOMEPAGE = "http://supertuxkart.sourceforge.net"
LICENSE = "GPLv2 & GPLv3+ & CC-BY-SA-3.0 & CC-BY-SA-4.0 & PD"
LIC_FILES_CHKSUM = "file://COPYING;md5=bcfdeb69518cfe348a07845ebba5c295"

DEPENDS = " \
    libogg \
    libvorbis \
    virtual/libgles2 \
    openal-soft \
    fribidi \
    curl \
    libpng \
    libjpeg-turbo \
    freetype \
    bluez5 \
    harfbuzz \
    libsdl2 \
"

inherit cmake

SRC_URI = " \
    https://github.com/supertuxkart/stk-code/releases/download/${PV}/SuperTuxKart-${PV}-src.tar.xz \
    file://0001-Fix-compilation-with-latest-SDL.patch \
"

SRC_URI[sha256sum] = "052edf0afdbeb99583fe8676fb0ab80ecb6103fb88b7540f858d1b5fa1297d37"

S = "${WORKDIR}/SuperTuxKart-${PV}-src"

EXTRA_OECMAKE = " \
    -DUSE_GLES2=ON \
    -DBUILD_RECORDER=0 \
"
PACKAGECONFIG ??= " \
    ${@bb.utils.filter('DISTRO_FEATURES', 'wayland', d)} \
"
PACKAGECONFIG[wayland] = "-DENABLE_WAYLAND_DEVICE=ON,-DENABLE_WAYLAND_DEVICE=OFF,wayland"

FILES:${PN} += " \
    ${datadir}/icons \
    ${datadir}/metainfo \
"
