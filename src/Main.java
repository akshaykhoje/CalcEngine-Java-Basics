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
        } else {
            System.out.println("Baadme karenge....");
            System.exit(0);
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
                result = leftVal / rightVal;
                break;
            default:
                System.out.println("Invalid opCode : " + opCode);
                result = 0.0d;
                System.out.println("Exiting the program...");
                break;
        }
        return result;
    }
}