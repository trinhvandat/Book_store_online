package com.ptit.book.store.dao;

import com.ptit.book.store.model.CartItem;
import com.ptit.book.store.model.Item;

import java.util.List;

public interface CartDao {
    public CartItem addItemInCart(CartItem item);
    public List<CartItem> getListItem(int cardId);
}
