import {createRouter, createWebHistory} from "vue-router";
import Lennud from "@/components/Lennud.vue";
import Valik from "@/components/Valik.vue";

const routes = {
    '/': Lennud,
    '/Valik': Valik
}


const router = createRouter

export default router