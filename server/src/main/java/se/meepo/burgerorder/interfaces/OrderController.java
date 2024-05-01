package se.meepo.burgerorder.interfaces;

import se.meepo.burgerorder.models.Burger;
import se.meepo.burgerorder.models.Order;
import se.meepo.burgerorder.models.ingredients.Bun;
import se.meepo.burgerorder.models.ingredients.Ingredient;
import se.meepo.burgerorder.models.ingredients.Patty;
import se.meepo.burgerorder.models.ingredients.Sauce;
import se.meepo.burgerorder.models.ingredients.Vegetable;
import se.meepo.burgerorder.services.OrderService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Order addOrder(@RequestBody Burger burger) throws Exception {
        return orderService.addOrder(burger);
    }

    @GetMapping("/ingrediens")
    public Map<String, List<Ingredient>> getIngrediens() {
        return Map.of(
            "Bun", List.of(Bun.values()),
            "Patty", List.of(Patty.values()),
            "Sauce", List.of(Sauce.values()),
            "Vegetable", List.of(Vegetable.values())
        );
    }
}

