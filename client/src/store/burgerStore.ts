import { Ingredients } from "@/models/ingredients";
import { Order } from "@/models/order";
import { OrderService } from "@/service/orderService";
import { defineStore } from "pinia";
import { ref } from "vue";


export const useBurgerStore = defineStore('burgerStore', () => {

    const burgerOrder = ref<Ingredients>({});
    const ingredients = ref<Ingredients>({});
    const orders = ref<Order[]>([]);

    const loadIngrediens = async () => {
        const response = await OrderService.getIngrediens();
        ingredients.value = response;
        Object.keys(response).forEach(key => {
            burgerOrder.value[key] = [];
        });
    }

    const addIngredient = (ingredientType: string, ingredient: string) => {
        if (!burgerOrder.value[ingredientType]) {
            burgerOrder.value[ingredientType] = [];
        }
        burgerOrder.value[ingredientType].push(ingredient);
    }

    const removeIngredient = (ingredientType: string, ingredient: string) => {
        const index = burgerOrder.value[ingredientType]?.indexOf(ingredient);
        if (index !== -1) {
            burgerOrder.value[ingredientType].splice(index, 1);
        }
    }

    const placeOrder = async () => {        
        const burger = Object.keys(burgerOrder.value).reduce((acc, key) => {
            acc[key.toLowerCase()] = burgerOrder.value[key];
            return acc;
        }, {} as Ingredients);
        const order = await OrderService.placeOrder(burger);
        orders.value.push(order);
        burgerOrder.value = {};
    }

    return { burgerOrder, ingredients, loadIngrediens, addIngredient, removeIngredient, placeOrder, orders };
})
