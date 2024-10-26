//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
        }  else if (args.length == 3) {
            handleCommandLine(args);
        }
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
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
                System.out.println("a : addition\ns : subtraction\nm : multiplicaiton\nd : division");
                result = 0.0d;
                System.out.println("Exiting the program...");
                break;
        }
        return result;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }
}