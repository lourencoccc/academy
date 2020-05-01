
### MSP432P401R

Processor: http://www.ti.com/product/MSP432P401R
Development Kit: http://www.ti.com/tool/MSP-EXP432P401R


### Bit Manipulation

Q1 - True or False: Bit manipulation changes all bits of the registers.

Answer: **Fasle**

Q2 - What is the value of foo after the following operation:
uint8_t foo = 0xff;
foo &= ~(0xc0);

Answer: **0x3f**

Q3 - True or False: Preprocessed macros take up space in code memory.

Answer: **False**

Macros get replaced into the code by their corresponding values during 
pre processing and do not take up space in code memory.

Q4 - Bit-banded regions impact the system in which of the following ways (Mark all that apply):

Answer:

* **False:** They increase the number of instructions
* **True:** They reduce the total memory available
* **True:** They allow atomic read, modify, and write

Reference:
* http://infocenter.arm.com/help/index.jsp?topic=/com.arm.doc.dui0553a/CHDBIBGJ.html
* http://infocenter.arm.com/help/topic/com.arm.doc.dui0553b/DUI0553.pdf

### IO Port COnfiguration Example

Q1 - True or False: The I/O pins of the MSP432 have only one function associated with them.

Answer: **Fasle**

Q2 - Which of the following are true for the MSP432 PxDIR register?

Answer:

* **PxDIR = 0 for Input**
* **PxDIR = 1 for output**

Q3 - If a pin is configured to be in output mode and the corresponding bit in the PxOUT register is set to 0, the pin will be:

Answer: Set to GND


### Creating Software Interfaces for Hardware

Q1 - CMSIS is an interface for the:

Answer: **ARM Core**

Q2 - True or False: Macro functions can be defined to allow data returns.

Answer: **True**

Q3 - Functions with the inline keyword have the following attributes: (Mark all that apply)

Answer:

* **True:** They allow C programming type checking
* **True:** They skip the calling convention
* **True:** They are just a suggestion and functions may not be inlined
* **False:** They are supported in the c89 standard

### Advanced Pointer Use

Q1 - Void pointers have which of the following properties? (Mark all that apply)


Answer:

* **False:** Can dereference data
* **True:** Can dereference data after being cast to a type
* **False:** Can support pointer arithmetic
* **True:** Can point to a memory location


Q2 - What are the final values of foo?

| Address | Value |
| ------- | ------|
| 0x10    | 0x13  |
| 0x11    | 0xff  |
| 0x12    | 0x03  |
| 0x13    | 0x77  |

```c
uin8_t *ptr1 = (uint8_t *)0x10;
uint8_t **dptr = &ptr1;
uint8_t *ptr2 = **dptr;
uint8_t foo = * ptr2;
```

Answer: **0x77**

### Function Pointers

Q1 - True or False: Dereferencing a function pointer gives us access to code memory.

Answer: **True**

Q2 - Which of the following is a valid function pointer array?

Answer: 
```c 
uint8_t (* foo[5])(); 
```

Q3 - True or False : The interrupt vector table is an array of function pointers that are indexed according to priority.

Answer: **True**


### Debugging a Microcontroller Program Part 1

Q1 - To debug an embedded system, which of the following are required? (Mark all that apply)

* **True:** Debugging symbols must be enabled
* **True:** Bootloader/Program Flasher
* **True:** Debugger Software
* **False:** Debugger hardware

Q2 - True or False: There is no restriction on the number of breakpoints that can be set on an embedded system.

Answer: **False**

Q3 - True or False: It is necessary to pause the operation of a system in order to read memory, registers, or watch expressions.

Answer: **True**

### Enumerations

Q1 - True or false: The definition of an enumeration takes up memory:

Answer: **False**

Q2 - What is the value of the enumerated value for LL_NULL?

    typedef enum { 
        LL_NO_ERROR = 3, 
        LL_FULL, 
        LL_EMPTY, 
        LL_NULL,
    } LL_Status_e;

Answer: **6**

Q3 - True or false: Enumerations can have negative values.

Answer: **True**

### Unions

Q1 - All elements of a union will access:

Answer: **Same memory**

Q2 - Given the following definition, the value of sizeof(test) is:

    typedef union { 
        uint8_t a; 
        int16_t b[10];
        uint32_t c[5];
    } test;

