package com.ptit.book.store.controller;

import com.ptit.book.store.dao.CartDao;
import com.ptit.book.store.dao.ItemDao;
import com.ptit.book.store.model.CartItem;
import com.ptit.book.store.model.Item;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ItemDao itemDao;

    @GetMapping("/add")
    public String addItemToCart(@RequestParam("item_id") int itemId, HttpSession session, HttpServletRequest request){
        CartItem cartItem = (CartItem) session.getAttribute("cartItem");
        int amount = Integer.parseInt(request.getParameter("amount"));
        cartItem.setAmount(amount);
        Item item = itemDao.getItemById(itemId);
        cartItem.setItem(item);
        System.out.println(cartItem);
        CartItem cartItemAdded = cartDao.addItemInCart(cartItem);
        return "redirect:/home";
    }

    @GetMapping
    public String getCartForm(HttpSession session, Model model){
        int cartId = (int) session.getAttribute("cartId");
        List<CartItem> cartItemList = cartDao.getListItem(cartId);
        System.out.println(cartItemList);
        model.addAttribute("cartList", cartItemList);
        return "Cart";
    }

}
