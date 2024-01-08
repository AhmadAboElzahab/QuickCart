package com.quickcart.productservice.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "c_title")
    private String title;

    public CategoryEntity() {
    }

    public CategoryEntity(long id, String title) {
        this.categoryId = id;
        this.title = title;
    }

    public long getId() {
        return categoryId;
    }

    public void setId(long id) {
        this.categoryId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
