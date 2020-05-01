
GCC is a ative compile tools
and ARM-GCC is a atarget compile tools.

## General compiler flags

| Opetion & Format | Purpose |
| ---------------- |-------------------|
| -c | Compile and Assemble File, Do Not Link |
| -o <FILE> | Compile, Assemble, and Link to OUTPUT_FILE |
| -g | Generate Debugging Information in Executable |
| -Wall | Enable All Warning Messages |
| -Werror | Treat All Warnings as Errors |
| -I \<DIR\> | Include this <\DIR\> to Look for Header Files |
| -ansi \n -std=STANDARD | Specify Which Standard Version to  Use (ex: c89,c99) |
| -v | Verbose Output from GCC |

## Architecture Specific Compiler Flags

| Opetion & Format | Purpose |
| ------------- |-----|
| -mcpu=[NAME] | Specifies Target ARM Processor and Architecture (ex: cortex-m0plus) |
| -march=[NAME] | Target ARM Architecture (ex: armv7-m, thumb) |
| -mtune=[NAME] | Target ARM Processor (ex: cortex-m0plus) |
| -mthumb | Generate code in Thumb States (ISA) |
| -marm | Generate code in ARM State (ISA) |
| -mthumb-interwork | Generate code that supports calling between ARM and Thumb (ISA) |
| -mlittle-endian | Generate code for Little Endian Mode |
| -mbig-endian | Generate code for Big Endian Mode |

## Linker Flags

| Opetion & Format | Purpose |
| ------------- |-----|
| -map [NAME] | Outputs a memory map file [NAME] from the result of linking |
| -T [NAME] | Specifies a linker script name [NAME] |
| -o [NAME] | Place the output in the filename [NAME] |
| -O\<#\> | The level of optimizations from [#=0-3] (-O0, -O1, -O2, -O3) |
| -Os | Optimize for memory size |
| -z stacksize=[SIZE] | The amount of stack space to reserve |
| -shared | Produce a shared library (dynamic linking library) |
| -l[LIB] | Link with library |
| -Wl,\<OPTION\> | Pass option to linker from compiler |
| -Xlinker \<OPTION\> | Pass option to linker from compiler |


## GNU Compilation

| Name      | Symbol   | ARM Executable     |
| --------- | -------- | ------------------ |
| Assembler | as       | arm-none-eabi-as   |
| Compiler  | gcc      | arm-none-eabi-gcc  |
| Linker    | ld       | arm-none-eabi-ld   |
| Make      | make     | make               |