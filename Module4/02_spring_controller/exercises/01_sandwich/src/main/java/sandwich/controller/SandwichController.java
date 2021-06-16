package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/")
    public String select() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(name = "condiment", required = false) String[] condiment, Model model) {
        StringBuilder result = new StringBuilder();

        if (condiment==null) {
            model.addAttribute("result", " not found ");
        } else {

            for (int i = 0; i < condiment.length; i++) {
                if (!condiment[i].equals("") && condiment[i] != null) {
                    result.append(condiment[i]).append(" ");
                }
            }
            model.addAttribute("result", result.toString());
        }

        return "/result";
    }
}
