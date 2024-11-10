package com.geektext.repository;


import com.geektext.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository


public interface WishListRepository extends JpaRepository<WishList,Integer> {

}