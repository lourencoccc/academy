

1. uint32_t foo = 0x01234567;	foo ^= ~(0x00FFFF00);foo = (foo & 2047) | (0x176 << 20);

0x17600598


2. GPIO Port 2 pin mode is set by which register?

P1DIR

P2OUT

P1SELx

**P2SELx**

P1IN

3. The CMSIS library is what?

* A hardware abstraction library
* An ARM Core Architecture Library

The C-Standard Library

Provide an interface to java programming



Given a 32-bit architecture, a void pointer will dereference how much data?

8 Bits

16 Bits

* 32 Bits

64 Bits

Cannot be dereferenced


A double pointer

Is a method to help optimize pointer usage by the compiler

Points to a pointer of the same type

* Requires a double dereference to access the address of the pointer

Cannot be used to dereference data memory

Can only be used in conjunction with void pointers



## Week 3

1. Overall, how many bits in this structure definition will be used out of the overall structure allocation (as compared to how many are unused or used as padding)?

        struct example {
            uint16_t a:2;
            uint16_t b:3;
            uint16_t c:4;
            uint16_t d;
        };

* 32 bits are being used

2. Which structure definition represents a singly linked list structure?


        struct node {
            uint32_t data;
            struct node * next;
        };

3. What is the size of this union definition below given the MSP432 32-bit architecture?

        union example {
            uint8_t * ptr;
            uint32_t data;
            uint8_t ** dptr;
        };

* 4 bytes


4. Enumeration data sizes are always the size of a word?

* False

5. Enumeration values can range from:

* Negative and positive numbers

Factional values from 0.0 to 25.5 incrementing by 0.1

* The unsigned range of the word

* The signed range of a word

6. When designing an abstract data structure, you usually also need to:

* Define the function interfaces for the structure to add, remove, read, or write data

* Ensure proper use of the data structure by checking bounds or even restricting public access to certain internal member variables

Require users to dynamically allocate your data structure on the heap

* Define the internal structure members of the associated abstruct data structure type


7. Given the circular buffer structure defined below, which code would correctly read the data stored at the head pointer? (Assume the buffer has been initialized)

        typedef struct CircBuf {
            uint32_t length;
            uint8_t * base;
            uint8_t * head;
            uint8_t * tail;
        } CircBuf_t;

        CircBuf_t cb;

        uint8_t data;

* data = *(cb.head);

When removing an item to a FIFO buffer, what operations do you need to perform?


* Check for Empty Buffer

* Check for Full Buffer

Check if pointers are not NULL pointers

Check boundaries if the tail pointer is near the end

Increment the head pointer to next available spot

* Increment the tail pointer to point to the next item or the beginning


## Week 3 - Final Quiz

1. List some characteristics of a FIFO Buffer.

Items added are typically different types

* Requires a contiguous block of memory

* Requires a data structure to manage the block of memory

Data is added and removed from the same end

2. True or False: LIFO Buffer instances can be allocated both dynamically and statically.

* True

False

3. What keyword should be used on the buffer members if it is being used between main and an Interrupt subroutine in a produce consumer model?

Restrict

__attribute__((packed))

Const

* volatile

Global


4. Enumerations...

Can be used to define a data structure

* be used to define error codes

* Have a size that is Architecture dependent (EABI)

* Can define numerous constants of the same value

Are usually defined with lower case letters

5. Encapsulation is important to use with data structures because

* It ensures that structure members are accessed through consistent methods using an interface

* It often provides get and set operations for data structures

* It forces interaction with the structure to happen only in provided routines protecting from incorrect use

* It reduces the opportunity to introducing bugs to using a data structure

6. True or False: Bit field use implicitly uses bit manipulation.

* True

False

7. Unions...

Have a size dependent on the smallest declared member in the union

* Have elements that occupy the same base address

Do not allow you to create pointers to unions

* Unions are accessed using the dot operator