all:
	gcc src/bin/main.c src/lib.c -o my_which

install:
	mv my_which /root/bin/my_which

libmakelib.a: 

	ar rc mylibrary.a foo.o bar.o


clean: /root/build/
	rm -f *.o
	rm -f *.so
	rm -f main