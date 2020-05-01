#include <stdio.h>

void bin(unsigned int n)
{
  unsigned int i;
  for (i = 1 << 31; i > 0; i = i / 2)
    (n & i)? printf("1"): printf("0");
}

void main()
{
/*
    bin(7);
    printf("\n");
    signed int num = 0b110101101;
    printf("num %d\n", num);
    printf("\n Q1 \n");
    unsigned int resultOr =  0b10101010 | 0b01010101;
    bin(resultOr);
    int i = 0, foo = 0, bar = 0;
    while( i < 17 ) {
        i++;
        foo += i;
    }
    for( i = 0; i < 17; i++ ) {
        bar += i; 
    }
        unsigned short a = 0xFFFF;
    a = ~( a ^ ( a<<4 ) );
    printf("foo %d, bar %d, a %d\n", foo, bar, a);*/
    int x;
    unsigned int i;
    for ( i = 0 ; i >= 0 ; ) {
        x = (++i);
    }
    return;
    //return 0;
}
