package com.ptit.book.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name = "book")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "language")
    private String language;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "is_reference")
    private int isReference;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "date_of_entry")
    private Date dateOfEntry;

    @Column(name = "price")
    private double price;

    @Column(name = "book_states")
    @Enumerated(EnumType.STRING)
    private BookStates bookStates;

    @Column(name = "book_format")
    @Enumerated(EnumType.STRING)
    private BookFormat bookFormat;

    @Column(name = "book_status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
}
