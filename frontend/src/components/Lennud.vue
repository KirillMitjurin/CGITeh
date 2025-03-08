<template>
  <div>
    <h3>
      Lennuplaan
    </h3>
    <ul class="lend">
      <li v-for="len in flights" key="lennud.id" class="lend">
        {{len.sihtkoht}},
        {{len.hind}}
      </li>
    </ul>
  </div>
</template>

<script>
  import Header from "@/components/Header.vue";

  export default {
    components: {Header},
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
text{
  color: black;
}
.lend{
  margin: auto;

}
</style>