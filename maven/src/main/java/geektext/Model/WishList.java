package com.geektext.geektext.model;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotBlank;


@Entity
@Table = (name = "wishlist")

public class WishList {

    @Id
    @Column(name = "list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int list_id;

    @Column(name = "user_id")
    private @NotBlank int user_id;

    @Column(name = "book_id")
    private @NotBlank int book_id;

    @Column(name= "list_name")
    private @NotBlank string list_name;




}