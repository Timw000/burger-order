package se.meepo.burgerorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.meepo.burgerorder.models.Burger;
import se.meepo.burgerorder.models.Order;
import se.meepo.burgerorder.models.ingredients.Bun;
import se.meepo.burgerorder.models.ingredients.Ingredient;
import se.meepo.burgerorder.models.ingredients.Patty;
import se.meepo.burgerorder.models.ingredients.Sauce;
import se.meepo.burgerorder.models.ingredients.Vegetable;
import se.meepo.burgerorder.repositories.OrderDatabase;

@Service
public class OrderService {

    @Autowired
    private OrderDatabase orderDatabase;

    public Order addOrder(Burger burger) {
        var order = new Order();
        order.setBurger(burger);
        order.setId(orderDatabase.addOrder(order));
        order.setPrice(calculatePrice(burger));
        return order;
    }

    public double calculatePrice(Burger burger) {
        double price = 0;
        for (Ingredient ingredient : burger.getIngredients()) {
            price += getUnitPrice(ingredient);
        }
        return price;
    }

    public static double getUnitPrice(Ingredient ingredient) {
        if (ingredient instanceof Bun) {
            return 20;
        }
        if (ingredient instanceof Patty) {
            return 50;
        }
        if (ingredient instanceof Vegetable) {
            return 10;
        }
        if (ingredient instanceof Sauce) {
            return 10;
        }
        throw new IllegalArgumentException("Unknown ingredient type");
    }
}
