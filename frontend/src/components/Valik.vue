<template>
  <h1>Istekohta valik</h1>
  <p> Pileti arv: {{ value }}</p>
  <input type="number" v-model="value"/>

  <input type="checkbox" id="checkbox" v-model="akna_all" />
  <label for="checkbox">  Akna all</label>

  <input v-model="jalaruum" type="checkbox" id="checkbox"  />
  <label for="checkbox"> Rohkem Jalaruumi</label>

  <input type="checkbox" id="checkbox" v-model="valjapääsul" />
  <label for="checkbox"> Lähedal väljapääsule</label>

  <button > recomend</button>
    <div class="first-rows">
      <div v-for="koht in istekohad" :key="koht.id" class="seat" :class="{ 'occupied': koht.seatOccupied, 'window': koht.underWindow, 'legspace': koht.legSpace, 'exit': koht.closeToExit }">
        {{ koht.rowNumber }}-{{ koht.columnNumber }}
      </div>
    </div>
</template>

<script >
  export default {
    data() {
    return {
      jalaruum: false,
      akna_all: false,
      valjapääsul: false,
      value: 1,
      istekohad: [],
    };
  },
    methods: {
      async getData(){
        const lennudId  =this.$route.params.lennudId;
        const res = await fetch(`http://localhost:8080/api/istekohad?id=${lennudId}`)
        const finalRes = await res.json();
        this.istekohad = finalRes;
      }
    },
    mounted() {
      this.getData()
    },
    computed: {
      lennudId() {
        return this.$route.params.lennudId;
      }
    }

  }

</script>

<style scoped>

.first-rows {
  display: grid;
  grid-template-columns: repeat(4, 50px);
  gap: 5px;
}

.seat {
  width: 50px;
  height: 30px;
  border: 1px solid #ccc;
  display: flex;
  justify-content: center;
  align-items: center;
}

.seat.occupied {
  background-color: red;
  color: white;
}

.seat.window {
  border-color: blue;
}

.seat.legspace {
  background-color: lightblue;
}

.seat.exit {
  border-color: green;
}

</style>