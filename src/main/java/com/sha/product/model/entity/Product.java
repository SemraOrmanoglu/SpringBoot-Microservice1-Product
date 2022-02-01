package com.sha.product.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="PRODUCTS")
@javax.persistence.Entity
public class Product extends Entity<Integer>
{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID")
    @Id
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Column(length = 80,nullable = false)
    private String name;

    @Column(length = 80,nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date created;

}
