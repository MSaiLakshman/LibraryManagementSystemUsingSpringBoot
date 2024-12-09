package com.lms.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.library_management_system.dto.AddressDto;
import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.entity.Book;
import com.lms.library_management_system.service.AddressService;
import com.lms.library_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	//http://localhost:8080/address
//	{
//		"houseNumber":203,
//		"area":"mgroad",
//		"city":"banglore",
//		"state":"ka",
//		"country":"India",
//		"pincode":518003
//	}
	@PostMapping
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody AddressDto addressDto){
		return addressService.saveAddress(addressDto);
	}
	
	
	//http://localhost:8080/address/1
	@GetMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> findByAddressID(@PathVariable int addressId){
		return addressService.findByAddressID(addressId);
	}
	/*
	  	"addressId":1,
	 	"houseNumber":203,
		"area":"mgroad",
		"city":"banglore",
		"state":"ka",
		"country":"India",
		"pincode":518003
	 */
	
	@PostMapping("/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int addressId, @RequestBody AddressDto addressDto){
		return addressService.updateAddress(addressId, addressDto);
	}
	
	@DeleteMapping("/{addressID}")
    public ResponseEntity<ResponseStructure<String>> deleteAddress(@PathVariable int addressID) {
        return addressService.deleteAddress(addressID);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress() {
        return addressService.getAllAddresses();
    }
	
}
