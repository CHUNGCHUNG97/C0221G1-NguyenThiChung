package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import com.codegym.service.impl.DictionaryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping(value = "/word")
    public String inputWord() {
        return "dictionary";
    }

    @PostMapping(value = "/dictionary")
    public String dic(@RequestParam String word, Model model) {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
        word = word.toLowerCase();
        String result = dic.get(word);
        if (result != null) {
            model.addAttribute("result", dictionaryService.dictionary(result));
        } else {
            model.addAttribute("result", "Not found");
        }
        return "result";
    }


}
