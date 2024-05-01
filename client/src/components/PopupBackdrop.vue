<template>
    <div class="popup-wrapper" :class="['popup-wrapper', { 'hide': !props.show, center: props.useContainer }]"
        @click="onClose">
        <Transition>
            <div v-if="props.show" :class="{ 'content-wrapper': props.useContainer, 'with-padding': props.usePadding }"
                @click="(e) => e.stopPropagation()">
                <span v-if="props.useCloseIcon" class="close-icon" @click="onClose">
                    <font-awesome-icon icon="fa-solid fa-xmark" />
                </span>
                <div class="content">
                    <slot></slot>
                </div>
            </div>
        </Transition>

    </div>
</template>

<script setup lang="ts">
import { useModalStore } from '@/store/modalStore';
import { GeneralUtils } from '@/utils/generalUtils';
import { onMounted, onUnmounted, watch } from 'vue';


const props = defineProps<{
    show: boolean
    useContainer?: boolean
    useCloseIcon?: boolean
    usePadding?: boolean
}>();

const modalStore = useModalStore();
const modalId = GeneralUtils.UUID();
const emit = defineEmits(['onClose'])
const onClose = () => {
    emit('onClose')
}

watch(() => props.show, (isShowing: boolean) => {
    modalStore.setState(modalId, isShowing);
})

onMounted(() => {
    modalStore.addModal(modalId);
})

onUnmounted(() => {
    modalStore.removeModal(modalId);
})

</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.popup-wrapper {
    width: 100vw;
    height: 100vh;
    z-index: 2;
    position: fixed;
    overflow: scroll;
    opacity: 1;
    top: 0;
    left: 0;
    overscroll-behavior: contain;
    background-color: rgba(32, 39, 78, 60%);

    &.center {
        display: grid;
        justify-items: center;
        align-items: center;
    }

    &.hide {
        display: none;
    }

    .content-wrapper {
        background-color: rgba(darken($primary-color, 20), .9);
        border: 1px solid rgba(darken($primary-color, 25), .9);
        border-radius: 10px;
        color: $white;
        box-shadow: -3px 2px 17px rgba(0, 0, 0, .5);
        display: grid;
        justify-items: center;
        align-items: center;
        position: relative;
        max-width: 95vw;

        .close-icon {
            font-size: 2rem;
            background-color: darken($primary-color, 28);
            border-radius: 200px;
            padding: 1rem;
            line-height: 2rem;
            text-align: center;
            border: 2px solid;
            cursor: pointer;
            position: absolute;
            right: -.5rem;
            top: -1rem;
            transition: background-color .2s;
            box-shadow: 0 3px 5px rgba(0, 0, 0, .5);


            @include tablet {
                right: -1rem;
            }

            &:hover {
                background-color: darken($primary-color, 24);
            }

            svg {
                width: 2rem;
                height: 2rem;
            }

        }

        .content {
            max-height: 90vh;
            overflow-y: scroll;
            overflow-x: auto;
            max-width: 100%;

            /* width */
            &::-webkit-scrollbar {
                width: 10px;
            }

            /* Track */
            &::-webkit-scrollbar-track {
                background: #ffffff00;
            }

            /* Handle */
            &::-webkit-scrollbar-thumb {
                background: $secondary-color;
            }

            /* Handle on hover */
            &::-webkit-scrollbar-thumb:hover {
                background: $secondary-color;
            }
        }
    }

    .with-padding {
        padding: 3rem;
        min-width: 300px;
        max-width: 95vw;
        min-height: 150px;

        @include tablet {
            max-width: 600px;
        }
    }
}

.v-enter-active,
.v-leave-active {
    transition: transform .5s ease;
}

.v-enter-from,
.v-leave-to {
    opacity: 0;
    transform: translateY(30px);
}
</style>