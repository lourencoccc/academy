//**** Documentation Section
// This Program calculates the area of  square shaped rooms
// Author: Ramesh Yerraballi  and Jon Valavano
// Date:   6/28/2013

// Pre-processorr Directives Section
//  INCLUDES: Lists any external libraries we will refer to using
//  a #include tag
#include <stdio.h>  // Diamond braces for sys lib: Standard I/O
#include "uart.h"   // Quotes for user lib: UART lib

//Global variables
unsigned long error;
	
//Function Prototypes
void initialize(void);
unsigned long calc_area(unsigned long side);

// Subroutines section
// MAIN: Mandatory subroutine for a C Program to be executable
int main(void) {
	unsigned long side; // romm wall meters
	unsigned long area; // size squared meters
	
	UART_Init();   // call subroutine to init uart lib
	initialize();
	printf("This program calculates areas of square shaped rooms\n");
	
	// side = 1; // meters
	// area = calc_area(side); // squere meters
	// printf("Area of the room with side of %ld m is %ld sqr m\n", side, area);
	
	while(1){
		//side = side + 1;
		printf("Gice  room side (zero to quit):");
		scanf("%ld", &side);
		area = calc_area(side);
		if(area != 0){
			printf("Area of the room with side of %ld m is %ld sqr m\n", side, area);
		} else {
			printf("\n Size cannot exceed 25 meters\n");
		}
		printf("Goodbye (Mistake count =%ld)\n", error);
	}
	
}

// Initialize
// Inputs: none
// Outputs: none
// Notes: ...
void initialize(void){
	error = 0;
}

// Calculates area
// Input: side (unsigned long)
// Output: area (unsigned long)
// Notes: ...
unsigned long calc_area(unsigned long side){
	unsigned long result;
	
	if(side <= 25){
		result = side * side;
	} else {
		result = 0; // mistake
		error = error + 1;
	}
	
	return result;
}
	
