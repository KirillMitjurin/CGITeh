import { createApp } from 'vue'
import {createRouter, createWebHistory} from "vue-router";
import App from './App.vue'
import Lennud from "@/components/Lennud.vue";
import Valik from "@/components/Valik.vue";

const router = createRouter({
    history: createWebHistory(),
    routes:[
        {path: '/Lennud', name: "Lennud", component: Lennud},
        {path: '/Valik/:lennudId', name: 'Valik',component: Valik}
    ]
})
const app = createApp(App)
app.use(router)

app.mount('#app')
