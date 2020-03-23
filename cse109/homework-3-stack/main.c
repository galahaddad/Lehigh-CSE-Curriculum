#include "stack.h"

int main(void) {
    Stack* my_stack;
    my_stack = (Stack*)malloc(sizeof(Stack));
    initStack(my_stack, 5);

    push(my_stack, 3);
    push(my_stack, 4);
    push(my_stack, 5);

    printstack(my_stack);


    //MALLOC MUST BE BALANCED WITH THE SAME NUMBER OF FREES
    free(my_stack->stack);
    free(my_stack);   
}