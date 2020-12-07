package com.ptit.book.store.controller;

import com.ptit.book.store.dao.LoginDao;
import com.ptit.book.store.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private LoginDao loginDao;

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<?> registrar(@RequestBody Customer customer){
        Customer customerAdded = loginDao.registrar(customer);
        return new ResponseEntity<>(customerAdded, HttpStatus.CREATED);
    }

    @PostMapping("/registration/add")
    public String Registrar(Customer customer, Model model, HttpSession session){
        System.out.println(customer);
        Customer customerAdded = loginDao.registrar(customer);
        if (customerAdded == null){
            model.addAttribute("message", "username does exist");
            return "redirect:/registration";
        }
        else {
            session.setAttribute("user", customerAdded);
            int cartId = loginDao.getCartId(customer);
            session.setAttribute("cartId", cartId);
            return "redirect:/home";
        }
    }

    @PostMapping("/login/verify")
    public String verifyAccount(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer isAccount = loginDao.login(username, password);
        if (isAccount != null){
            session.setAttribute("user", isAccount);
            int cartId = loginDao.getCartId(isAccount);
            session.setAttribute("cartId", cartId);
            return "redirect:/home";
        }
        else {
            return "redirect:/";
        }
    }

}
