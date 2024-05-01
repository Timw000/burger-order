import { defineStore } from "pinia";
import { ref } from "vue";


export const useModalStore = defineStore('modalStore', () => {
    const modals = ref<{ [modalId: string]: boolean }>({})

    const removeModal = (modalId: string) => {
        delete modals.value[modalId];
    }

    const addModal = (modalId: string) => {
        modals.value[modalId] = true;
    }

    const isModalOpen = (modalId: string) => modals.value[modalId] ?? false;

    const setState = (modalId: string, state: boolean) => {
        modals.value[modalId] = state;
    }

    return { modals,setState, removeModal, addModal, isModalOpen };
})
