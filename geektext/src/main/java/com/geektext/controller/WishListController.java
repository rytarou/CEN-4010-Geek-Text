package com.geektext.controller;

import java.util.List;
import java.util.Optional;

import com.geektext.service.WishListService;
import com.geektext.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/newwishlist")
    public WishList newwishlist(@RequestBody WishList wishlist) {
        return wishListService.addWishList(wishlist);
    }

    @PostMapping("/add/{_id}/{bookid}")
    public ResponseEntity<String> addBook(@PathVariable("_id") String _id, @PathVariable("bookid") String bookid) {
        Optional<?> add = wishListService.addBook(_id,bookid);
        if(add.isPresent()) {
            return ResponseEntity.ok("Book added");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/wishlists")
    public List<WishList> getWishList(){
        return wishListService.getWishList();
    }



    @GetMapping("/booklist/{_id}")
    public List<String> getbookList(@PathVariable ("_id") String _id) {
        return wishListService.getlist(_id);
    }

    @DeleteMapping("/remove/{_id}/{bookid}")
    public ResponseEntity<String> removeBook(@PathVariable("_id") String _id, @PathVariable("bookid") String bookid) {
        Optional<?> remove = wishListService.removebook(_id,bookid);
        if(remove.isPresent()) {
            return ResponseEntity.ok("Book removed");
        }
        return ResponseEntity.notFound().build();
    }

   /* @DeleteMapping("/delete/{_id}/{bookid}")
    public ResponseEntity<String>delete(@PathVariable("_id") String _id,@PathVariable("bookid") String bookid){
        wishListService.delete(_id, bookid);
        return ResponseEntity.ok("Book Removed");
    }*/
}

