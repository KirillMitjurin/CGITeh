<script setup>

</script>

<template>
  <header class="header">
    <nav>
      <ul>
        <li><router-link to="/">Avaleht</router-link></li>
        <li><router-link to="/lennuplaan">Lennuplaan</router-link></li>
        <li><router-link to="/kontakt">Kontakt</router-link></li>
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
  background-color: #007bff;
  padding: 15px;
  color: white;
}

nav ul {
  list-style: none;
  display: flex;
  gap: 15px;
}

nav a {
  color: white;
  text-decoration: none;
}
</style>