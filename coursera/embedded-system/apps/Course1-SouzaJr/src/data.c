/**
 * @file data.c
 * @brief This file should do some very basic data manipulation.
 *
 * @author Joao Souza Jr
 * @date Setember 24, 2019
 *
 */
#include "data.h"
#include "platform.h"
#include "stdint.h"

#define AMOUNT_OF_DIGITS 16

uint8_t const digits[] = "0123456789ABCDEF";

int8_t get_num_by_digit(uint8_t digit) {
  int8_t value = -1;
  uint8_t i;
  for (i = 0; i < AMOUNT_OF_DIGITS; i++) {
    if (digits[i] == digit) {
      value = i;
      break;
    }
  }
  return value;
}

uint32_t my_pow(uint32_t x, uint32_t y) {
  if (y == 0) {
    return 1;
  }
  if (y == 1) {
    return x;
  }
  uint32_t result = 1;
  uint32_t i;
  for (i = 0; i < y; i++) {
    result = result * x;
  }
  return result;
}

/***********************************************************
 Function Definitions
***********************************************************/
uint8_t my_itoa(int32_t data, uint8_t *ptr, uint32_t base) {
  uint8_t length = 0;
  uint16_t i = 0;
  int32_t result = data;
  if (data < 0) {
    *ptr++ = '-';
    result *= -1;
    length++;
    i = 1;
  }
  length++;
  result = result / base;
  while (result) {
    ptr++;
    length++;
    result = result / base;
  }
  result = data > 0 ? data : data * (-1);
  for (; i < length; i++) {
    *ptr-- = digits[result % base];
    result = result / base;
  }
  ptr += ++length;
  if (data > 0) {
    *ptr = '\0';
  } else {
    *--ptr = '\0';
  }
  return length;
}

int32_t my_atoi(uint8_t *ptr, uint8_t digits, uint32_t base) {
  int32_t result = 0;
  uint8_t is_negative = 0;
  if (!ptr) {
    return result;
  }
  uint16_t i;
  uint16_t exp = 0;
  ptr += digits;
  ptr--;
  for (i = 0; i < digits; i++) {
    if (*ptr == '-') {
      is_negative = 1;
      break;
    } else if (*ptr) {
      result = result + get_num_by_digit(*ptr) * my_pow(base, exp);
      exp++;
      ptr--;
    } else {
      ptr--;
    }
  }
  if (is_negative) {
    result *= -1;
  }
  return result;
}