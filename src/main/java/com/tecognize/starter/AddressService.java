package com.tecognize.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    static List<Address> listOfAddresses = new ArrayList<Address>();

    static {
        listOfAddresses.add(new Address("haque", "khulna"));
        listOfAddresses.add(new Address("shofijul", "khajura"));
    }

    public List<Address> getAddresses(){
        // Using Persistence DB
        return addressRepository.findAll();

        // Using Object
        // return listOfAddresses;
    }

    public Address getAddressByName(String name){
        for(Address address: listOfAddresses){
            if(address.getName().equalsIgnoreCase(name)){
                return address;
            }
        }
        return null;
    }

    public void addNewAddress(Address address){
        // Using Persistence DB
        addressRepository.save(address);

        // Using Object
        // listOfAddresses.add(address);
    }

}
