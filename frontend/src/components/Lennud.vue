<template>
    <h3>Lennuplaan</h3>
    <div class = "filtrid">
    <select name="Lähtekoht" v-model="lahteKoht">
      <option></option>
      <option v-for="(lahte, index) in alllahteKoht" :key="index" :value="lahte">
        {{ lahte }}
      </option>
    </select>

    <select name="Sihtkoht" v-model="sihtkoht">
      <option></option>
      <option v-for="(siht, index) in allsihtKoht" :key="index" :value="siht">
        {{ siht }}
      </option>
    </select>

    <input v-model="hind" type="range" min="0" max="1000" />

    <input v-model="kuupaevAeg" type="date">

  </div>
  <div>
    <ul class="lend">
      <li v-for="len in filterFlights" key="len.id" class="lend">
        {{ len.lahteKoht }}, {{ len.sihtkoht }}, {{ len.hind }} , {{len.kuupaev}}
        <router-link :to="{name: 'Valik', params: {lennudId: len.id} }">
          <button >Purchase</button>
        </router-link>
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
        lahteKoht: "",
        sihtkoht: "",
        hind: "1000",
        kuupaevAeg: "",
        flights: [],
        alllahteKoht: [],
        allsihtKoht: [],
        filteredFlights: [],
      };
    },
    computed: {
      filterFlights: function () {
        return this.flights.filter(flight => {
          const lahteKoht = !this.lahteKoht || flight.lahteKoht === this.lahteKoht;
          const sihtkoht = !this.sihtkoht || flight.sihtkoht === this.sihtkoht;
          const hind = parseInt(this.hind) > 0 && flight.hind <= parseInt(this.hind);
          const kuupaevAegMatch = !this.kuupaevAeg || flight.kuupaevAeg.substring(0,10) === this.kuupaevAeg;
          return lahteKoht && sihtkoht && hind && kuupaevAegMatch
        })
      }},
      methods: {
        async getData() {
          const res = await fetch("http://localhost:8080/api/lennud")
          const finalRes = await res.json();
          this.flights = finalRes;
          this.alllahteKoht = [...new Set(finalRes.map(flight => flight.lahteKoht))]
          this.allsihtKoht = [...new Set(finalRes.map(flight => flight.sihtkoht))]
        },
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

.lend{
  margin-top: 5%;
}
</style>