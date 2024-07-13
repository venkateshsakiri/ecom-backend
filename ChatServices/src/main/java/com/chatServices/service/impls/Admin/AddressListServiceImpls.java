package com.chatServices.service.impls.Admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatServices.entity.AddressList;
import com.chatServices.entity.repo.AddressListRepository;
import com.chatServices.service.Admin.AddressListService;

@Service
public class AddressListServiceImpls implements AddressListService {
	
	@Autowired
	public AddressListRepository addressListRepository;

	@Override
	public String postAddress(AddressList address) {
		addressListRepository.save(address);
		return "Address added successfully!!";
	}

	@Override
	public List<AddressList> getAddress() {
		return addressListRepository.findAll();
	}

	@Override
	public Optional<AddressList> getAddressBasedOnId(Long id) {
		return addressListRepository.findById(id);
	}

}
