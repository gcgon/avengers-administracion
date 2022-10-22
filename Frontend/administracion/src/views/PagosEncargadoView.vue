<script setup>
import EncargadoH from '../components/EncargadoHeader.vue'
import EncargadoM from '../components/PagosEncargadoMain.vue'
</script>

<template>
  <div class="contenedor">
    <EncargadoH/>
    <EncargadoM/>
  </div>
</template>
  
<style scoped>
  .contenedor{
    height: 100%;
    display: grid;
    grid-template-rows: 13.89vh;
    grid-template-columns: 50vw;
  }
</style>