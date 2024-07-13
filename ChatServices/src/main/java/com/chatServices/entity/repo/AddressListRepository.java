package com.chatServices.entity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatServices.entity.AddressList;

@Repository
public interface AddressListRepository extends JpaRepository<AddressList, Long>{

}
