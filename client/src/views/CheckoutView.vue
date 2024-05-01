<template>
    <div v-if="Object.keys(burgerStore.burgerOrder).length">
        <h1>Checkout</h1>
        <div class="Confirmation">
            <h2>Your order</h2>
            <ul class="checkout-list">
                <li v-for="(ingredients, ingredientType) in burgerStore.burgerOrder" :key="'order' + ingredientType"
                    class="order-type">
                    <p>{{ ingredientType }}</p>
                    <ul>
                        <li v-for="ingredient in ingredients" :key="'order' + ingredientType + ingredient"
                            class="order-item">
                            {{ ingredient }}
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="buttons">
            <PrimaryButton @click="onPlaceOrder" class="place-order-btn">Place order</PrimaryButton>
        </div>
    </div>
    <div class="orders" v-if="burgerStore.orders.length">
        <h2>Your orders</h2>
        <ul>
            <li v-for="order in burgerStore.orders" :key="order.id">
                <h2>
                    {{ order.price }} kr
                </h2>
                <p>
                    {{ order.id }}
                </p>
                <ul class="order-list">
                    <span>Ingredients</span>
                    <li v-for="(ingredients, ingredientType) in order.burger" :key="order.id + ingredientType">
                        <ul>
                            <li v-for="ingredient in ingredients" :key="order.id + ingredientType + ingredient"
                                class="order-item">
                                <p>
                                    {{ ingredient }}
                                </p>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

</template>

<script lang="ts" setup>
import PrimaryButton from '@/components/PrimaryButton.vue';
import { useBurgerStore } from '@/store/burgerStore';


const burgerStore = useBurgerStore();

const onPlaceOrder = () => {
    burgerStore.placeOrder();
}

</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.order {
    padding: 1rem;
    border-radius: 8px;
    background-color: lighten($background-color, 5%);
    border: 1px solid darken($background-color, 5%);
    margin: 1rem 0;
}

h1,
h2 {
    color: $primary-color;
}

.order-list {
    list-style-type: none;
    padding: 0;
    background-color: lighten($background-color, 10%);
    border: 1px solid darken($background-color, 5%);
    border-radius: 4px;
    padding: 0.5rem;
    max-width: 300px;
}

.order-type {
    margin-bottom: 1rem;
    background-color: lighten($background-color, 10%);
    border: 1px solid darken($background-color, 5%);
    padding: 0.5rem;
    border-radius: 4px;
}

.order-item {
    align-items: center;
    padding: 0.25rem 0.5rem;
    border-bottom: 1px solid #ddd;
}
</style>
