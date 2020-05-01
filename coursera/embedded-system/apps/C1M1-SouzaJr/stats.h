/******************************************************************************
 * Copyright (C) 2017 by Alex Fosdick - University of Colorado
 *
 * Redistribution, modification or use of this software in source or binary
 * forms is permitted as long as the files maintain this copyright. Users are 
 * permitted to modify this and use it to learn about the field of embedded
 * software. Alex Fosdick and the University of Colorado are not liable for any
 * misuse of this material. 
 *
 *****************************************************************************/
/**
 * @file stats.h
 * @brief Funcions declarations to produces analytic report with statistics of an array
 *
 * Functions that can analyze an array of unsigned char data items and report analytics 
 * on the maximum, minimum, mean, and median of the data set.
 *
 * @author Joao Souza Jr
 * @date 2019-05-05
 *
 */
#ifndef __STATS_H__
#define __STATS_H__

/**
 * @brief The main entry point for your program
 *
 */
void main();

/**
 * @brief A function that prints the statistics of an array
 *
 * A function that prints the statistics of an array including minimum, maximum, mean, and median
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 * 
 * @return void
 */
void print_statistics(unsigned char * data, unsigned int length);


/**
 * @brief A function that prints the array to the screen
 *
 * Given an array of data and a length, prints the array to the screen
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 * 
 * @return void
 */
void print_array(unsigned char * data, unsigned int length);

/**
 * @brief A function that returns the median value
 *
 * Given an array of data and a length, returns the median value
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 *
 * @return An unsigned char result with the median value
 */
unsigned char find_median(unsigned char * data, unsigned int length);

/**
 * @brief A function that returns the mean
 *
 * Given an array of data and a length, returns the mean.
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 *
 * @return An unsigned char result with the mean value
 */
unsigned char find_mean(unsigned char * data, unsigned int length);

/**
 * @brief A function that returns the maximum
 *
 * Given an array of data and a length, returns the maximum
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 *
 * @return An unsigned char result with the maximum value
 */
unsigned char find_maximum(unsigned char * data, unsigned int length);

/**
 * @brief A function that returns the minimum
 *
 * Given an array of data and a length, returns the minimum
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 *
 * @return An unsigned char result with the minimum value
 */
unsigned char find_minimum(unsigned char * data, unsigned int length);

/**
 * @brief A function that prints the statistics of an array
 *
 * Given an array of data and a length, sorts the array from largest to smallest. 
 * The zeroth Element should be the largest value, and the last element (n-1) 
 * should be the smallest value.
 *
 * @param data A unsigned char pointer to an n-element data array
 * @param length An unsigned integer as the size of the array
 * 
 * @return void
 */
void sort_array(unsigned char * data, unsigned int length);

#endif /* __STATS_H__ */
