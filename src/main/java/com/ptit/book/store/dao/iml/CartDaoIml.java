package com.ptit.book.store.dao.iml;

import com.ptit.book.store.dao.CartDao;
import com.ptit.book.store.model.CartItem;
import com.ptit.book.store.model.Item;
import com.ptit.book.store.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDaoIml implements CartDao {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem addItemInCart(CartItem item) {
        CartItem added = cartItemRepository.save(item);
        return added;
    }

    @Override
    public List<CartItem> getListItem(int cardId) {
        List<CartItem> cartItemList = cartItemRepository.findByCartId(cardId);
        return cartItemList;
    }
}
