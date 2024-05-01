<template>
    <div class="spinner">
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 994.98 951" :fill="props.fill ?? '#b889f9'">
            <path d="M353,25C149.84,87.59,2.18,276.8,2.18,500.5S149.84,913.41,353,976Z" transform="translate(-2.18 -25)" />
            <path d="M790.44,904.18C915.65,813.83,997.16,666.69,997.16,500.5S915.65,187.17,790.44,96.82L353,500.5Z"
                transform="translate(-2.18 -25)" />
        </svg>
    </div>
</template>

<script setup lang="ts">

const props = defineProps<{
    fill?: string
}>()

</script>

<style scoped>
.spinner {
    animation: spin 1.2s infinite;
    line-height: 0;
    margin: 0;
    padding: 0;
}

@keyframes spin {
    0% {
        transform: rotate(0);
        animation-timing-function: cubic-bezier(0.55, 0.055, 0.675, 0.19);
    }

    50% {
        transform: rotate(400deg);
        animation-timing-function: cubic-bezier(0.215, 0.61, 0.355, 1);
    }

    100% {
        transform: rotate(720deg);
    }
}
</style>