package codegym.controller;

import codegym.bean.SearchWord;
import codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/dictionary")
    public String displaySearchForm() {
        return "search";
    }

    @PostMapping("/trans")
    public String getResult(@RequestParam String word, Model model) {
        String result = dictionaryService.findWord(word);
        SearchWord searchWord = new SearchWord(word, result);
        model.addAttribute("searchWord", searchWord);
        return "search";
    }
}
