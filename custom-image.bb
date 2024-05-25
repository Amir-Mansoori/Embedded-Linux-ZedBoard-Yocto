SUMMARY = "A Custom Linux image."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit extrausers

IMAGE_ROOTFS_SIZE ?= "8192" 
IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "", d)}"

#Change root password
EXTRA_USERS_PARAMS = "usermod -p '\$5\$cy5MfzRkeFp2.Snw\$FvDY0GSlnzcbcNCBxoyMYX2dywK2h00k1r7JiEj5Ev0' root;"


IMAGE_INSTALL += "hello-world"
IMAGE_INSTALL += " libgpiod libgpiod-dev libgpiod-tools"
IMAGE_INSTALL += "led"
IMAGE_INSTALL += "nand"
IMAGE_INSTALL += "openssh"
