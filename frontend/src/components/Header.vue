<script setup>

</script>

<template>
  <header class="header">
    <nav>
      <ul>
        <li>Avaleht</li>
        <li>Lennuplaan</li>
        <li>Kontakt</li>
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