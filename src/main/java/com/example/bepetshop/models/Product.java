package com.example.bepetshop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`product`")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long quantity;

    private long price;

    @Column(length = 2000)
    private String description;

    private String ageRange;

    private String image;

    private String categoryName;


    @ManyToOne
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @JsonManagedReference
    private List<ProductCart> productCarts = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<OrderDetail> orderdetails = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

}
