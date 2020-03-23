#include "stack.h"
#include <stdlib.h>
#include <stdbool.h>

void initStack(Stack* s, int capacity) {
    s->capacity=capacity;
    s->stack = (char*)malloc(capacity);
    s->top=-1;
}

bool isfull(Stack* s) {
    if (s->top == s->capacity-1) {
        return true;
    } else {
        return false;
    }
}

bool isempty(Stack* s) {
    if (s->top < 0) {
        return true;
    } else {
        return false;
    }
}

void printstack(Stack* s) {
    for (int i=0; i<s->capacity; i++) {
        printf("%x  %d\n", &(s->stack[i]), s->stack[i]);
    }
}

void push(Stack* s, void* x) {
    //test if the stack is full
    if (!isfull) {
        s->top = s->top + 1;
        s->stack[s->top] = x;
    } else {
        printf("Stack overflow!");
        exit(1);
    }   
}

char peek(Stack* s) {
    return s->stack[s->top];
}

char pop(Stack* s) {
    char to_return = s->stack[s->top];
    s->stack[s->top] = 0;
    s->top = s->top - 1;
    return to_return;
}