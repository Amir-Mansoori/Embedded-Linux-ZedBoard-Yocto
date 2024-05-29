# NAND function with PL and PS
In this section, we want to create a NAND gate in our Zynq SoC that uses both PL and PS. In the PL we create the AND gate and in the PS we create the NOT logic.
Refer to this [page](https://github.com/Amir-Mansoori/Embedded-Linux-ZedBoard-Buildroot/tree/main/5-NAND-PL-PS#nand-function-with-pl-and-ps) for the details of the design (in Buildroot).

Update the **.xsa** file from the previous part ([5-bitstream-addition](https://github.com/Amir-Mansoori/Embedded-Linux-ZedBoard-Yocto/tree/main/5-Bitstream-Addition#bitstream-addition)) with the new generated .xsa file from the new Vivado design.

Then create the recipe and the C code for the NAND gate application. Follow the same steps in [4-LED-Blink](https://github.com/Amir-Mansoori/Embedded-Linux-ZedBoard-Yocto/tree/main/4-LED-Blink#blinking-led) considering the provided recipe and C code for the NAND application.

Note that unlike the Buildroot that we need to modify the device tree manually, in Yocto, all the information about the device tree is already included in the .xsa file, and the recipes in the meta-xilinx layers will generate the device tree from the .xsa file for us.
