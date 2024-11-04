SRC = com/learningjava/calcengine/Main.java com/learningjava/calcengine/MathEquation.java
CLASS = com.learningjava.calcengine.Main

# Determine the operating system
UNAME_S := $(shell uname -s)

# Default target
all : compile run

compile:
	@echo "Compiling Java files for you..."
	javac $(SRC)

run:
	@echo "Running the program"
	java $(CLASS) $(ARGS)

clean:
	@echo "Cleaning up..."
	@if [ "$(UNAME_S)" = "Linux" ]; then \
		rm -f com/learningjava/calcengine/*.class; \
	elif [ "$(UNAME_S)" = "Darwin" ]; then \
		rm -f com/learningjava/calcengine/*.class; \
	elif [ "$(UNAME_S)" = "CYGWIN"* ] || [ "$(UNAME_S)" = "MINGW"* ]; then \
		del /Q com\learningjava\calcengine\*.class; \
	else \
		echo "Unsupported OS: $(UNAME_S)"; \
		exit 1; \
	fi
