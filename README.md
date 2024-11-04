# CalcEngine-Java-Basics

My First learning project in Java

## Topics covered/revised

- Functional paradigm
- Object Oriented Programming
- Makefile
- Error handling
- Some In-built Java classes


## Working with the program

### To compile and execute the program

```markdown
$ make
```

### To get help to run the program
```markdown
$ make ARGS="--help"

OR

$ make ARGS="-h"
```

### To run in interactive mode
```
make ARGS="interactive" 
```

### To perform only one calculation from cmd line args
```
make ARGS="<opCode operand1 operand2>
```
where,

- opcode is one of 'a', 's', 'm', 'd', 'o' which stand for add, subtract, multiply, divide and modulo respectively


### To delete the redundant files after compiling
```markdown
$ make clean
```

---

*The main branch has the OOPs implementation of the program. There is another branch where functional paradigm is used. It's not as modified as this, but that's how this program started.*

### *Happy Learning :)*
