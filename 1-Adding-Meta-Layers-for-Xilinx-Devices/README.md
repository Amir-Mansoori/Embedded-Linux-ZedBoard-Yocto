## Adding Meta Layers for Xilinx Devices
To customize the target hardware for the ZedBoard, we need to add the meta-xilinx layers. Go to poky directory and add the following layers:
meta-openembedded, meta-xilinx, meta-xilinx-tools.

You can follow the [Build instructions](https://github.com/Xilinx/meta-xilinx/blob/master/README.building.md) on the meta-xilinx layer.

Pay attention that **AMD 2023.2** release is based on **Langdale (4.1.4)** branch, so checkout the poky branch to Langdale (4.1.4) and clone the Langdale branch for all the meta-xilinx layers:

- ``git clone -b Langdale https://git.openembedded.org/meta-openembedded.git``
- ``git clone -b Langdale https://github.com/Xilinx/meta-xilinx.git``
- ``git clone -b Langdale https://github.com/Xilinx/meta-xilinx-tools.git``

### Adding Dependency layers:
- ``cd poky``
- ``source oe-init-build-env``
- configure ``bblayers.conf`` (poky/build/conf/bblayers.conf) by adding dependency layers as shown below using ``bitbake-layers`` command:
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-oe``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-python``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-filesystems``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-openembedded/meta-networking``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-microblaze``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-core``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-standalone``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-bsp``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-vendor``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx/meta-xilinx-contrib``
  - ``bitbake-layers add-layer ./<path-to-layer>/meta-xilinx-tools``
### Machine Configuration for ZedBoard
Set the machine configuration in local.conf to zedboard-zynq7:
- ``MACHINE ?= "zedboard-zynq7"``

If you receive a warning in the build process related to xilinx license, you can add this line to the local.conf file:
- ``LICENSE_FLAGS_ACCEPTED += "xilinx"``

After following the build instructions on meta-xilinx layer, run the build command for core-image-minimal:
- ``bitbake core-image-minimal``
### Prepare the SD card
Now you can prepare your SD card by storing the required files and images.
