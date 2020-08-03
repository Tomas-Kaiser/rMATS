package com.schoolproject.rmats.service;

import com.schoolproject.rmats.dao.AddressRepository;
import com.schoolproject.rmats.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Add an address
    @Transactional
    public void addAddress(Address address){
        addressRepository.save(address);
    }

    // Get addresses by customer id
    public List<Address> getAllAddressesByCustomerId(int customerId){
        return addressRepository.findByUserId(customerId);
    }

    // Remove the address by address id
    public void deleteAddressById(int addressId){
        addressRepository.deleteById(addressId);
    }
}
