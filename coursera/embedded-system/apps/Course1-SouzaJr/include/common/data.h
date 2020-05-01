/**
 * @file data.h 
 * @brief This file should do some very basic data manipulation. 
 *
 * @author Joao Souza Jr
 * @date Setember 24, 2019
 *
 */
#ifndef __DATA_H__
#define __DATA_H__

#define BASE_10 10
#define BASE_16 16

#include <stdint.h>

/**
 * @brief Integer-to-ASCII
 * 
 * Convert data from a standard integer type into an ASCII string.
 * 
 * @param data The number you wish to convert
 * @param ptr Copy the converted character string to the uint8_t*
 * @param base The bases supported is 2 to 16
 * 
 * return uint8_t The number of digits in your character set
 */
uint8_t my_itoa(int32_t data, uint8_t * ptr, uint32_t base);

/**
 * @brief ASCII-to-Integer
 * 
 * Convert data back from an ASCII represented string into an integer type.
 * 
 * @param ptr Pointer to data array
 * @param digits The number of digits in your character set
 * @param base The bases supported is 2 to 16
 * 
 * @return int32_t
 */
int32_t my_atoi(uint8_t * ptr, uint8_t digits, uint32_t base);

#endif /* __DATA_H__ */