<script setup>

</script>

<template>
  <header class="header">
    <nav>
      <ul>
        <li>
          <router-link :to="{ name: 'Lennud' }">Lennuplaan</router-link>
        </li>
      </ul>
    </nav>
  </header>

</template>

<script>
export default {
  name: "HeaderComponent",
};
</script>

<style scoped>
.header {
  background-color: #ffffff;
  padding: 15px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);

}

text{
  color: black;
}

nav ul {
  list-style: none;
  display: flex;
  gap: 15px;
}

nav a {
  color: black;
  text-decoration: none;
}
</style>