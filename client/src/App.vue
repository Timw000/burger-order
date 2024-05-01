<template>
  <main>
    <nav>
      <router-link to="/">Order</router-link>
      <router-link to="/checkout">Checkout</router-link>
    </nav>
    <router-view />
  </main>
</template>

<script lang="ts" setup>
import { useBurgerStore } from './store/burgerStore';

</script>

<style lang="scss">
@import 'assets/variables.scss';

main {
  padding: 1rem;
  max-width: 1000px;
  margin: 0 auto;
}

nav {
  background-color: $primary-color;
  padding: 1rem;
  border-radius: $main-container-border-radius;
  display: flex;
  justify-content: left;

  a {
    color: $white;
    text-decoration: none;
    padding: 0.5rem 1rem;
    transition: background-color 0.3s;

    &:hover {
      background-color: $input-hover-background;
    }
  }
}
</style>
