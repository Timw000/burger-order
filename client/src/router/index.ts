import { createRouter, createWebHistory, RouteLocationNormalized, RouteRecordRaw } from 'vue-router'
import OrderView from '@/views/OrderView.vue'
import CheckoutView from '@/views/CheckoutView.vue'
import { useBurgerStore } from '@/store/burgerStore'

const guard = async (to: RouteLocationNormalized, from: RouteLocationNormalized) => {
  const burgerStore = useBurgerStore();
  if (Object.keys(burgerStore.ingredients).length === 0) {
    await burgerStore.loadIngrediens();
  }
  return true;
}

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'order',
    component: OrderView,
    beforeEnter: guard
  },
  {
    path: '/checkout',
    name: 'checkout',
    component: CheckoutView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
