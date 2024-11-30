package com.geektext.model;



import lombok.Getter;
import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="wishlist")

public class WishList {

    @Setter
    @Getter

    @Id
    private String _id;

    private String userid;

    private List<String> bookid = new ArrayList<>();

    private String wishlistname;

    public void Wishlist(String _id, String wishlistname, String userid, List<String> bookid) {

        this._id = _id;
        this.userid = userid;
        this.wishlistname = wishlistname;
        this.bookid = bookid;
    }

}
