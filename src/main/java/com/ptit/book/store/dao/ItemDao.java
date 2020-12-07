package com.ptit.book.store.dao;

import com.ptit.book.store.model.Book;
import com.ptit.book.store.model.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> getAll();
    public Item getItemById(int id);
}
