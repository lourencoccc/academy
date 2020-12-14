

### Issues of CPS

* Safety
* **Security**
* Usabillity
* Sustainabillity
* Interoperabilliyk
* Design Validation
* Physical Interction Modeling

### Need for CPS Security

* Environment Coupling
    * lack of isolation
* Resource-constrained
Second, cyber-physical systems can be composed of a very large number of
different devices with different computing platforms and capabilities.
In general, most devices in cyber physical systems are resource constrained,
meaning that they don't have much processing,
storage, or power capacity to execute complex operations. 
* Networked at multiple and extreme scales
* High degrees of automation


### CPS Security Requirements

* Sensing Security
    Validity and accuracy of sensed da is very important
* Storage Security
    Against any unauthorized access and modification
* Communication Security
* Actuation Control Security
    All actuations are authorized and according to he latest policies of the system
* Feedback Security
    Needs to b appropriately protected against tempering attempts
* Application Specific Security Requirements

### CPS Security Solutions

* Multi-domain primitives
    * Enviroment (Physical Security)
    * Cyber Security
* Security by desing

The system need to be designed to detect anormal physical conditions, and
act in a safe way in these situations.

Also, the system should always be protected against physical tampering
whenever possible.

This can be achieved by continuous testing and careful design of rigorous
authentication solutions and hardware and software components of the system. 


## Key Concepts in Cyber Physical Systems

### Confidentiality in CPS

Confidentiality refers to protecting personal privacy and
proprietary information from unauthorized access. 

* "The right people", privecy
* Complex information flow on CPS

### Privacy & Confidentiality Msures in CPSs

* Cryptography
    * Lightweight cryptographic mechanisms
        * Storage
        * Communiction

Encryption is one of the most efficient methods of protecting
confidentiality of data in systems.
Cryptographic solutions, however, involves complex computations that
require sufficient amount of computing power to be applicable in the system.

using lightweight security solutions is the only logical way to secure CPS due to limited storage and computing capacity

### Cofidentiality attacks in CPS

* Wiretapping
* Password Attacks
* Phishing and Pharming, is another way of acquiring passwords and
other sensitive information.

### Integrity in CPSs

Integrity is another aspect of security.
Integrity involves maintaining the consistency, accuracy and
trustworthiness of data over its entire lifecycle.
Integrity ensures that information is not modified by unauthorized entities.


* Protecting information from being modified by unauthorized prties

### Aspec of integrity in cyber physical systems

* Physical integrity
    * Tamper proof systems


Physical integrity of a system ensures that
the physical devices composing a system cannot be modified. 

Tamper proof hardware is one way of ensuring physical integrity
in cyber-physical systems.

* Data Integrity
    * Hash functions

* Configuration integrity
If such configuration parameters are tampered with,
the system may behave unexpectedly or even crash.
Therefore, configuration integrity is a very important requirement for
security of cyber-physical systems.
A reliable way of ensuring configuration integrity is to implement
a dedicated secure configuration management system. 

* Code integrity
It means ensuring that the embedded program code running on
the components of the system cannot be altered by an attacker. 

Software at this station is a challenge response technique that enables checking
the integrity of the memory contents of devices against malicious modifications.
It could be used, for example, to verify code integrity of sensors and actuators. 

Software at this station is a challenge response technique that enables checking
the integrity of the memory contents of devices against malicious modifications.
It could be used, for example, to verify code integrity of sensors and actuators. 

### Availability in CPS

* Refers to ensuring that authorized parties are able to access the information and resources when needed.


Confidencialidade no CPS
Integridade em CPSs
Disponibilidade no CPS