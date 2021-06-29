package com.codegym.product.controller;

import com.codegym.product.model.entity.Cart;
import com.codegym.product.model.entity.Product;
import com.codegym.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("shop-cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
//
//    @PostMapping("/pay")
//    public String payment(@SessionAttribute("cart") Cart cart, RedirectAttributes redirectAttributes) {
//        if (cart == null) {
//            redirectAttributes.addFlashAttribute("msg", "chưa có gfi trong giỏ hàng");
//            return "redirect:/shopping-cart";
//        }
//        return "notify";
//    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable Long id, Model model, @SessionAttribute("cart") Cart cart) {

        productService.deleteProductInCart(id, cart);


        return "redirect:/shop";

    }
}
