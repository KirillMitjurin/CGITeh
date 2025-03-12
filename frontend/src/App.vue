import Lennud from "@/components/Lennud.vue";

<script setup>
import Lennud from "@/components/Lennud.vue";
import Header from "@/components/Header.vue";
import Valik from "@/components/Valik.vue";
import InputNumber from 'primevue/inputnumber';
</script>

<template>
  <Header></Header>
  <router-view></router-view>
</template>

<style>
  body{
    background-color: white;
    margin: 0;
    padding: 0;
  }
</style>
