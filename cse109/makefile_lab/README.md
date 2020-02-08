# Makefile Lab

## An attempt through example

So here I was in the 9am Montella 109 lab where we were going to learn makefiles. SIKE, lets go through bash commands on a textfile and call it 'build' so we can get some more fundamental understanding. I went on to work for another 2 hours at FML, trying to piece together a makefile with my buld understanding and makefile documentation when my friend in the 3pm lab comes by and tells me they essentially went over the entire lab together in the makefile format. 
*note: facepalm*

Anyways this lab has several C files held in an src folder that are acessed through Makefile to be combined in compilation. Their resulting .o files end up in the build folder, in which they can later be easily cleared.

## Build Instructions 

Well here you have it, running:
```bash
$> make -f Makefile
```
Runs through the makefile to run the factorial, hello, and main. It then puts their .o files in a build folder.

Running
```bash
$> make clean
```
clears the build folder of such files in a swift and decisive fashion.

