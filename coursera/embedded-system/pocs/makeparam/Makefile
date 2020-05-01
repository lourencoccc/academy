ifeq ($(PLATFORM), PLAT1)                                                                                                          
  SOURCES = main1.c                                                                                                
else                                                                                                                            
  SOURCES = main2.c                                                                                               
endif

.PHONY: clean
clean:
	rm -f *.out

main: clean
	gcc -o main.out $(SOURCES)