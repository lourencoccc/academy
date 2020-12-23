
Final peer-reviewed exam - Joao Lourenco Souz jr

1. You’re required to build a factory wide monitoring 
system, consisting of motion sensors, temperature 
sensors, air-quality monitoring systems and an 
administrative dashboard from where all of them can be 
accessed and controlled. What connection and 
communication protocols will you use? Explain your 
justification for choosing them. [300 Words]
 

For sensors I'll use BLE – Bluetooth Low Energy protocol, because it's designed for sending periodic chunks of data, has a short range (max. 100m), with a medium data rate, low power consumption, it is relatively cheap. End the communication protocol should be the CoAP, this protocol is Lightweight and performatic in terms of processing power and memory and easy to use a HTTP-CoAP gateway.
For the systems the integrations between the air-quality monitoring system, the  device sensor gateways, and that administrative dashboard should be done using TCP/IP protocol through WiFi or Ethernet with HTTP communications protocol, because it was designed for always on always reliable connectivity platforms,  has high level of flexibility.


2. REST and SOAP are two methods of building web 
services. How do they fit the Cyber Physical System 
paradigm? Give the advantages and disadvantages of each 
method in the context of Cyber Physical Systems/Embedded 
Systems. [300 Words]

Both methods can be used in Cyber-Physical Systems (CPS),
however, each method has advantages and disadvantages:
SOAP
* Advantages: is more secure, is extensible, Platform independent
* Disadvantages: is complex to parse, isn't power efficient
REST
* Advantages: is lighter than SOAP in terms of network resources, is 
more power efficient, is simple to parse, REST is protocol independent in principle, but is generally bound to HTTP.
* Disadvantages: is less secure and extensible
is more secure, is extensible
In essential, The power efficiency and simplicity turn the REST method more appropriate to apply in CPS environments.


3. Describe symmetric and public key encryption and 
explain their differences, give an example of their usage 
and most common algorithms of each type. [300 Words]

The symmetric  cipher system
* The decryption key is identical to the encryption key
* Is necessary a secure channel for key exchange
* Encryption of large data
* Usage examples: Payment applications, validations to confirm that the sender of a message, random number generation or hashing
* Algorithms examples: AES (Advanced Encryption Standard), DES (Data Encryption Standard), RC4 (Rivest Cipher 4), Blowfish

The public-key cipher system
* The encryption key and decryption key are different.
* The encryption key is publicly available
* Is usually used for shorter messages
* Is computationally more complex 
* Is generally used for encryption short messages or encrypting the key for a symmetric algorithm.
* Usage examples: digital signature, password-authenticated key agreement, non-repudiation protocols.
* Algorithms examples: RSA (Rivest-Shamir-Adleman), ECC (Elliptic Curve Cryptography), Diffie-Hellman

4. Summarize the key security issues of Smart Grid based on what you have learned in this module. [300 Words]

The smart grid suffers from Denial of service attacks, these attacks can target different layers of the smart grid network in different ways: Physical layer, MAC, Network and transport, and Application layer. This kind of attack is very serious and threatening for a smart grid.

Dmart grids are also vulnerable to some other attack types
which target integrity and confidentiality of the customer's information.