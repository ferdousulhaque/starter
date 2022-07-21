package com.tecognize.starter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    static List<Address> listOfAddresses = new ArrayList<Address>();

    static {
        listOfAddresses.add(new Address("haque", "khulna"));
        listOfAddresses.add(new Address("shofijul", "khajura"));
    }

    public List<Address> getAddresses(){
        return listOfAddresses;
    }

    public Address getAddressByName(String name){
        for(Address address: listOfAddresses){
            if(address.getName().equalsIgnoreCase(name)){
                return address;
            }
        }
        return null;
    }

    public Boolean addNewAddress(Address address){
        return listOfAddresses.add(address);
    }

}
