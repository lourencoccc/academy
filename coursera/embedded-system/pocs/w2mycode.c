#include <stdio.h>

#pragma  X86
#pragma  ARM

// gcc -DARM -o w2mycode.out w2mycode.c

int main(void){
#ifdef X86
  printf("Hello World X86!\n");
#elif ARM
  printf("Hello World ARM\n");
#else
  printf("Hello World NONE\n");
#endif
  return 0;
}

