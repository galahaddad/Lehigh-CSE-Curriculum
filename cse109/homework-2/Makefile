all: main
	mkdir -p build/bin
	mkdir -p build/objects
	mkdir -p build/lib
	mv *.o build/objects
	mv *.a build/lib
	mv my_which build/bin

libwhichtools.a: src/lib.c
	gcc src/lib.c -c -I include
	ar rs libwhichtools.a lib.o

main: main.o libwhichtools.a
	gcc main.o -o my_which -L. -lwhichtools 

main.o: src/bin/main.c
	gcc src/bin/main.c -c -I include

install:
	mv build/bin/my_which /root/bin/

clean:
	rm -rf build