package com.example.vea.VEA.convertors;

import com.example.vea.VEA.models.Address;
import com.example.vea.VEA.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IdToAddressConvertor implements Converter<String,Address> {

    @Autowired
    private AddressService addressService;

    @Override
    public Address convert(String source) {
        if(source == null || "".equals(source) || "null".equals(source)){
            return null;
        }

        return addressService.find(Long.parseLong(source));
    }
}
