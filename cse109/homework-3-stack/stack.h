#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//TODO: make the 
typedef struct {
    char capacity;
    void* stack;
    int top;
}Stack;

void initStack(Stack* s);
bool isfull(Stack* s);
bool isempty(Stack* s);
void printstack(Stack* s);
void push(Stack* s, void* x);
void* peek(Stack* s);
void* pop(Stack* s);