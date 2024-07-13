package com.chatServices.service.Admin;

import java.util.List;

import com.chatServices.entity.WishList;

public interface WishListService {

	String postWishList(WishList list);
	
	List<WishList> getAllWishListByEmail(String email);

	String deleteWishListItemById(Long id);

}
