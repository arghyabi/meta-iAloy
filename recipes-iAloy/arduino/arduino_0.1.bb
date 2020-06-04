SUMMARY = "arduino application to burn uC"
SECTION = "arduino"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# I want to make sure these get installed too.

DEPENDS += "elfutils libftdi libusb1 libyui-ncurses"

SRCREV = "${AUTOREV}"
SRC_URI = " \
file://avrdude \
file://avrdude.conf \
file://libftdi.so.1 \
file://libhidapi-libusb.so.0 \
file://libncurses.so.6 \
file://libreadline.so.7 \
file://libtinfo.so.6 \
file://libusb-0.1.so.4 \
"
S = "${WORKDIR}"

inherit systemd

do_install() {
	install -d ${D}${bindir}
	install -m 0755 avrdude ${D}${bindir}
	install -d ${D}${libdir}/

	install -d ${D}${datadir}/arduino/conf/

	install -m 0644 avrdude.conf ${D}${datadir}/arduino/conf/

	install -m 0755 libftdi.so.1 ${D}${libdir}/
	install -m 0755 libhidapi-libusb.so.0 ${D}${libdir}/
	install -m 0755 libncurses.so.6 ${D}${libdir}/
	install -m 0755 libreadline.so.7 ${D}${libdir}/
	install -m 0755 libtinfo.so.6 ${D}${libdir}/
	install -m 0755 libusb-0.1.so.4 ${D}${libdir}/

	ln -sf libftdi.so.1 ${D}/${libdir}/libftdi.so
	ln -sf libhidapi-libusb.so.0 ${D}/${libdir}/libhidapi-libusb.so
	ln -sf libncurses.so.6 ${D}/${libdir}/libncurses.so
	ln -sf libreadline.so.7 ${D}/${libdir}/libreadline.so
	ln -sf libtinfo.so.6 ${D}/${libdir}/libtinfo.so
	ln -sf libusb-0.1.so.4 ${D}/${libdir}/libusb-0.1.so
}
