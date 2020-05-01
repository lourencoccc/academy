/******************************************************************************
 * Copyright (C) 2017 by Alex Fosdick - University of Colorado
 *
 * Redistribution, modification or use of this software in source or binary
 * forms is permitted as long as the files maintain this copyright. Users are
 * permitted to modify this and use it to learn about the field of embedded
 * software. Alex Fosdick and the University of Colorado are not liable for any
 * misuse of this material.
 *
 ******************************************************************************/
/**
 * @file main.c
 * @brief c2m2v8 Port Pin Configuration Demo
 *
 * This file is used for a live demo of configuring a simple port pin using CCS
 * and the msp432 micrcontroller.
 *
 * @author Alex Fosdick, Joao Souza Jr
 * @date May 28 2017, Dec 28 2019
 *
 */

#include <stdint.h>
#include "msp.h"
//#include "io_msp432.h"

#define LENGTH1 (100000)
#define LENGTH2 (10000)

#define P1_OUT_REG (0x40004C02)
#define P1_DIR_REG (0x40004C04)
#define P2_OUT_REG (0x40004C03)
#define P2_DIR_REG (0x40004C05)
#define BIT_0 (0x01)
#define BIT_GREEN (0x02)
#define BIT_BLUE (0x07)

union example
{
    uint8_t * ptr;
    uint32_t data;
    uint8_t ** dptr;
};

struct exampleq1
{
    uint16_t a:2;
    uint16_t b:3;
    uint16_t c:4;
    uint16_t d;
};

typedef struct CircBuf {

    uint32_t length;

    uint8_t * base;

    uint8_t * head;

    uint8_t * tail;

} CircBuf_t;



void main(void)
{

    uint32_t sizeEx = sizeof(union example);

    CircBuf_t cb;

    uint8_t data = *(cb.head);

    uint32_t i;
    //uint8_t * p1_out = (uint8_t*) P1_OUT_REG; /* pointer to port 1 output register */
    //uint8_t * p1_dir = (uint8_t*) P1_DIR_REG; /* pointer to port 1 direction register */

    uint8_t * p2_out = (uint8_t*) P2_OUT_REG; /* pointer to port 2 output register */
    uint8_t * p2_dir = (uint8_t*) P2_DIR_REG; /* pointer to port 2 direction register */

    /* Stop watchdog timer */
    WDTCTL = WDTPW | WDTHOLD;

    /* Structure Overlay: Configure P1.0 as output */
    P1->DIR |= BIT_0;
    /* Direct Dereference: Configure P1.0 as output */
    //*p1_dir |= BIT_0;
    *p2_dir |= BIT_BLUE;

    /* Code to show LED blinking on and off */
    while (1)
    {
        /* Structure Overlay: Toggle P1.0 */
        P1->OUT ^= BIT_0;
        /* Direct Dereference: Toggle P1.0 */
        //*p1_out ^= BIT_0;
        *p2_dir ^= BIT_BLUE;

        for (i = LENGTH1; i > 0; i--)
            ; /* Delay */
    }
}
