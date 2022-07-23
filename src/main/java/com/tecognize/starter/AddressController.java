package com.tecognize.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAddresses(@RequestParam(required = false) String name) {

        if(name == null){
            // return (List<Address>) ResponseEntity.ok(addressService.getAddresses());
            return addressService.getAddresses();
        }

        List<Address> foundAddress = new ArrayList<Address>();
        Address address = addressService.getAddressByName(name);

        if(address != null){
            foundAddress.add(address);
        }

        if(foundAddress.isEmpty()){
            throw new AddressNotFoundException();
        }

        return foundAddress;
    }

    @PostMapping("/address")
    public void addNewAddress(@RequestBody Address address){
        addressService.addNewAddress(address);
    }

    @GetMapping("/static-address")
    public Address address(){
        Address address = new Address();
        address.setName("ferdous");
        address.setAddress("khilkhet");
        return address;
    }
}
