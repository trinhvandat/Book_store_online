package com.ptit.book.store.repository;

import com.ptit.book.store.model.Account;
import com.ptit.book.store.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByAccount(Account account);
}
