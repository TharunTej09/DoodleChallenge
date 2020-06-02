package com.doodle_task.com.datagen;

import com.doodle_task.types.DeliveryAddress;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Random;

public class adddatagen {
    private static final adddatagen ourInstance = new adddatagen();
    private final Random random;

    private DeliveryAddress[] addresses;

    public adddatagen(Random random) {
        this.random = random;
    }

    private int getIndex() {
        return random.nextInt(100);
    }

    static adddatagen getInstance() {
        return ourInstance;
    }

    private adddatagen() {
        final String DATAFILE = "src/main/resources/data/address.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper = new ObjectMapper();
        try {
            addresses = mapper.readValue(new File(DATAFILE), DeliveryAddress[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    DeliveryAddress getNextAddress() {
        return addresses[getIndex()];
    }

}
