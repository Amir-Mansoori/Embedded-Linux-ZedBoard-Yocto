## Adding Meta Layers for Xilinx Devices
To customize the target hardware for the ZedBoard, we need to add the meta-xilinx layers. Go to poky directory and add the following layers:
meta-openembedded, meta-xilinx, meta-xilinx-tools.

You can follow the [Build instructions](https://github.com/Xilinx/meta-xilinx/blob/master/README.building.md) on the meta-xilinx layer.

Pay attention that **AMD 2023.2** release is based on **Langdale (4.1.4)** branch, so checkout the poky branch to Langdale (4.1.4) and clone the Langdale branch for all the meta-xilinx layers:
```
git clone -b Langdale https://git.openembedded.org/meta-openembedded.git
git clone -b Langdale https://github.com/Xilinx/meta-xilinx.git
git clone -b Langdale https://github.com/Xilinx/meta-xilinx-tools.git
```
### Adding Dependency layers:
- ``cd poky``
- ``source oe-init-build-env``
- configure ``bblayers.conf`` (poky/build/conf/bblayers.conf) by adding dependency layers as shown below using ``bitbake-layers`` command:
  ```
  bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-oe
  bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-python
  bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-filesystems
  bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-networking
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-microblaze
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-core
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-standalone
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-bsp
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-vendor
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-contrib
  bitbake-layers add-layer ./<path-to-layer>/meta-xilinx-tools
  ```
### Machine Configuration for ZedBoard
Set the machine configuration in local.conf to zedboard-zynq7:
- ``MACHINE ?= "zedboard-zynq7"``

If you receive a warning in the build process related to xilinx license, you can add this line to the local.conf file:
- ``LICENSE_FLAGS_ACCEPTED += "xilinx"``

After following the build instructions on meta-xilinx layer, run the build command for core-image-minimal:
- ``bitbake core-image-minimal``

This will generate the linux image and root file system required for the booting on the target.
### Prepare the SD card
Now you can prepare your SD card by storing the required files and images.

[This page](https://github.com/Xilinx/meta-xilinx/blob/master/docs/README.booting.storage.md#booting-from-sd-or-emmc) explains the instructions for booting Xilinx devices with SD card.

Note that the generated files are located in this directory:

``${DEPLOY_DIR_IMAGE} = poky/build/tmp/deploy/images/zedboard-zynq7/``

You need to:

1- Create two partitions in the SD card:
  - FAT32, 800 MB (``/mnt/boot/``)
  - EXT4, Rest of the SD card (``/mnt/rootfs/``)

You can use the ``fdisk`` and ``mkfs`` commands to create the two partitions and format them with the corresponding file systems.



2- Copy the required files based on the above-mentioned page.

The following files must be copied to the FAT32 partition:
```
cp ${DEPLOY_DIR_IMAGE}/boot.bin /mnt/boot/boot.bin
cp ${DEPLOY_DIR_IMAGE}/boot.scr /mnt/boot/boot.scr
cp ${DEPLOY_DIR_IMAGE}/Image /mnt/boot/Image
cp ${DEPLOY_DIR_IMAGE}/system.dtb /mnt/boot/system.dtb
```

The following command is to extract the root file system in the EXT4 partition:
```
sudo tar -xf ${DEPLOY_DIR_IMAGE}/core-image-minimal-${MACHINE}-${DATETIME}.rootfs.tar.gz -C /mnt/rootfs
sync
```
