package codegym.controller;

import codegym.bean.Calculator;
import codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String displayCalculator() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam("firstOperand") String firstOperand, @RequestParam("secondOperand") String secondOperand, @RequestParam("operator") String operator, Model model) {
        Calculator calculator = calculatorService.calculate(firstOperand, secondOperand, operator);
        model.addAttribute("calculator", calculator);
        return "calculator";
    }
}
