package com.quickcart.productservice.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "p_title")
    private String title;

    @Column(name = "p_price")
    private Double price;
    @Column(name = "p_img")
    private String image;


}
