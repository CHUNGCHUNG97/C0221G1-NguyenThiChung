package hom_dien_tu.controller;

import hom_dien_tu.model.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
@Controller
public class MailController {
    @GetMapping(value = "/")
    public String getMail(Model model) {
        model.addAttribute("mail", new Mail());
        List<String> languages = new ArrayList<>();
        languages.add("Vietnamese");
        languages.add("English");
        languages.add("Laos");
        languages.add("India");
        List<Integer> pageSizes = new ArrayList<>();
        pageSizes.add(25);
        pageSizes.add(20);
        pageSizes.add(15);
        pageSizes.add(10);
        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);
        return "home";
    }

    @PostMapping(value = "/mail")
    public String createMail(@ModelAttribute Mail mail, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("mail", mail);
            redirectAttributes.addFlashAttribute("msg", "create success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "create fail");
        }

        return "mail";
    }
}
