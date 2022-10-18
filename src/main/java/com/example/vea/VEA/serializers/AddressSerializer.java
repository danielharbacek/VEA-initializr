package com.example.vea.VEA.serializers;

import com.example.vea.VEA.models.Address;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class AddressSerializer extends StdSerializer<Address> {

    public AddressSerializer(){
        super(Address.class);
    }

    protected AddressSerializer(Class<Address> t) {
        super(t);
    }

    @Override
    public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("address", address.getStreet() + " " + address.getCity());
        jsonGenerator.writeEndObject();
    }
}
