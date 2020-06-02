package com.doodle_task.com.datagen;

import com.doodle_task.types.LineItem;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Random;

public class prodgen {

    private static final prodgen ourInstance = new prodgen();
    private final Random random;
    private final Random qty;
    private final LineItem[] products;

    static prodgen getInstance() {
        return ourInstance;
    }

    private prodgen() {
        String DATAFILE = "src/main/resources/data/products.json";
        ObjectMapper mapper = new ObjectMapper();
        random = new Random();
        qty = new Random();
        try {
            products = mapper.readValue(new File(DATAFILE), LineItem[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(100);
    }

    private int getQuantity() {
        return qty.nextInt(2) + 1;
    }

    LineItem getNextProduct() {
        LineItem lineItem = products[getIndex()];
        lineItem.setItemQty(getQuantity());
        lineItem.setTotalValue(lineItem.getItemPrice() * lineItem.getItemQty());
        return lineItem;
    }


}
