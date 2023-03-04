package codegym.vn.controller;

import codegym.vn.bean.CurrencyConverter;
import codegym.vn.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverterController {
    @Autowired
    private CurrencyConverterService converterService;

    @GetMapping("/currency-converter")
    public String displayCurrencyConverter() {
        return "currency-converter";
    }

    @PostMapping("/converter-result")
    public String displayResult(@RequestParam double usd, @RequestParam double rate, Model model) {
        double result = converterService.convert(usd, rate);
        CurrencyConverter currencyConverter = new CurrencyConverter(usd, rate, result);
        model.addAttribute("currencyConverter", currencyConverter);
        return "converter-result";
    }
}
