#ifndef __IO_MSP432_H__
#define __IO_MSP432_H__

#include <stdint.h>
#include "msp.h"
//FIXME need to create DIO_PORT_Type
__attribute__( ( always_inline ) ) static inline void IO_Read(DIO_PORT_Type * port, uint8_t pin)
{
   return ( ((port)->IN) & (1 << pin) );
}

//FIXME need to create DIO_PORT_Type
__attribute__( ( always_inline ) ) static inline void IO_Write(DIO_PORT_Type * port, uint8_t pin, uint8_t value)
{
   value ? ( ((port)->OUT) |= (1 << pin) ) : ( ((port)->OUT) &= ~(1 << pin) ) ;
}


#endif /* __IO_MSP432_H__ */
