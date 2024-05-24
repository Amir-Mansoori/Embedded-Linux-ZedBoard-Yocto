# Creating a custom layer for password addition
In this section we create a custom layer in Yocto to add a password to the root user. Use this command to create **meta-custom** layer in the directory that contains the poky repository:

```
$ cd poky/../
$ bitbake-layers create-layer meta-custom
$ ls meta-custom/
COPYING.MIT  README  conf  recipes-example
```
Inside meta-custom layer, create a directory (recipe-core) that contains the recipe for our custom layer:

``$ mkdir -p recipes-core/images``

Next, copy the recipe for the core-image-minimal to this directory. We want to start from core-image-minimal.bb recipe and modify its contents in the meta-custom layer:

``$ cp <Yocto_path>/poky/meta/recipes-core/images/core-image-minimal.bb <Yocto_path>/meta-custom/recipes-core/images/custom-image.bb``

Now you can modify the content of the custom-image.bb recipe. Check the custom-image.bb file in this repository.



