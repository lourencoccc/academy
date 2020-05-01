
SOURCES = main.c \
	mycalc.c

INCLUDES = -I ../include

TARGET = main.out

CC = gcc
LD = ld
CFLAGS = -std=c99 -Wall -g -MD
LDFLAGS = -Wl,-Map=$(TARGET).map,--trace

# Create object files for each .c file
OBJS = $(SOURCES:.c=.o)

%.i : %.c
	$(CC) -E $^ $(CFLAGS) $(INCLUDES) -o $@

%.asm : %.c
	$(CC) -S $^ $(CFLAGS) $(INCLUDES) -o $@

%.o : %.c
	$(CC) -c $^ $(CFLAGS) $(INCLUDES) -o $@

.PHONY: compile-all
compile-all: $(SOURCES)
	$(CC) -c $^ $(CFLAGS) $(INCLUDES)

.PHONY: build
build: all

.PHONY: all
all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) $(LDFLAGS) $(INCLUDES) -o $@ $^ > $*.d

.PHONY: clean
clean:
	rm -f *.out *.map *.o *.i *.asm *.d *.elf