Answer: **20 bytes**

### Structures and Encapsulation

Q1 - The definition of a structure needs which of these (Mark all that apply):

* **True:** Name of the structure
* **True:** List of members
* **True:** The struct keyword
* **False:** The size of the structure

Q2 - Passing structure pointers to a function is beneficial because (Mark all that apply):

* **True:** It reduces the size of the arguments the function needs.
* **True:** It allows the function to return changes.
* **True:** It makes the operation more portable.

Q3 - True or false: Abstract data structures require a definition and an interface to work with.

Answer: **True**

### Bit Fields

Q1 - Is the following bit field definition correct?

    struct test { 
        uint16_t x:8; 
        uint16_t y:4; 
        uint16_t z:5;
    }

Answer: **No** - The total number of bit fields assigned is greater than the size of the data type being used


### LIFO Buffer

Correction:

This buffer will always track the next available head spot. However, this can cause out of range buffer indexing which could create compile-time warnings and errors. An alternative and better way to build this would be to have the head track the last item added. This way you never index out of range with your structure. An example definition is below:


    typedef struct LIFO_Buf {
        uint32_t length;
        uint8_t * base;
        uint8_t * head;
    } LIFO_Buf_t;

    LB_Status LIFO_Is_Buf_Full(LiIFO_Buf_t * lbuf) {
        /* Checks if buffer is initialized */
        if ( ! lbuf || ! lbuf->head || ! lbuf->base) {
            return LB_NULL;
        }

        /* Checks if in the ragen of buf[0] < index < buf[length] */
        if ( lbuf->head == lbuf->base + (lbuf->length - 1) ){
            return LB_FULL:
        } else {
           return LB_NOT_FULL;
        }
    }

    LB_Status LIFO_Add_Item(LiIFO_Buf_t * lbuf, uint8_t item) {

        /* Checks if buffer is initialized */
        if ( ! lbuf || ! lbuf->head || ! lbuf->base) {
       
            return LB_NULL;
        }
        /* Checks if buffer is full */
        if ( LIFO_Is_Buf_Full(lbuf) == LB_FULL ){
            return LB_FULL:
        }
        lbuf->head++;
        *lbuf->head = item;
        return LB_NO_ERROR;
    }


### Circular Buffer - FIFO

Correction:

This buffer shows that it will add the item in before it adjusts the pointer. Instead to be consistent with our definition of CB_Is_Buf_Full(), the line that adds the item in should come after the check for the head pointer. In this corrected definition, the head always tracks the last added item, where in the slides it tracks the next available spot.

An example definition is below:

    CB_Status CB_Add_Item(CB_Buf_t * cbuf, uint8_t item) {
        /* Checks if buffer is initialized */        
        if ( ! cbuf || ! cbuf->head || ! cbuf->base) {
            return CB_NULL;
        }

        /* Checks if the buffer is Full */
        if ( CB_Is_Buf_Full(lbuf) == CB_FULL ){
            return CB_FULL;
        }

        /* Checks if buffer is at the end of the allocated region, moves to beginning if so */
        if ( cbuf->head == cbuf->head + (cbuf->length -1 ) ) {
            cbuf->head = cbuf->base;
        }

        else {
            cbuf->head++;
        }

        *cbuf->head = item;

        return CB_NO_ERROR;
    }

### Linked List

Correction:

This linked list definition uses a typedef. However, you must fully define the linked list without the typedef first before you can use it inside the structure. So therefore, the linked list should be defined like one of the example below:

    typedef struct node { 
        struct node * next;
        uint32_t data;
    } Node_t;

    struct node { 
        struct node * next;
        uint32_t data;
    };


Correction:

This example using a double dereference has numerous errors and instead you should reference the previous slides for an example. Typically linked list add functions return a point to a linked list that way if you create one, or add a new element, you can return a reference the list you are working with. Alternatively, you could allocate the node before the append function is even called. In this case, you would pass in your list and your new node to add without having to call malloc inside the append function. An example is seen below:

    /* Function Declaration for Append Node */
    void LL_Append ( struct * list, struct * node);

    struct node my list;

    struct node * my list_p = &my_list;

    struct node * new_node = (struct node *) malloc ( sizeof(struct node));

    LL_Append (&my_list, new_node);

    /* Alternatively *;

    LL_Append (my_list_p, new_node);

