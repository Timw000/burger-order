import { Ingredients } from "@/models/ingredients";
import { HttpClient } from "./httpClient";
import { Order } from "@/models/order";
const BASE_URL = '/order';

const placeOrder = async (orderedIngredients: Ingredients): Promise<Order> => {
    return await HttpClient.post<Ingredients, Order>(`${BASE_URL}`, orderedIngredients);
}

const getIngrediens = async (): Promise<Ingredients> => {
    return await HttpClient.get<Ingredients>(`${BASE_URL}/ingrediens`);
}

export const OrderService = {
    placeOrder,
    getIngrediens
};

