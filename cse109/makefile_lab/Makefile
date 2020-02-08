#using CC as the directed compiler
CC=gcc
#CFLAGS will be passed to the compiler
CFLAGS=-c -Wall
OFLAGS=-o
SRC=src/
INCLUDE=-Iinclude
BUILD=build/


all: hello
	mv main.o $(BUILD)main.o
	mv factorial.o $(BUILD)factorial.o
	mv hello.o $(BUILD)hello.o

hello: main.o factorial.o hello.o
	$(CC) main.o factorial.o hello.o $(OFLAGS) $(BUILD)hello

main.o: $(SRC)main.c
	$(CC) $(CFLAGS) $(SRC)main.c $(INCLUDE) $(OFLAGS) main.o

factorial.o: $(SRC)factorial.c
	$(CC) $(CFLAGS) $(SRC)factorial.c $(INCLUDE) $(OFLAGS) factorial.o

hello.o: $(SRC)hello.c
	$(CC) $(CFLAGS) $(SRC)hello.c $(INCLUDE) $(OFLAGS) hello.o

clean: ./build
	rm $(BUILD)*.o $(BUILD)hello