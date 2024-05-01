package se.meepo.burgerorder.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import se.meepo.burgerorder.models.ingredients.Bun;
import se.meepo.burgerorder.models.ingredients.Ingredient;
import se.meepo.burgerorder.models.ingredients.Patty;
import se.meepo.burgerorder.models.ingredients.Sauce;
import se.meepo.burgerorder.models.ingredients.Vegetable;

@Getter
@Setter
public class Burger {
    private List<Bun> bun;
    private List<Patty> patty;
    private List<Vegetable> vegetable;
    private List<Sauce> sauce;

    @JsonIgnore
    public List<Ingredient> getIngredients() {
        var ingredients = new ArrayList<Ingredient>();
        if (bun != null) {
            ingredients.addAll(bun);
        }
        if (patty != null) {
            ingredients.addAll(patty);
        }
        if (vegetable != null) {
            ingredients.addAll(vegetable);
        }
        if (sauce != null) {
            ingredients.addAll(sauce);
        }
        return ingredients;
    }
}
