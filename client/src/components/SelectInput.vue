<template>
    <div class="select-wrapper">
        <label :for="id" class="inp">
            <select :class="{ invalid: props.error }" :id="props.id"
                :placeholder="props.placeholder ?? '&nbsp;'" :value="currentValue" @input="updateValue"
                :invalid="props.error">
                <option v-for="option in allOptions" :key="option.value ?? 'default'" :value="option.value"
                    :disabled="option.disabled" :selected="option.default">{{ option.label }}
                </option>
            </select>
            <span class="label">{{ props.label }}</span>
            <span class="focus-bg"></span>
        </label>
    </div>
</template>

<script setup lang="ts">
import { watch, computed, ref, type Ref, onMounted } from 'vue';

const emit = defineEmits(['update:modelValue', 'input'])

const props = defineProps<{
    id: string;
    error?: boolean
    placeholder?: string
    label: string
    modelValue?: string
    options: { value: string, label: string, default?: boolean, disabled?: boolean }[]
    required?: boolean
}>()

const hasDefault = computed(() => props.options.find(o => o.default))

const placeholder = computed(() => ({
    value: '',
    label: "Välj " + props.label.toLocaleLowerCase(),
    default: !hasDefault.value,
    disabled: props.required
}))

const allOptions = computed(() => props.required ? props.options : [placeholder.value, ...props.options])

const currentValue = ref<string | undefined>(props.modelValue ?? props.options.find(o => o.default)?.value ?? placeholder.value.value)

watch(() => props.modelValue, (value) => {
    currentValue.value = allOptions.value.find(o => o.value === value)!.value
})

const updateValue = (event: any) => {
    currentValue.value = allOptions.value.find(o => o.value === event.target.value)!.value
    emit('update:modelValue', event.target.value ?? undefined)
    emit('input', event.target.value ?? undefined)
}

</script>

<style scoped lang="scss">
@import '../assets/variables.scss';

.select-wrapper {
    -webkit-text-size-adjust: 100%;
    -webkit-font-smoothing: antialiased;
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
        color: rgba($white, .6);
        font-weight: 500;
        transform-origin: 0 -20px;
        transform: translate3d(0, 0, 0);
        transition: all .2s ease;
        pointer-events: none;
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

    select {
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
        cursor: pointer;

        &:hover {
            background: $input-hover-background;
            box-shadow: inset 0 -2px 0 $secondary-color;
        }

        &:not(:placeholder-shown) {
            +.label {
                color: rgba($white, .5);
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

        &.invalid {
            box-shadow: inset 0 -2px 0 $error-color;
        }
    }
}

select:-webkit-autofill {
    +.label {
        color: $input-color;
        transform: translate3d(0, -12px, 0) scale(.75);
    }
}
</style>