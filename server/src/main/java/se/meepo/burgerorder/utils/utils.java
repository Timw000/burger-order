package se.meepo.burgerorder.utils;

import java.util.UUID;

public class utils {

    public static String generateOrderId() {
        return UUID.randomUUID().toString();
    }
    
}
