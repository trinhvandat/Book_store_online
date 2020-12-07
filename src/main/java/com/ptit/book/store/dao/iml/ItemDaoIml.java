package com.ptit.book.store.dao.iml;

import com.ptit.book.store.dao.ItemDao;
import com.ptit.book.store.model.Book;
import com.ptit.book.store.model.Item;
import com.ptit.book.store.repository.BookRepository;
import com.ptit.book.store.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemDaoIml implements ItemDao {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Item> getAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    @Override
    public Item getItemById(int id) {
        Item item = itemRepository.findById(id).orElse(null);
        return item;
    }

}
