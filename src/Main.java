//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[leftVals.length];

        if(args.length == 0) {
            for(int i=0; i<leftVals.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for (double currentResult : results)
                    System.out.println(currentResult);
        } else if (args.length == 1 && args[0].equals("interactive")){
            executeInteractively();
        } else if (args.length == 3) {
            handleCommandLine(args);
        }
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

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    private static void executeInteractively() {
        System.out.println("Enter an operand followed by two numbers e.g. \"a 3 6\" to perform \"3 + 6\"");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        if (parts.length != 3) {
            System.out.println("Invalid input");
        } else
            performOperations(parts);
    }

    private static void performOperations(String[] arr) {
        char opCode = opCodeFromString(arr[0]);
        double leftVal = operandToDouble(arr[1]);
        double rightVal = operandToDouble(arr[2]);
        double result = execute(opCode, leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    static char opCodeFromString(String operation) {
        char opCode = ' ';
        if (operation.length() == 1) {
            opCode = operation.charAt(0);
        } else
            help();
        return opCode;
    }

    static double operandToDouble(String operand) {
        return Double.parseDouble((operand));
    }

    private static void help() {
        System.out.println("The available opCodes are :\n'a' : addition\n's' : subtraction\n'm' : multiplicaiton\n'd' : division\n");
        System.exit(0);
    }
}