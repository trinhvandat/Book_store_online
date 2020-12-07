package com.ptit.book.store.controller;

import com.ptit.book.store.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String getHomeForm(){
        return "welcome";
    }

    @GetMapping("/registration")
    public String getRegistrationForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "registration";
    }

    @GetMapping("/login")
    public String getLoginForm(){
        return "login";
    }

}
