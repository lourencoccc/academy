
## Embedded systems

    * Applications
    * Requirements
    * Characteristics
    * Challenges
        * Dependability
        * Efficiency
        * Real-time constraints

### Dependability

* Make users to safely rely on the system
* Airplanes
* Nuclear power plants
* Automotive break system
* Dependability is of critical importance
* Connected to the environment
* Immediate impact on environment

Dependable if:

* Reliable
* Available
* Maintainable
* Safe
* Secure

Efficiency

* Energy efficiency
    * Hardware = Software
* Code size
* Weight
* Cost

### Input/Output (I/O)

* Peripherals
* Exposed as pins
* Serial/Parallel
    * SPI
    * GPIO
* Analog/Digital
    * Voltage
    * SPI

Reading Input

* Initiate reading every N (us, ms, s ...)
    * Timer-based
    * Software initiated
    * Chance to miss an event
    * RX buffer
* Readings at a time of the event
    * Interrupt-based
    * Hardware initiated
    * Reliability -  the event will not be missed
* Digital/Analog
    * Suitable form for a processing element
    * Analog signal to a number (binary)
* Receiving side
    * Specific protocol implementation
    * Voltage level compatibility (3.3v or 5v)


Synchronous/Asynchronous

* Synchronous
    * Common clock
    * No synchronization information
    * Higher throughput
* Asynchronous
    * No common clock
    * Data stream has a synchronization information within
    * Less throughput


* Full duplex
    * Bidirectional communication
    * Simltaneously
    * Mobile phone, USB 3
* Half duplex
    * Bidirectional communication
    * One direction at a time
    * “Walkie-talkie”, USB 1 and USB 2

USB - Universal Serial Bus

* One Host, several hubs, several devices
* 4 pins
    * Vcc, GND, Data-, Data+ (differential twisted pair for 3.0)
* Data rate
    * USB1.0 - 1.5 Mbit/s
    * USB2.0 - 480 Mbit/s
    * USB3.0 - 5 Gbit/s
    * USB3.1 - 10 Gbit/s

* SPI
    * Serial Peripheral interface
    * 4 wires
        * Master Out Slave In, Master In Slave Out, Serial Clock, Chip Select
    * Master
    * Slave
    * Shift registers are connected
    * Daisy chaining

Reconfigurable architecture

* ASICs
    * Expensive, Efficient, Not flexible
* Processors
    * Cheep
    * Not efficient
    * Flexible
* Reconfigurable architecture
    * Flexible
    * Efficient


Vendors FPGA

* Xilinx
* Altera
* Actel



