package product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product.demo.model.entity.Product;
import product.demo.model.service.IProductService;


@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping(value = "/home")
    public String home(@RequestParam(required = false) String search,
                       @RequestParam(required = false) Integer page,
                       @RequestParam(required = false) Integer pageSize, Model model) {
        if (page == null) {
            page = 0;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        Page<Product> products;
        if (search != null) {
            products = productService.findAllByNameContaining(search, PageRequest.of(page, pageSize));
        } else {
            products = productService.findAll(PageRequest.of(page, pageSize));
        }
        model.addAttribute("products", products);
        model.addAttribute("search", search);
        return "home";
    }

    @GetMapping("product/demo/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("product/demo/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("message", "save success");
        return "redirect:/product/demo/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("message", "update success");
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product);
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/home";
    }
}
