package com.ptit.book.store.repository;

import com.ptit.book.store.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByCustomerId(int customerId);
}
