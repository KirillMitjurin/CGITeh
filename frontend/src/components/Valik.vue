<template>
  <div class="konteiner">
    <h1>Istekohta valik</h1>
    <div class="filters">
      <label>
        <input type="number" v-model="value" min="1" class="input-number"/>
        Pileti arv: {{ value }}
      </label>

      <label>
        <input type="checkbox" id="checkbox" v-model="akna_all"/>
        Akna all
      </label>

      <label>
        <input v-model="jalaruum" type="checkbox" id="checkbox"/>
        Rohkem Jalaruumi
      </label>

      <label>
        <input type="checkbox" v-model="valjapääsul"/>
        Lähedal väljapääsule
      </label>

      <button @click="getRecomendations" class="nupp"> Rekomendeeri</button>
    </div>

    <div class="kohad">
      <div class="first-rows">
        <div v-for="koht in eesRida" :key="koht.id" @mouseover="showInfo(koht)" @mouseleave="hideInfo(koht)" @click="valikoht(koht)"
             class="seat"
             :class="{ 'occupied': koht.seatOccupied, 'window': koht.underWindow, 'legspace': koht.legSpace, 'exit': koht.closeToExit, 'rekomendeeritud': koht.rekomendeeritud}">
          {{ koht.rowNumber }}{{ getLetter(koht.columnNumber) }}
          <div v-if="koht.showInfo" class="seat-info">
            <p v-if="koht.underWindow"> akna all </p>
            <p v-if="koht.legSpace"> Extra ruum </p>
            <p v-if="koht.closeToExit"> Valjapaas </p>
          </div>
        </div>
      </div>

      <div class="back-rows">
        <div v-for="koht in tagaRida" :key="koht.id" @mouseover="showInfo(koht)" @mouseleave="hideInfo(koht)" @click="valikoht(koht)"
             class="seat"
             :class="{ 'occupied': koht.seatOccupied, 'window': koht.underWindow, 'legspace': koht.legSpace, 'exit': koht.closeToExit, 'rekomendeeritud': koht.rekomendeeritud}">
          {{ koht.rowNumber }}{{ getLetter(koht.columnNumber) }}
          <div v-if="koht.showInfo" class="seat-info">
            <p v-if="koht.underWindow"> akna all </p>
            <p v-if="koht.legSpace"> Extra ruum </p>
            <p v-if="koht.closeToExit"> Valjapaas </p>
            <p v-else-if="!koht.underWindow && !koht.legSpace && !koht.closeToExit"> tavaline </p>
          </div>
        </div>
      </div>
    </div>
    <b></b>
  </div>

</template>

<script>
export default {
  data() {
    return {
      jalaruum: false,
      akna_all: false,
      valjapääsul: false,
      value: 1,
      istekohad: [],
      eesRida: [],
      tagaRida: [],
      sobivadKohad: [],

    };
  },
  methods: {
    showInfo(koht) { // väljastab info koha kohta
      koht.showInfo = true;
    },

    hideInfo(koht) { // peidab info koha kohta
      koht.showInfo = false;
    },
    async getRecomendations() { // teeb API request, saab json, fecthib seda.
      const lennudId = this.$route.params.lennudId;
      const res = await fetch(`http://localhost:8080/api/istekohadRekomendation?id=${lennudId}&arv=${this.value}&aken=${this.akna_all}&ruum=${this.jalaruum}&valjapaas=${this.valjapääsul}`)
      const finalRes = await res.json();
      this.sobivadKohad = finalRes;
      this.eesRida = this.eesRida.map(koht => ({
        ...koht,
        rekomendeeritud: this.sobivadKohad.some(sobivKoht => sobivKoht.id === koht.id)
      }))
      this.tagaRida = this.tagaRida.map(koht => ({
        ...koht,
        rekomendeeritud: this.sobivadKohad.some(sobivKoht => sobivKoht.id === koht.id)
      }))

    },
    async getData() { // Teeb API requesti, saab kogu informatisoon istekoha kohta
      const lennudId = this.$route.params.lennudId;
      const res = await fetch(`http://localhost:8080/api/istekohad?id=${lennudId}`)
      const finalRes = await res.json();
      this.istekohad = finalRes.map(koht => ({...koht, showInfo: false}));
      this.eesRida = finalRes
          .filter(koht => koht.rowNumber < 5)
          .map(koht => ({...koht, showInfo: false, rekomendeeritud: false}));

      this.tagaRida = finalRes
          .filter(koht => koht.rowNumber >= 5)
          .map(koht => ({...koht, showInfo: false, rekomendeeritud: false}));

    },
    getLetter(kohtNumber) { // muutub numbrid tähiseks
      return String.fromCharCode(64 + kohtNumber);
    },
  },
  mounted() {
    this.getData()
  }
}


</script>


<style scoped>

.konteiner {
  text-align: center;
  font-family: Arial, sans-serif;
}

.filters {
  margin-bottom: 20px;
}

.input-number {
  width: 50px;
  margin-right: 10px;
}

.nupp {
  background: #007bff;
  color: white;
  border: none;
  padding: 10px 15px;
  cursor: pointer;
  border-radius: 5px;
  font-size: 16px
}

.nupp:hover {
  background-color: #0056b3;
}

.kohad {
  display: flex;
  flex-direction: column;
  align-items: center;
  background: #e5e5e5;
  padding: 20px;
  border-radius: 8px;
  width: fit-content;
  margin: auto;
}

.first-rows, .back-rows {
  display: grid;
  grid-gap: 10px;
  background: white;
  padding: 10px;
  border-radius: 8px;
}

.first-rows {
  grid-template-columns: repeat(1, 50px) 150px repeat(2, 50px);
}

.back-rows {
  grid-template-columns: repeat(2, 50px) 100px repeat(3, 50px);
}


.seat {
  width: 50px;
  height: 50px;
  border-radius: 8px;
  border: 2px solid #999;
  background-color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  cursor: pointer;
  transition: transform 0.2s, background-color 0.3s;
  position: relative;
}

.seat.valitud {
  background-color: green !important;
}

.seat.rekomendeeritud {
  background-color: yellow !important;
  color: black;
  border: 2px solid orange;
}

.seat-info {
  position: absolute;
  bottom: -30px;
  background-color: white;
  border: 1px solid #ccc;
  padding: 5px;
  border-radius: 5px;
  font-size: 12px;
  white-space: nowrap;
  display: none;
  color: black;
}

.seat:hover .seat-info {
  display: block;
}

.seat.occupied {
  background-color: red !important;
  color: white;
}


.seat.window {
  border-color: blue;
}


.seat.legspace {
  background-color: lightblue;
  margin-top: 15px;
}


.seat.exit {

  border-color: green;

}


</style>