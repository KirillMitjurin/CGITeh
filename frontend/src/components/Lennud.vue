<template>
  <div class="filtrid">

    <label>Lähtekoht</label>
    <select name="Lähtekoht" v-model="lahteKoht">
      <option></option>
      <option v-for="(lahte, index) in alllahteKoht" :key="index" :value="lahte">
        {{ lahte }}
      </option>
    </select>

    <label>Sihtkoht</label>

    <select name="Sihtkoht" v-model="sihtkoht">
      <option></option>
      <option v-for="(siht, index) in allsihtKoht" :key="index" :value="siht">
        {{ siht }}
      </option>
    </select>

    <label>Hind: {{ hind }} €</label>
    <input v-model="hind" type="range" min="0" max="1000"/>

    <label>Kuupaev</label>
    <input v-model="kuupaevAeg" type="date"/>

    <button @click="filterFlights">filter</button>

  </div>
  <li v-for="len in filteredFlights" :key="len.id" class="lend">
    <div class="ticket">
      <div class="top-section">
        <div class="route">{{ len.lahteKoht }} → {{ len.sihtkoht }}</div>
        <div class="time">{{ len.väljasõit }} - {{ len.saabumine }}</div>
        <div class="price">Hind: {{ len.hind }} €</div>
      </div>
      <div class="bottom-section">
        <div class="flight-info">{{ len.lennufirma }}, {{ len.lennunumber }}</div>
        <div class="date">{{ len.kuupaev }}</div>
        <div class="duration">{{ formatKestus(len.kestus) }}</div>
        <router-link :to="{ name: 'Valik', params: { lennudId: len.id } }">
          <button class="buy-btn">Osta</button>
        </router-link>
      </div>
    </div>
  </li>
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
  computed: {},
  methods: {
    async getData() { // teeb requestˇi, saab andmed
      const res = await fetch("http://localhost:8080/api/lennud")
      const finalRes = await res.json();
      this.flights = finalRes;
      this.alllahteKoht = [...new Set(finalRes.map(flight => flight.lahteKoht))]
      this.allsihtKoht = [...new Set(finalRes.map(flight => flight.sihtkoht))]
      this.filteredFlights = finalRes;
    },
    filterFlights() { // filtreeerib lennud
      this.filteredFlights = this.flights.filter(flight => {
        const lahteKoht = !this.lahteKoht || flight.lahteKoht === this.lahteKoht;
        const sihtkoht = !this.sihtkoht || flight.sihtkoht === this.sihtkoht;
        const hind = parseInt(this.hind) > 0 && flight.hind <= parseInt(this.hind);
        const kuupaevAegMatch = !this.kuupaevAeg || flight.kuupaev.substring(0, 10) === this.kuupaevAeg;
        return lahteKoht && sihtkoht && hind && kuupaevAegMatch
      })
    },
    formatKestus(duration){ // formatterib kestus.
      const match = duration.match(/PT(\d+H)?(\d+M)?/);
      let hours = match[1] ? match[1].replace("H", " tunnid") : "";
      let minutes = match[2] ? match[2].replace("M", " minutid") : "";
      return `${hours} ${minutes}`.trim()
    }
  },
  mounted() {
    this.getData()
  }
}
</script>

<style>
.filtrid{
  width: 50%;
  margin: 20px auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 10px;
  padding: 15px;
  background: #f8f8f8;
  border-radius: 8px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.filtrid text{
  align-content: center;
}

.filtrid select,
.filtrid input,
.filtrid button {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
}

.filtrid label {
  font-weight: bold;
  margin-bottom: 5px;
}

.filtrid button {
  background: #007bff;
  color: white;
  cursor: pointer;
}

.filtrid button:hover {
  background: #0056b3;
}

.lend {
  list-style: none;
  display: flex;
  justify-content: center;
  width: 100%;
}

.ticket {
  width: 80%;
  max-width: 800px;
  background: white;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 16px;
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-top: 10px;

}

.top-section {
  display: flex;
  justify-content: space-between;
  font-size: 18px;
  font-weight: bold;
}

.bottom-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 14px;
  color: #555;
}

.price {
  color: black;
}

.buy-btn {
  background: #007bff;
  color: white;
  padding: 8px 16px;
  border-radius: 6px;
  border: none;
  cursor: pointer;
}

.buy-btn:hover {
  background: #0056b3;
}

text {
  color: black;
}
</style>