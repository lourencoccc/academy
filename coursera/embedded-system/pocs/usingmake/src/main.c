#include <stdio.h>
#include "mycalc.h"

static int A_VALUE;

int main(void) 
{
    A_VALUE = 10;
    int a = 10 + A_VALUE;
    int b = 5;
    A_VALUE = 1;
    printf("Add: %d + %d = %d\n", a, b, add(a, b));
    printf("Minus: %d - %d = %d\n", a, b, min(a, b));
    return 0; 
}
