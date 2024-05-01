import { Ingredients } from "./ingredients";

export interface Order {
    id: string;
    burger: Ingredients;
    price: number;
}

