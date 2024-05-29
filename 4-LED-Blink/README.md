# Blinking LED
In this section, we want to toggle an LED on our ZedBoard for 10 times every 1 second.

The LED that we use is connected to the PS MIO7. In ZedBoard, there are 54 MIO pins and 64 EMIO pins (extended to PL), so in total there are 118 pins.

Similar to the Hello-World application, we need to create a recipe. In our **meta-custom** layer, in the **recipes-apps** directory create the **led** directory that contains our recipe:

```
cd meta-custom/recipes-apps/
mkdir led
```

Then add the **led_0.1.bb** recipe from this reposiroty to the **led/** directory
Note that we need to add the libgpiod for our application, so libgpiod is added as a Dependency and as the LDFLAGS option:
```
# Adding the gpiod.h library
DEPENDS = "libgpiod"

#pass arguments to linker
LDFLAGS := "-lgpiod"
TARGET_CC_ARCH += "${LDFLAGS}"

```
After that you need to add the C code application. Copy the **led.c** file from this reposiroty to the **led/files/src/** directory.
Note that the exact gpiochip number might be different and it is better that you check the exact port after booting the linux on ZedBoard for the first time.

``const char *chipname = "/dev/gpiochip<number>"; // the exact number can vary ``

Then, we must install the libgpiod library and install (call) the led application recipe in the custom layer recipe. Note that in ``meta-custom/recipes-core/images/custom-image.bb``, these lines are added:

```
IMAGE_INSTALL += " libgpiod libgpiod-dev libgpiod-tools"
IMAGE_INSTALL += "led"
```

