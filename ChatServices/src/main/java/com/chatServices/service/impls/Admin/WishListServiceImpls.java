package com.chatServices.service.impls.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.WishList;
import com.chatServices.entity.repo.WishListRepository;
import com.chatServices.service.Admin.WishListService;

@Service
public class WishListServiceImpls implements WishListService {
	
	@Autowired
	public WishListRepository wishListRepo;

	@Override
	public String postWishList(WishList list) {
		wishListRepo.save(list);
		return "Added to favourites Successfully!!";
	}

	@Override
	public List<WishList> getAllWishListByEmail(String email) {
		return wishListRepo.findAllOrdersByEmail(email);
	}

	@Override
	public String deleteWishListItemById(Long id) {
		wishListRepo.deleteById(id);
		return "Item Deleted successfully!";
	}

}
