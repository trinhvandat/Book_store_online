package com.ptit.book.store.dao;

import com.ptit.book.store.model.Account;
import com.ptit.book.store.model.Customer;

public interface LoginDao {
    public Customer registrar(Customer customer);
    public Customer login(String username, String password);
    public int getCartId(Customer customer);
}
