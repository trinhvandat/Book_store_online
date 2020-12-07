package com.ptit.book.store.dao.iml;

import com.ptit.book.store.dao.LoginDao;
import com.ptit.book.store.model.*;
import com.ptit.book.store.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class LoginDaoIml implements LoginDao {

    private static final Logger logger = LoggerFactory.getLogger(LoginDaoIml.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FullNameRepository fullNameRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Customer registrar(Customer customer) {
        Account isExist = accountRepository.findByUsername(customer.getAccount().getUsername());
        if (isExist == null){
            Account account = accountRepository.save(customer.getAccount());
            FullName fullName = fullNameRepository.save(customer.getFullName());
            Address address = addressRepository.save(customer.getAddress());

            customer.setAccount(account);
            customer.setFullName(fullName);
            customer.setAddress(address);
            Customer customerAdded = customerRepository.save(customer);
            logger.info("customer:{}", customerAdded);

            Cart cart = Cart.builder()
                    .creationDate(new Date())
                    .customerId(customerAdded.getId())
                    .build();
            cartRepository.save(cart);
            return customerAdded;
        }
        return null;
    }

    @Override
    public Customer login(String username, String password) {
        Customer customer = null;
        Account isExist = accountRepository.findByUsernameAndPassword(username, password);
        if (isExist != null){
            customer = customerRepository.findByAccount(isExist);
        }
        return customer;
    }

    @Override
    public int getCartId(Customer customer) {
        Cart cart = cartRepository.findByCustomerId(customer.getId());
        System.out.println(cart.getId());
        return cart.getId();
    }


}
