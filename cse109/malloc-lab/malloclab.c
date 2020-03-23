#include <stdio.h>
#include <stdlib.h>
#include <string.h>

double multiplyByTwo (double* input) {
  double* twice = malloc(sizeof(double)*2);
  *twice = *input * 2;
  return *twice;
  free(twice);
}

int main (int argc, char *argv[])
{
  int* age = malloc(sizeof(int));
  *age = 30;
  double* salary = malloc(sizeof(double));
  *salary = 12345.67;
  //https://stackoverflow.com/questions/38621377/how-to-do-one-line-assignment-to-malloc-arrays-in-c
  double *myList = memcpy(malloc(sizeof *myList * 3), 
    (double[3]) {1.2, 2.3, 3.4}, sizeof *myList * 3);

  printf("double your salary is %.3f\n", multiplyByTwo(salary));
  free(age);
  free(salary);
  free(myList);
  return 0;
}