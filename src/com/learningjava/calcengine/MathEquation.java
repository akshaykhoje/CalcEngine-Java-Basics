package com.learningjava.calcengine;

public class MathEquation {
    // fields of the class
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    void execute() {
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
                result = (rightVal != 0) ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode : " + opCode);
                result = 0.0d;
                System.out.println("Exiting the program...");
                break;
        }
    }

    public double getLeftVal() {
        return this.leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return this.rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode(){
        return this.opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
}
