package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;

    private String Name;
    private String Description;
    private String ImageUrl;
    private double Price;

    @ManyToOne
    @JoinColumn(name="category_id",nullable= false)
    private  Category category;

    }