Bit Band example

Bit banding technique is a way to address a particular bit of memory region

* Bit band operation can only be opereted on 2 memory region. This is called bit-band region
	* 0x20000000 to 0x20100000 (1 MB)
	* 0x40000000 to 0x40100000 (1 MB)
* To set/reset any bit field in the bit band region, wew have to use bit band alias 
address in the bit band alias region
	* 0x22000000 to 0x23ffffff (1 MB)
	* 0x42000000 to 0x43ffffff (1 MB)
	
Bit band alias addresses from bit ban alias memory region are used to accesss
individual bit of the bit band memory  region.



