package codegym.service;

import codegym.bean.Calculator;
import codegym.com.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private Validate validate;

    @Override
    public Calculator calculate(String firstOperand, String secondOperand, String operator) {
        String message = "Cannot calculate! (input is not a number)";
        Calculator calculator = new Calculator(firstOperand, secondOperand, operator, message);
        if (validate.isNumberRight(firstOperand) && validate.isNumberRight(secondOperand)) {
            double fOpe = Double.parseDouble(firstOperand);
            double sOpe = Double.parseDouble(secondOperand);
            double result = 0;
            switch (operator) {
                case "plus":
                    result = fOpe + sOpe;
                    message = "Result: " + firstOperand + " + " + secondOperand + " = " + result;
                    break;
                case "sub":
                    result = fOpe - sOpe;
                    message = "Result: " + firstOperand + " - " + secondOperand + " = " + result;
                    break;
                case "mul":
                    result = fOpe * sOpe;
                    message = "Result: " + firstOperand + " x " + secondOperand + " = " + result;
                    break;
                case "div":
                    if (sOpe == 0) {
                        message = "Cannot calculate " + firstOperand + "/" + secondOperand;
                        return new Calculator(firstOperand, secondOperand, operator, message);
                    }
                    result = fOpe / sOpe;
                    message = "Result: " + firstOperand + " / " + secondOperand + " = " + result;
                    break;
            }
            calculator = new Calculator(firstOperand, secondOperand, operator, result, message);
        }
        return calculator;
    }
}
