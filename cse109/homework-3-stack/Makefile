all: main

main: main.o libstack.a
	gcc main.o -o main -lstack

main.o:
	gcc -c main.c

libstack.a: lib.c
	gcc -c lib.c
	ar rs libstack.a lib.o
