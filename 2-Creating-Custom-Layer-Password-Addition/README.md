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

Notice that you should use a hashed password which you can generate using this command:

``openssl passwd -5``

Also notice in this part of the recipe:

``EXTRA_USERS_PARAMS = "usermod -p <hashed password> root;"``

that you need to insert a `\` before the `$` signs in the generated hashed password.

At the end go to the poky directory and run:

``bitbake custom-image``

It will create the images and files for linux booting with the password.

