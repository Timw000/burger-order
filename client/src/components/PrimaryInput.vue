<template>
    <div class="wrapper">
        <label :for="id" class="inp">
            <input :class="{invalid: props.error}" :type="props.type.toString()" :id="props.id" :placeholder="'&nbsp;'"
                :value="modelValue" @input="onInput" :invalid="props.error" @change="onChange">
            <span class="label">{{ props.label }}</span>
            <span class="focus-bg"></span>
        </label>
    </div>
</template>

<script setup lang="ts">


const emit = defineEmits(['update:modelValue', 'input', 'change'])

const onInput = (event: any) => {
    emit('update:modelValue', event.target.value)
    emit('input', event.target.value)
}

const onChange = (event: any) => {
    emit('update:modelValue', event.target.value)
    emit('change', event.target.value)
}

const props = defineProps<{
    id: string;
    label: string
    type: string | number | boolean
    error?: boolean
    modelValue?: string
}>()


</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.wrapper {
    -webkit-text-size-adjust: 100%;
    -webkit-font-smoothing: antialiased;
    overflow: hidden;
}

.inp {
    position: relative;
    margin: auto;
    width: 100%;
    max-width: 280px;
    border-radius: 3px;
    overflow: hidden;

    .label {
        position: absolute;
        top: 0px;
        left: 12px;
        font-size: 16px;
        color: rgba($white, 1);
        font-weight: 500;
        transform-origin: 0 -20px;
        transform: translate3d(0, 0, 0);
        transition: all .2s ease;
        pointer-events: none;
        white-space: nowrap;
    }

    .focus-bg {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: transparent;
        z-index: -1;
        transform: scaleX(0);
        transform-origin: left;
    }

    input {
        -webkit-appearance: none;
        appearance: none;
        width: 100%;
        border: 0;
        font-family: inherit;
        padding: 16px 12px 0 12px;
        height: 56px;
        font-size: 16px;
        font-weight: 600;
        background: transparent;
        box-shadow: inset 0 -2px 0 $input-color;
        color: $white;
        transition: all .15s ease;

        &::placeholder{
            color: rgba($white, .5);
            font-weight: 400;
        }

        &:hover {
            background: $input-hover-background ;
            box-shadow: inset 0 -2px 0 $secondary-color;
        }

        &:not(:placeholder-shown) {
            +.label {
                color: rgba($white, 1);
                transform: translate3d(0, -12px, 0) scale(.75);
            }
        }

        &:focus {
            background: rgba($white, .07);
            box-shadow: inset 0 -2px 0 $secondary-color;
            outline: none;

            +.label {
                transform: translate3d(0, -12px, 0) scale(.75);

                +.focus-bg {
                    transform: scaleX(1);
                    transition: all .1s ease;
                }
            }
        }

        &.invalid{
            box-shadow: inset 0 -2px 0 $error-color;
        }
    }
}

input:-webkit-autofill {
    +.label {
        color: $input-color;
        transform: translate3d(0, -12px, 0) scale(.75);
    }
}
</style>