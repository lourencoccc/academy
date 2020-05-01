#******************************************************************************
# Copyright (C) 2019 by Joao Souza Jr
#
# Redistribution, modification or use of this software in source or binary
# forms is permitted as long as the files maintain this copyright. Users are 
# permitted to modify this and use it to learn about the field of embedded
# software. Joao Souza Jr is not liable for any misuse of this material. 
#
#*****************************************************************************

# General Source files
SOURCES = ./src/main.c \
	./src/memory.c \
	./src/course1.c \
	./src/stats.c \
	./src/data.c \

# General include paths
INCLUDES = -I ./include/CMSIS \
	-I ./include/common \
	-I ./include/msp432 \
