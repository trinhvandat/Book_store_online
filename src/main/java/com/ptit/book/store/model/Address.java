package com.ptit.book.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "address")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number_house")
    private int numberHouse;

    @Column(name = "Street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

}
