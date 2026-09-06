SUMMARY = "A local music player for AsteroidOS"
HOMEPAGE = "https://github.com/monperrus/asteroid-local-music"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/monperrus/asteroid-local-music.git;protocol=https;branch=master"
SRCREV = "0576bc3fd437b6e60c9dabfbdb3411f934d1ff15"
PV = "2.0"

inherit qt6-cmake pkgconfig

DEPENDS += "qml-asteroid qttools-native qtdeclarative-native"

# Playback is a gst-launch-1.0 pipeline driven over pactl, so the elements it
# names have to be on the device: mpegaudioparse (audioparsers),
# mpg123audiodec (mpg123), audioconvert and audioresample (base), pulsesink
# (pulseaudio). pactl itself ships in pulseaudio-server.
RDEPENDS:${PN} += " \
    pulseaudio-server \
    gstreamer1.0 \
    gstreamer1.0-plugins-base-audioconvert \
    gstreamer1.0-plugins-base-audioresample \
    gstreamer1.0-plugins-good-audioparsers \
    gstreamer1.0-plugins-good-mpg123 \
    gstreamer1.0-plugins-good-pulseaudio \
"

FILES:${PN}:append = " ${libdir}"
