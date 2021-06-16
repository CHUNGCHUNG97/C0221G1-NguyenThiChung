package caculator.controller;

import caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CaculatorController {
    @Autowired
    ICaculatorService caculatorService;

    @RequestMapping("/")
    public String caculator() {
        return "index";
    }

    @RequestMapping("/caculator")
    public String result(@RequestParam Map<String, String> caculator, Model model) {
        try {
            String number1 = caculator.get("number1");
            String number2 = caculator.get("number2");
            String cal = caculator.get("caculator");
            String result = caculatorService.caculator(caculator, cal);
            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("caculator", cal);
            model.addAttribute("result", result);
        } catch (Exception e) {
           e.printStackTrace();
        }

        return "result";
    }
}
