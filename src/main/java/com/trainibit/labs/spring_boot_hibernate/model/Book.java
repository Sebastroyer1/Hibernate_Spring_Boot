package com.trainibit.labs.spring_boot_hibernate.model;
import jakarta.persistence.*;

@Entity //marca esta clase como una entidad Hibernate.
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //definen la clave principal.
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "price", nullable = false)
    private double price;

    // Getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
}