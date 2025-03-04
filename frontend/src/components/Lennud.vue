

<template>
  <div>
    <h3>
      Lennuplaan
    </h3>
    <ul>
      <li v-for="len in flights" key="lennud.id">
        {{len.sihtkoht}},
        {{len.hind}}
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        flights: [],
      };
    },
    methods: {
      async getData(){
        const res = await fetch("http://localhost:8080/lennud/api")
        const finalRes = await res.json();
        this.flights = finalRes;
      }
    },
    mounted() {
      this.getData()
    }
  }
</script>

<style scoped>

</style>