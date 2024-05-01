<template>
  <div class="builder">
    <h1>Create your burger</h1>
    <ul class="ingredient-list">
      <li v-for="(ingredients, ingredientType) in burgerStore.ingredients" :key="ingredientType" class="ingredient-type">
        <h2>{{ ingredientType }}</h2>
        <ul>
          <li v-for="ingredient in ingredients" :key="ingredientType + ingredient" class="ingredient-item">
            <p>{{ ingredient }}</p>
            <div class="buttons">
              <button @click="onAddIngredient(ingredientType.toString(), ingredient)" class="add-btn">Add</button>
              <button @click="onRemoveIngredient(ingredientType.toString(), ingredient)" class="remove-btn">Remove</button>
            </div>
          </li>
        </ul>
      </li>
    </ul>
  </div>
  <div class="order">
    <h2>Your order</h2>
    <ul class="order-list">
      <li v-for="(ingredients, ingredientType) in burgerStore.burgerOrder" :key="'order' + ingredientType" class="order-type">
        <p>{{ ingredientType }}</p>
        <ul>
          <li v-for="ingredient in ingredients" :key="'order' + ingredientType + ingredient" class="order-item">
            {{ ingredient }}
          </li>
        </ul>
      </li>
    </ul>
  </div>
  <div class="buttons">
    <router-link to="/checkout" class="place-order-btn">Checkout</router-link>
  </div>
</template>

<script lang="ts" setup>
import { useBurgerStore } from '@/store/burgerStore';

const burgerStore = useBurgerStore();

const onAddIngredient = (ingredientType: string, ingredient: string) => {
  burgerStore.addIngredient(ingredientType, ingredient);
}

const onRemoveIngredient = (ingredientType: string, ingredient: string) => {
  burgerStore.removeIngredient(ingredientType, ingredient);
}

</script>

<style lang="scss" scoped>
@import '../assets/variables.scss';

.builder, .order {
  padding: 1rem;
  border-radius: 8px;
  background-color: lighten($background-color, 5%);
  border: 1px solid darken($background-color, 5%);
  margin: 1rem 0;
}

h1, h2 {
  color: $primary-color;
}

.ingredient-list {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1rem;

  @media (max-width: 1000px) {
    grid-template-columns: repeat(2, 1fr);
  }

  @media (max-width: 500px) {
    grid-template-columns: 1fr;
  }
}

.ingredient-list, .order-list {
  list-style-type: none;
  padding: 0;
}

.ingredient-type, .order-type {
  margin-bottom: 1rem;
  background-color: lighten($background-color, 10%);
  border: 1px solid darken($background-color, 5%);  padding: 0.5rem;
  border-radius: 4px;
}

.ingredient-item, .order-item {
  align-items: center;
  padding: 0.25rem 0.5rem;
  border-bottom: 1px solid #ddd;

  display: grid;
  grid-template-columns: max-content 1fr;

  .buttons {
    display: flex;
    align-items: center;
    justify-self: end;
  }
}

.add-btn, .remove-btn {
  padding: 0.25rem 0.5rem;
  margin-left: 0.5rem;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  background-color: $secondary-color;
  color: $button-text-color;
}

.place-order-btn {
  display: block;
  width: 100%;
  text-align: center;
  padding: 1rem;
  background-color: $primary-color;
  color: $button-text-color;
  text-decoration: none;
  border-radius: 4px;
}

.place-order-btn:hover {
  background-color: darken($primary-color, 10%);
}

</style>

