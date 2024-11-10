package com.geektext.model;




import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Wishlist")

public class WishList {

    @Id
    @Column(name = "_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    @Column(name = "userid")
    private int userid;

    // @Column(name = "book_id")
    private int book_id;

    @Column(name= "wishlistname")
    private String wishlistname;


}