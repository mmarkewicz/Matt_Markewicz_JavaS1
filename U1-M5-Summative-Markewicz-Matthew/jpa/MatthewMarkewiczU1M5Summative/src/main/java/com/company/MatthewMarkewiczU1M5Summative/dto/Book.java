package com.company.MatthewMarkewiczU1M5Summative.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String isbn;
    private Date publish_date;

    // find out mapped parameter
    @OneToOne
    private Integer author_id;
    private String title;

    // find out mapped parameter
    @OneToOne
    private Integer publisher_id;
    private Double price;

}
