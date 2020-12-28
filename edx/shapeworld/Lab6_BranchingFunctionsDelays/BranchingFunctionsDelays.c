// BranchingFunctionsDelays.c Lab 6
// Runs on LM4F120/TM4C123
// Use simple programming structures in C to 
// toggle an LED while a button is pressed and 
// turn the LED on when the button is released.  
// This lab will use the hardware already built into the LaunchPad.
// Daniel Valvano, Jonathan Valvano
// January 15, 2016

// built-in connection: PF0 connected to negative logic momentary switch, SW2
// built-in connection: PF1 connected to red LED
// built-in connection: PF2 connected to blue LED
// built-in connection: PF3 connected to green LED
// built-in connection: PF4 connected to negative logic momentary switch, SW1

#include "TExaS.h"

#define GPIO_PORTF_DATA_R       (*((volatile unsigned long *)0x400253FC))
#define GPIO_PORTF_DIR_R        (*((volatile unsigned long *)0x40025400))
#define GPIO_PORTF_AFSEL_R      (*((volatile unsigned long *)0x40025420))
#define GPIO_PORTF_PUR_R        (*((volatile unsigned long *)0x40025510))
#define GPIO_PORTF_DEN_R        (*((volatile unsigned long *)0x4002551C))
#define GPIO_PORTF_LOCK_R       (*((volatile unsigned long *)0x40025520))
#define GPIO_PORTF_CR_R         (*((volatile unsigned long *)0x40025524))
#define GPIO_PORTF_AMSEL_R      (*((volatile unsigned long *)0x40025528))
#define GPIO_PORTF_PCTL_R       (*((volatile unsigned long *)0x4002552C))
#define PF4                     (*((volatile unsigned long *)0x40025040))
#define PF3                     (*((volatile unsigned long *)0x40025020))
#define PF2                     (*((volatile unsigned long *)0x40025010))
#define PF1                     (*((volatile unsigned long *)0x40025008))
#define PF0                     (*((volatile unsigned long *)0x40025004))
#define SYSCTL_RCGC2_R          (*((volatile unsigned long *)0x400FE108))
#define SYSCTL_RCGC2_GPIOF      0x00000020  // port F Clock Gating Control

// basic functions defined at end of startup.s
void DisableInterrupts(void); // Disable interrupts
void EnableInterrupts(void);  // Enable interrupts

void PortF_Init(void);
void Delay100ms(unsigned long time);
void TogglePF2(void);
void TurnOnPF2(void);
void TurnOffPF2(void);

unsigned long In; // input from PF4
unsigned long Out; // output to PF2 (blue LED)

int main(void){ unsigned long volatile delay;
  TExaS_Init(SW_PIN_PF4, LED_PIN_PF2);  // activate grader and set system clock to 80 MHz
  // initialization goes here
	PortF_Init();

  EnableInterrupts();           // enable interrupts for the grader
	TurnOnPF2();
  while(1){
    // body goes here
		Delay100ms(1);
		In = PF4; //GPIO_PORTF_DATA_R&0x10;   // read PF4 into Sw1
    In = In>>2;                    // shift into position PF2
		if(!In){
			TogglePF2();
		}
		if(In){
			TurnOnPF2();
		}
  }
}



void PortF_Init(void){
	volatile unsigned long delay;
  SYSCTL_RCGC2_R |= SYSCTL_RCGC2_GPIOF;     // 1) activate clock for Port F
  delay = SYSCTL_RCGC2_R;           // allow time for clock to star
	GPIO_PORTF_LOCK_R = 0x4C4F434B;   // 2) unlock GPIO Port F
  GPIO_PORTF_CR_R = 0x1F;           // allow changes to PF4-0
  // only PF0 needs to be unlocked, other bits can't be locked
  GPIO_PORTF_AMSEL_R = 0x00;        // 3) disable analog on PF
  GPIO_PORTF_PCTL_R = 0x00000000;   // 4) PCTL GPIO on PF4-0
  GPIO_PORTF_DIR_R = 0x0E;          // 5) PF4,PF0 in, PF3-1 out
  GPIO_PORTF_AFSEL_R = 0x00;        // 6) disable alt funct on PF7-0
  GPIO_PORTF_PUR_R = 0x11;          // enable pull-up on PF0 and PF4
  GPIO_PORTF_DEN_R = 0x1F;          // 7) enable digital I/O on PF4-0
}

void Delay100ms(unsigned long time){
  unsigned long i;
  while(time > 0){
    i = 1333333;  // this number means 100ms
    while(i > 0){
      i = i - 1;
    }
    time = time - 1; // decrements every 100 ms
  }
}

void TogglePF2(void){
	unsigned long Out; // output to PF2 (blue LED)
	Out = PF2;//GPIO_PORTF_DATA_R;
	//Out = Out&0xFB;
	if((Out&0x04) == 0x04){
		TurnOffPF2();
	} else {
		TurnOnPF2();
	}
}

/*void TurnOnPF2(void){
	unsigned long Out; // output to PF2 (blue LED)
	Out = GPIO_PORTF_DATA_R;
	Out = Out&0xFB;
	Out = Out|0x04;
	GPIO_PORTF_DATA_R = Out;        // output
}*/

void TurnOnPF2(void){
	PF2 = 0x04;
}


/*void TurnOffPF2(void){
	unsigned long Out; // output to PF2 (blue LED)
	Out = GPIO_PORTF_DATA_R;
	Out = Out&0xFB;
	GPIO_PORTF_DATA_R = Out;        // output
}*/

void TurnOffPF2(void){
	PF2 = 0;
}
