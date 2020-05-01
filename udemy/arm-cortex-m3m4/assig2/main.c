#include <stdint.h>
#include "stm32f4xx.h"


int is_privileged_access()
{
	//checking the 0th bit of the CONTROL register
	if ( (__get_CONTROL() & 0x01) )
	{
		return 0;//we are in unprivileged access level
	}
	else
	{
		return 1;//we are in privileged access level
	}
}

void EXTI0_IRQHandler(void)
{
	//clearn the exti0 pended interrupt
	if( (EXTI->PR & 0x01) )
	{
		EXTI->PR &= 0x01;
	}
	
	//led_toggle(LED_4);
	
	//Now, we are iin handler mode at this stage, you change the proceesor
	//Here change the acceess level for the thread mode by configure the CONTROL
	//go_to_privileged_access_level();
}
int main(void)
{
	
	//led_init()
	
	//Configure EXTI liLine0 (connected to PA0 pin) in interrupt mode
	//button_init()
	
	//check wheter processor is in provileged access level or not
	if(is_privileged_access())
	{
		__set_PRIMASK(1);
		__set_PRIMASK(0);
	}	
	
	//go_to_unprivileged_access_level();
	
	//Now, again try to change the restricted register
	//It is not possible because in this point the processsor is in unprivileged
	__set_PRIMASK(1);
	__set_PRIMASK(0);
	
	//try to go back privileged access level
	//go_to_privileged_access_level();
	/**
	We couldn't able ti go back ti privileged access leve, thats 
	becoause we are trying to access CONTROL register 
	by being in unprivileged access level
	*/
	
	return 0;
}