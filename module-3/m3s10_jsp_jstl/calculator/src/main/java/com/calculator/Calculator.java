package com.calculator;

public class Calculator {
    private double firstOperand;
    private double secondOperand;
    private String operator;

    public Calculator() {
    }

    public Calculator(double firstOperand, String operator, double secondOperand) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() throws ArithmeticException {
        switch (getOperator()) {
            case "Addition":
                return getFirstOperand() + getSecondOperand();
            case "Subtraction":
                return getFirstOperand() - getSecondOperand();
            case "Multiplication":
                return getFirstOperand() * getSecondOperand();
            case "Division":
                if (getSecondOperand() == 0) {
                    throw new ArithmeticException();
                }
                return getFirstOperand() / getSecondOperand();
            default:
                return -999999999.0;
        }
    }
}
