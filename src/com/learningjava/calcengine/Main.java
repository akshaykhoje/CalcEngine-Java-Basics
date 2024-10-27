package com.learningjava.calcengine;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            performCalculations();
        } else if (args.length == 1 && args[0].equals("--help") || args[0].equals("-h")) {
            help();
        } else if (args.length == 1 && args[0].equals("interactive")){
            executeInteractively();
        } else if (args.length == 3) {
            performOperations(args);
        }
    }


    private static void performCalculations() {
        MathEquation[] equations = new MathEquation[4];   // an array of references to classes of type MathEquation. Objects yet to be created
        equations[0] = create(100.0d, 25.0d, 'd');
        equations[1] = create(26.0d, 55.0d, 'a');
        equations[2] = create(100.0d, 6.0d, 's');
        equations[3] = create(83.0d, 88.0d, 'm');

        System.out.println("\nHardcoded inputs...");
        for (MathEquation equation : equations) {
            equation.execute();
            displayResult(equation.opCode, equation.leftVal, equation.rightVal, equation.result);
        }
    }


    // creates a new instance of the MathEquation class
    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }


    static double execute(char opCode, double leftVal, double rightVal) {
        double result = 0.0d;
        switch(opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                if (rightVal == 0) {
                    System.out.println("Invalid Input. Cannot divide by 0.\nExiting");
                    System.exit(0);
                }
                result = leftVal / rightVal;
                break;
            default:
                System.out.println("Invalid opCode : " + opCode);
                System.out.println("Exiting the program...");
                help();
        }
        return result;
    }


    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        DecimalFormat df = new DecimalFormat("#.###");
        String output = leftVal + " " + symbol + " " + rightVal + " " + " = " + df.format(result);
        System.out.println(output);
    }


    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int i=0; i<opCodes.length; i++){
            if(opCode == opCodes[i])
                symbol = symbols[i];
        }
        return symbol;
    }


    static void executeInteractively() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an operand followed by two numbers e.g. \"a 3 6\" to perform \"3 + 6\" (or type 'exit' to quit)");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            String[] parts = userInput.split(" ");
            if (parts.length != 3) {
                System.out.println("Invalid input");
            } else {
                performOperations(parts);
            }
        }
    }


    private static void performOperations(String[] arr) {
        char opCode = opCodeFromString(arr[0]);
        Optional<Double> leftValOpt = operandToDouble(arr[1]);
        Optional<Double> rightValOpt = operandToDouble(arr[2]);
        if (leftValOpt.isPresent() && rightValOpt.isPresent()) {
            double leftVal = leftValOpt.get();
            double rightVal = rightValOpt.get();
            double result = execute(opCode, leftVal, rightVal);
            displayResult(opCode, leftVal, rightVal, result);
        } else {
            System.out.println("Operation could not be performed due to invalid inputs...\nTERMINATING");
            help();
        }

    }


    static char opCodeFromString(String operation) {
        char opCode = ' ';
        if (operation.length() == 1) {
            opCode = operation.charAt(0);
        } else
            help();
        return opCode;
    }


    static Optional<Double> operandToDouble(String operand) {
        try {
            return Optional.of(Double.parseDouble(operand));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for: " + operand);
            System.exit(0);
            return Optional.empty();
        }
    }


    public static void help() {
        System.out.println("\n\nHELP...\nThe available opCodes are :\n'a' : addition\n's' : subtraction\n'm' : multiplication\n'd' : division\n");
        System.out.println("You can run the program in 3 modes :\n1) Without args - 'make'\n2) With args - 'make ARGS=\"opCode num1 num2\"'\n3) Interactive mode - 'make ARGS=\"interactive\"'");
        System.exit(0);
    }
}
