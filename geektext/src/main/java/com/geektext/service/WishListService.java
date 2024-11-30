package com.geektext.service;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import com.geektext.repository.WishListRepository;
import com.geektext.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public WishList addWishList(@RequestBody WishList wishlist) {
        return wishListRepository.save(wishlist);
    }

    public Optional<WishList> addBook(String _id, String bookid) {
        Optional<WishList> wishListOptional = wishListRepository.findById(_id);
        if (wishListOptional.isPresent()) {
            WishList wishlist = wishListOptional.get();
            if (!wishlist.getBookid().contains(bookid)) {
                wishlist.getBookid().add(bookid);
                wishListRepository.save(wishlist);
            }
        }
        return wishListOptional;
    }

    public List<WishList> getWishList() {
        return wishListRepository.findAll();
    }

    public Optional<WishList> removebook(String _id, String bookid) {
        Optional<WishList> wishListOptional = wishListRepository.findById(_id);
        if (wishListOptional.isPresent()) {
            WishList wishList = wishListOptional.get();
            if (wishList.getBookid().remove(bookid)) {
                wishListRepository.save(wishList);
            }
        }

        return wishListOptional;
    }



    public List<String> getlist(String _id) {
        WishList wishlist = wishListRepository.findById(_id).orElse(null);
        if (wishlist != null) {
            return wishlist.getBookid();
        }
        return null;
    }


   /* public void delete(String _id, String bookid) {
        Query query = new Query(Criteria.where("_id").is(_id));
        Update update = new Update().pull("bookid", bookid);


    }*/
}



