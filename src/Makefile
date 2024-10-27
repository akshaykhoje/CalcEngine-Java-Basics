SRC = com/learningjava/calcengine/Main.java com/learningjava/calcengine/MathEquation.java
CLASS = com.learningjava.calcengine.Main
OUTPUT = output

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
	del /Q com\learningjava\calcengine\*.class