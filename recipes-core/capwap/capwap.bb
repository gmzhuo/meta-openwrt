# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
S = "${WORKDIR}/git"

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = " \
			git://github.com/gmzhuo/capwap.git;protocol=https \
		"

DEPENDS = "libubox libev ubus curl util-linux libcore libunwind openssl vpp-core vpp-libmemif libnl"

inherit cmake
OECMAKE_SOURCEPATH = "${S}/src"
TOOLCHAIN_OPTIONS += " -Wall -fpermissive "
CXXFLAGS += " -std=c++17 "

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = " -DCOMPILE_WITH_VCL=1 "
#OECMAKE_TARGET_COMPILE = "AC"
#OECMAKE_TARGET_INSTALL = "AC"

do_install_append() {
	mkdir -p ${D}/usr/share/vpp/scripts/
	mkdir -p ${D}/usr/bin
	cp ${S}/files/interface-up.txt ${D}/usr/share/vpp/scripts/interface-up.txt
	cp ${B}/AC* ${D}/usr/bin/ -rfd
}

FILES_${PN} += " \
			/usr/share/vpp/scripts/interface-up.txt \
			"

SRCREV = "886415bdaaaa62b0f9aca5c39a587a57e9e6ef7b"

