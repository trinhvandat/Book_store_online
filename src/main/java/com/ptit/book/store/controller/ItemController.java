package com.ptit.book.store.controller;

import com.ptit.book.store.dao.ItemDao;
import com.ptit.book.store.dao.LoginDao;
import com.ptit.book.store.model.CartItem;
import com.ptit.book.store.model.Customer;
import com.ptit.book.store.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private LoginDao loginDao;

    @GetMapping
    public String getHomeForm(Model model){
        List<Item> items = itemDao.getAll();
        model.addAttribute("items", items);
        return "home";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable int id, HttpSession session){
        Item item = itemDao.getItemById(id);
        model.addAttribute("book", item);

        Customer customer = (Customer) session.getAttribute("user");
        System.out.println(customer);

//        int cartId = loginDao.getCartId(customer);
//        session.setAttribute("cartId", cartId);
        int cartId = (int) session.getAttribute("cartId");
        CartItem cartItem = CartItem.builder()
                .cartId(cartId)
                .build();
        session.setAttribute("cartItem", cartItem);
        return "BookDetail";
    }
}
