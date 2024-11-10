package com.geektext.service;

import com.geektext.model.WishList;
import com.geektext.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class WishListService {

    private final WishListRepository wishlistRepository;

    public WishListService(WishListRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<WishList> getWishlist() {
        return wishlistRepository.findAll();
    }

    public WishList saveDetails(WishList wishlist) {
        return wishlistRepository.save(wishlist);
    }
}