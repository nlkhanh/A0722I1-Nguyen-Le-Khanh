package codegym.service;

import codegym.bean.Calculator;

public interface CalculatorService {
    Calculator calculate(String firstOperand, String secondOperand, String operator);
}
