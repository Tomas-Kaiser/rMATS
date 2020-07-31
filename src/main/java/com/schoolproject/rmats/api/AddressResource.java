package com.schoolproject.rmats.api;

import com.schoolproject.rmats.api.to.AddressTO;
import com.schoolproject.rmats.model.Address;
import com.schoolproject.rmats.service.AddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin
public class AddressResource {
    public static final Logger log = LogManager.getLogger(CustomerResource.class);
    private final AddressService addressService;

    @Autowired
    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }

    // Adding a new address
    @Validated
    @PostMapping("/customer/{id:\\d+}/address")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@PathVariable(name = "id") int customerId,
                           @Valid @NotNull @RequestBody AddressTO address) {
        log.info("action=createAddress, receive=customerId/address, method=POST, city={}", address.getCity());
        Address entity = convertToEntity(address, customerId);
        addressService.addAddress(entity);
        log.info("action=createAddressEnd");
    }

    private Address convertToEntity(AddressTO address, int customerId){
        Address entity = new Address();
        entity.setStreet(address.getStreet());
        entity.setZipCode(address.getZipCode());
        entity.setCity(address.getCity());
        entity.setCountry(address.getCountry());
        entity.setUserId(customerId);
        return entity;
    }

    // Getting addresses by customer
    @GetMapping("/customer/{id:\\d+}/address")
    public List<Address> getAllAddressesByCustomerId(@PathVariable(name = "id") int customerId){
        return addressService.getAllAddressesByCustomerId(customerId);
    }

    // Delete an address
    @DeleteMapping("/customer/{id:\\d+}/address/{addressId:\\d+}")
    public void deleteAddressById(@PathVariable(name = "id") int customerId, @PathVariable(name = "addressId") int addressId){
        addressService.deleteAddressById(addressId);
    }
}
