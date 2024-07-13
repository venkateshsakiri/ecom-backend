package com.chatServices.service.Admin;

import java.util.List;
import java.util.Optional;

import com.chatServices.entity.AddressList;

public interface AddressListService {

	String postAddress(AddressList address);

	List<AddressList> getAddress();
	
	Optional<AddressList> getAddressBasedOnId(Long id);

}
