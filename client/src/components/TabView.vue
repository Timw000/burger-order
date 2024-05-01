<template>
    <div class="tabs-container">
        <div class="tabs">
            <div v-for="(tab, index) in tabs" :key="index" class="tab" :class="{ active: modelValue === index }"
                @click="updateActiveTab(index)">
                <p>
                    {{ tab }}
                </p>
            </div>
        </div>
        <div class="tab-content">
            <slot></slot>
        </div>
    </div>
</template>

<script lang="ts" setup>
import { ref, defineProps, defineEmits } from 'vue';

// Define props
const props = defineProps<{
    tabs: string[],
    modelValue: number
}>();

// Define emits
const emit = defineEmits<{
    'update:modelValue': [index: number]
}>();

// Method to update active tab and emit the change
const updateActiveTab = (index: number) => {
    emit('update:modelValue', index);
};
</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.tabs-container {
    display: grid;
    grid-template-rows: auto 1fr;
    gap: 10px;
}

.tabs {
    display: grid;
    grid-auto-flow: column;
    border-bottom: 2px solid $secondary-color;
}

.tab {
    padding: 10px 20px;
    cursor: pointer;
    text-align: center;

    p {
        margin: 0;
        padding: 0;
    }
}

.tab.active {
    background-color: $secondary-color;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
}

</style>