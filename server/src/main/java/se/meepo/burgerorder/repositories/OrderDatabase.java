package se.meepo.burgerorder.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import se.meepo.burgerorder.models.Order;

@Getter
@Setter
@Service
public class OrderDatabase {

    private final Map<String, Order> orders = new HashMap<>();

    public String addOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        orders.put(order.getId(), order);
        return order.getId();
    }

}
