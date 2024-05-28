## Creating a Hello World Application

In Yocto, we need to create a recipe for any embedded application. While in Buildroot we can directly apply a cross-compiler tool on our C code to obtain the executable file for our application, in Yocto we must provide a recipe containing all the information about our cross-compiler, the storage location of our C code, the dependencies required to build the application and other meta-data. These recipes (with a .bb extention) are then processed by the bitbake command to find and compile the code for us and store the executable in the root file system location.

We must create a recipe even for a simple Hello World application. here is the process to create the recipe for the Hello-World application:

1- Create **recipes-apps** directory inside **meta-custom** layer. It contains all our applications including Hello-World:
```
  $ cd meta-custom	
  $ mkdir -p meta-custom/recipes-apps/hello/
```
2- Copy the provided **hello-world_0.1.bb** recipe file in this repository to the recipes-apps/hello/ directory

3- Create files/src/ directory and copy the provided **hello-world.c** application code inside the src directory

4- Note that after creating your application, you must add it to the final image. To do this, you must add this line inside ``meta-custom/recipes-core/images/``**``custom-image.bb``**:
	
 ``IMAGE_INSTALL += "hello-world"  ``

5- Finally, you will run the bitbake command again `bitbake custom-image``

