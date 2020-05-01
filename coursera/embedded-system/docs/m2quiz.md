1. Which Compiler is used for the ARM Cortex M Processors

    * arm-none-eabi-gcc

2. When compiling with gcc, the command line parameter -Wl allow options to be passed to the:

    * Linker

3. In the preprocessing stage of compilation . . . ( Select all that apply )

    * Header files are actually expanded and included in the source code of the program
    * Macros are replaced by their respective values

4. The assembly code generated depends upon the

    * Processor architecture (wrong)

5. What kind of targets should have a phony directive in the makefile?

    * A target which is not one of your filenames

6. Select all that apply: A linker file ____

    * Provides details on the memory size and location
    * Maps compiled sections to physical memory
    * Can check if memory was over allocated
    * Can provide the Entry point to the program

7. Make can use what feature to ask the OS for compilation information?

    * Shell Functions

8. Which of the following is a proper declaration of an include guard?

    /* Code here */

    #ifndef __HEADER_H__

    #define __HEADER_H__

    /* Code here */

    #endif

9.  Variables for a makefile can be defined in

    * Makefile
    * Command line

10. Cross compiled executables can run on both a host machine and target embedded system

    * False

11. Which one of the following provides all prerequisites listed in a makefile target?

    * $* (wrong)

12. Which gcc option includes debugging info in the generated object code?

    * -g

13. Make can help generate which of the following files:

    * Map Files
    * Executable Files
    * Object Files

14. The -shared option of gcc generates a shared ______ for shared library.

    * Object file

15. The correct sequence of the GCC compilation process is

    * Preprocessing -> compiling -> linking -> locating

16. What utility allows you to produce assembly code from a given object file?

    * Objdump

17. Which compilation step makes sure that all the undefined symbols in the code are resolved.

    * Linking

18. If a program is linked against a static library then

    * Machine code of the used function is copied in the executable

19. What architecture specific flags will need to be used for our ARM cross compiler? (Select all that apply)

    * -mthumb
    * -mcpu=cortex-m4
    * --specs=nosys.specs

20. A processor Executes what kind of code?

    * Machine Code

21. A compile time switch can help:

    * Make code portable
    * Change the target files
    * Link different files
    * Change target architecture
    * All of the above
