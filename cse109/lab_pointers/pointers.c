/*
Name: Ralph Haddad
Lehigh e-mail id: ralphhaddad777@gmail.com

Instructions: For each problem, write the English interpretation of each line of code. 
For each problem, indicate what the memory would contain after the associated line is execuated. 
Indicate a memory location with teh & symbol.

 For instance:

  //Ex1: Declare an interger pointer called integer_ptr
  // Memory: integer_ptr - Uninitialized
  int *integer_ptr;
  
  //Ex2: Declare an integer called integer with the value 10
  // Memory: integer_ptr = Uninitialized, integer = 10
  int integer = 10;
  
  // Ex3: Set the value of integer_pointer to the address of integer
  // Memory: integer_ptr = &integer, integer = 10
  integer_pointer = &integer
  

*/

#include <stdio.h>

int main()
{
  // Problem 1: Declares a pointer char
  // Memory: char_ptr = uninitialized of size 8
  char* a;
  printf("Size of a: %lu\n", sizeof(a));  //just exploring pointer sizes here
  
  // Problem 2: Declares a pointer char 
  // Memory: char_ptr = uninitialized size 8
  int* b;
  printf("Size of b: %lu\n", sizeof(b));

  // Problem 3: declares an integer c with value 1632
  // Memory: integer_ptr = uninitialized size 4, integer = 1632
  int c = 1632;
  printf("Size of c: %lu\n", sizeof(c));

  // Problem 4: declares a char d with value 96
  // Memory: integer_ptr = uninitialized of size 1, char = 96
  char d = 96;
  printf("Size of d: %lu\n", sizeof(d));

  // Problem 5: pointer variable b to ram memory location c
  // Memory: char_ptr = unititialized, points to memory location in c
  b = &c;
  printf("Size of b pointing to c: %lu\n", sizeof(b));
  
  // Problem 6: points variable b to memory location c
  // Memory: char_ptr = initialized, points to location d in ram
  a = &d;
  printf("Size of a pointing to d: %lu\n", sizeof(a));

  // Problem 7: converts char* a to int* b, 
  //            however a was previously used in the file to point to d = 96
  // Memory: integer_ptr = uninitialized of size 8, char = 96
  *a = *b;
  printf("Size of a equal to to d: %lu\n", sizeof(a));
  printf("Value of a: %d", *a);

  return 0;
}