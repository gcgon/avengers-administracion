<script setup>
import AdminH from '../components/AdminHeader.vue'
import AdminM from '../components/AdminCrearusuarioMain.vue'
</script>

<template>
  <div class="contenedor">
    <AdminH/>
    <AdminM/>
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