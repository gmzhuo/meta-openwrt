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
			git://github.com/gmzhuo/libcore.git;protocol=https \
		"

DEPENDS = "libubox libev ubus curl"

# NOTE: unable to map the following CMake package dependencies: libubox
inherit cmake

OECMAKE_SOURCEPATH = "${S}/src"
# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""


SRCREV = "734125630e0bde6701b8c279d1228596ec75c1ef"
#inherit externalsrc
#EXTERNALSRC = "/data/work/packages/libcore/src"

