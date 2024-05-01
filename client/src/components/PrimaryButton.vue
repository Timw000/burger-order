<template>
    <div class="container" :style="{ display: props.span ? undefined : 'inline-block' }">
        <button ref="btnRef" :disabled="props.disabled" :type="props.type ?? 'button'" @click="onClick"
            :class="{ 'loading': btnState === 'loading', 'success': btnState === 'success', 'secondary': variant === 'secondary' }"
            :style="{ width: props.span ? '100%' : undefined, minWidth: props.span ? undefined : '40px' }">
            <span v-if="btnState === 'default'" class="content">
                <slot></slot>
            </span>
            <span v-if="btnState === 'success'">
                <font-awesome-icon icon="fa-solid fa-check" />
            </span>
            <span v-if="btnState === 'loading'" class="spinner">
                <LoadingSpinner fill="rgb(231, 231, 231)" />
            </span>
        </button>
    </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import LoadingSpinner from './LoadingSpinner.vue';

const props = withDefaults(defineProps<{
    type?: "button" | "submit" | "reset"
    state?: 'loading' | 'success' | 'default'
    disabled?: boolean
    span?: boolean
    variant?: 'primary' | 'secondary'
}>(),
    {
        span: true,
        variant: 'primary'
    }
)

const btnRef = ref<HTMLButtonElement>()
const btnState = ref<'loading' | 'success' | 'default'>(props.state === 'loading' ? 'loading' : 'default')

watch(() => props.state, (state) => {
    btnState.value = state ?? 'default';
    if (btnState.value === 'success') {
        setTimeout(() => {
            btnState.value = 'default'
        }, 3000);
    }
})

const emit = defineEmits(['click'])

const onClick = (e: any) => {
    emit('click')
}


</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.container {
    .content {
        margin: 0 1rem;
    }
}

button {
    outline: none;
    height: 40px;
    text-align: center;
    width: 100%;
    border-radius: 40px;
    background: transparent;
    border: 2px solid $btn-color;
    color: $white;
    letter-spacing: 1px;
    text-shadow: 0;
    display: grid;
    align-items: center;
    justify-items: center;
    margin: 0 auto;

    font: {
        size: 12px;
    }

    cursor: pointer;
    transition: all 0.25s ease;

    &:hover {
        color: white;
        background: $btn-color;
    }

    &:active {
        letter-spacing: 2px;
    }

    &:disabled {
        color: white;
        background: rgb(188 188 188 / 27%);
        border: 2px solid rgb(188 188 188 / 27%);
        cursor: initial;

        &.loading {
            width: 40px;
            font-size: 0;
            background: transparent;
            border-color: $btn-color;

            &:hover {
                background: transparent;
            }
        }
    }

    &.secondary {
        color: $white;
        background-color: $btn-color;
        border: 2px solid $btn-color;
        font-weight: 600;

        &:hover {
            background-color: rgba($primary-color, .5);
        }

    }

    .spinner {
        height: 25px;
        width: 25px;
        display: grid;
        align-items: center;
    }

    &.loading {
        width: 40px;
        font-size: 0;

        &:hover {
            background: transparent;
        }
    }

    &.success {
        font-size: 13px;
        color: white;
        background: $btn-color;
    }

}
</style>