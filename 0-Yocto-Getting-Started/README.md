# Getting Started with Yocto Project
Follow the steps in the [original website](https://docs.yoctoproject.org/brief-yoctoprojectqs/index.html#yocto-project-quick-build):

- Starting from: [Yocto Project Quick Build](https://docs.yoctoproject.org/brief-yoctoprojectqs/index.html#yocto-project-quick-build)
- Until this section: [Customizing Your Build for Specific Hardware](https://docs.yoctoproject.org/brief-yoctoprojectqs/index.html#customizing-your-build-for-specific-hardware)

After following these steps, you make sure that you:

- have at least 90 Gbytes of free disk space and 8 Gbytes of RAM in your [Build Host](https://docs.yoctoproject.org/ref-manual/terms.html#term-Build-Host) 
- Build your host packages:
  - ``sudo apt install gawk wget git diffstat unzip texinfo gcc build-essential chrpath socat cpio python3 python3-pip python3-pexpect xz-utils debianutils iputils-ping python3-git python3-jinja2 python3-subunit zstd liblz4-tool file locales libacl1``
  - ``sudo locale-gen en_US.UTF-8``
- Clone the Poky repository:
  - ``git clone git://git.yoctoproject.org/poky``
- Checkout to the desired branch of poky repository (will be discussed later):
  - ``cd poky``
  - ``git checkout <<poky_branch>>``
- Build your Image:
  - Initialize the Build Environment: ``oe-init-build-env``
  - Examine Your Local Configuration File (local.conf in poky/build/conf directory). The default machine is set to qemux86 target, which is suitable for emulation.
  - Start the Build: `` bitbake core-image-sato``
  - Simulate Your Image Using QEMU: ``runqemu qemux86-64``
