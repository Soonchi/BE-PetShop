package com.example.bepetshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String content;

    private String name;

    private long userId;

    private long productId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "userId" ,  insertable = false ,updatable = false)
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productId",  insertable = false ,updatable = false)
    private Product product;

}