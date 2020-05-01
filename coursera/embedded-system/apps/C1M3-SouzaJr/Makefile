#******************************************************************************
# Copyright (C) 2019 by Joao Souza Jr
#
# Redistribution, modification or use of this software in source or binary
# forms is permitted as long as the files maintain this copyright. Users are 
# permitted to modify this and use it to learn about the field of embedded
# software. Joao Souza Jr is not liable for any misuse of this material. 
#
#*****************************************************************************

#------------------------------------------------------------------------------
# This makefile configure the  application build for all supported platforms 
#
# Use: make [TARGET] [PLATFORM-OVERRIDES]
#
# Build Targets:
#      This build file support HOST and MSP432 platform.
# 
# Platform Overrides:
#      No overrides is applied.
#
#------------------------------------------------------------------------------

# Include common sources
# General Source files
SOURCES = main.c \
	misc.c \

# General include paths
INCLUDES = -I .

# The base name target
TARGET = main

ifeq ($(PLATFORM),MSP432)
  # Architectures Specific Flags
  LINKER_FILE = ./msp432p401r.lds
  CPU = cortex-m4
  ARCH = thumb
  MARCH = armv7e-m
  FLOAT_ABI = hard
  FPU = fpv4-sp-d16
  SPECS = nosys.specs
  # Compiler Flags and Defines
  CC = arm-none-eabi-gcc
  LD = arm-none-eabi-ld
  LDFLAGS = -Wl,-Map=$(TARGET).map,-T $(LINKER_FILE)
  CFLAGS = -std=c99 -Wall -Werror -g -MD \
     -mcpu=$(CPU) \
     -m$(ARCH) \
     -march=$(MARCH) \
     -mfloat-abi=$(FLOAT_ABI) \
     -mfpu=$(FPU) \
     --specs=$(SPECS) \
     -DMSP432
  OBJDUMP = arm-none-eabi-objdump
  SIZE =  arm-none-eabi-size
  NM = arm-none-eabi-nm
endif

ifeq ($(PLATFORM),HOST)
  CC = gcc
  LD = ld
  CFLAGS = -std=c99 -Wall -Werror -g -MD -DHOST
  LDFLAGS = -Wl,-O0,-Map=$(TARGET).map
  OBJDUMP = objdump
  SIZE =  size
  NM = nm
endif

# Create object files for each .c file
OBJS = $(SOURCES:.c=.o)

# Generate assembly output of c-program implementation 
# files and the final output executable
%.asm : %.c compile-all
	$(CC) -S $< $(CFLAGS) $(INCLUDES) -o $@; $(OBJDUMP) -x $(basename $<).o

# Generate the object file for all c-source files (but do not link) 
# by specifying the object file you want to compile.
%.o : %.c
	$(CC) -c $^ $(CFLAGS) $(INCLUDES) -o $@

.PHONY: compile-all
compile-all: $(SOURCES)
	$(CC) -c $^ $(CFLAGS) $(INCLUDES)

.PHONY: size
size: $(TARGET).out $(OBJS)
	$(SIZE) --format=SysV $^

.PHONY: nm
nm: $(TARGET).out $(OBJS)
	$(NM) $^ > $(TARGET).nm

.PHONY: build
build: all

.PHONY: all
all: $(TARGET).out

$(TARGET).out: $(OBJS)
	$(CC) $(CFLAGS) $(LDFLAGS) $(INCLUDES) -o $@ $^ > $*.d; \
  $(OBJDUMP) -x -S $@ > $(basename $@).asm; \
  $(SIZE) --format=SysV $@

.PHONY: clean
clean:
	rm -f *.out *.map *.o *.i *.asm *.d


