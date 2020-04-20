SUMMARY = "Simple Qt5 Quick application"
SECTION = "iAloy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# I want to make sure these get installed too.
DEPENDS += "qtbase"

SRCREV = "${AUTOREV}"
SRC_URI = " \
file://iAloy \
file://*.jpg \
file://*.png \
file://*.ttf \
file://*.sh \
file://*.service \
file://libwiringPi.so.1.1 \
"
S = "${WORKDIR}"

inherit systemd

do_install() {
	install -d ${D}${bindir}
	install -m 0755 iAloy ${D}${bindir}

	install -d ${D}${datadir}/iAloy/photos/
	install -d ${D}${datadir}/iAloy/scripts/
	install -d ${D}${datadir}/iAloy/fonts/
	install -d ${D}${datadir}/iAloy/update_check/
	install -d ${D}${datadir}/iAloy/.conf/
	install -d ${D}${datadir}/iAloy/.temp/
	install -d ${D}${libdir}/

	install -m 0644 *.jpg ${D}${datadir}/iAloy/photos/
	install -m 0644 *.png ${D}${datadir}/iAloy/photos/
	install -m 0644 *.ttf ${D}${datadir}/iAloy/fonts/
	install -m 0755 *.sh ${D}${datadir}/iAloy/scripts/
	install -m 0755 libwiringPi.so.1.1 ${D}${libdir}/
	ln -sf libwiringPi.so.1.1 ${D}/${libdir}/libwiringPi.so

	install -m 0755 update_check.sh ${D}${datadir}/iAloy/update_check/

	install -d ${D}${systemd_unitdir}/system
	install -m 0644 iAloy-onboot-loader.service ${D}${systemd_unitdir}/system/
	install -m 0644 iAloy-update-manager.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_SERVICE_${PN} = "iAloy-onboot-loader.service"
SYSTEMD_SERVICE_${PN} += "iAloy-update-manager.service"
