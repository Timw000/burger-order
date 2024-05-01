package se.meepo.burgerorder.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String id;
    private Burger burger;
    private double price;
}
