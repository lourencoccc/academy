
#include <stdio.h>
#include <stdint.h>

void main()
{
    uint32_t foo = 0x01234567; 
    foo ^= ~(0x00FFFF00);
    foo = (foo & 2047) | (0x176 << 20);
    printf("%X", foo);    
} 
