SUMMARY = "Simple Qt5 Quick application"
SECTION = "iAloy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# I want to make sure these get installed too.

SRCREV = "${AUTOREV}"
SRC_URI = " \
file://x11_vnc.service \
"
S = "${WORKDIR}"

inherit systemd

do_install() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 x11_vnc.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE_${PN} = "x11_vnc.service"
