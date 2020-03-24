SUMMARY = "Simple Qt5 Quick application"
SECTION = "iAloy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# I want to make sure these get installed too.
DEPENDS += "qtbase"

SRCREV = "${AUTOREV}"
SRC_URI = " \
file://iAloy \
file://back.jpg \
file://dashboard.jpg\
"
S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 iAloy ${D}${bindir}

	install -d ${D}${datadir}/iAloy/photos/
	install -m 0644 back.jpg ${D}${datadir}/iAloy/photos/
	install -m 0644 dashboard.jpg ${D}${datadir}/iAloy/photos/
}