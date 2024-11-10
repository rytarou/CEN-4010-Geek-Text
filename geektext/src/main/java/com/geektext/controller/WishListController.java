package com.geektext.controller;

import com.geektext.model.WishList;
import com.geektext.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController

public class WishListController {

    @Autowired
    private WishListService wishlistService;

    @PostMapping("/addWishlist")

    public WishList postDetails(@RequestBody WishList wishlist) {
        return wishlistService.saveDetails(wishlist);
    }

    @GetMapping("/getWishlist")
    public List<WishList> getWishlist() {
        return wishlistService.getWishlist();
    }
}