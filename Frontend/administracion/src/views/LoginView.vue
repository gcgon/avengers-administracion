<script setup>
import LoginH from '../components/LoginHeader.vue'
import LoginM from '../components/LoginMain.vue'
</script>

<template>
  <div class="contenedor">
    
    <LoginH/>
    <LoginM/>
    
  </div>
</template>
  
<style>
  .contenedor{
    height: 100%;
    display: grid;
    grid-template-columns: 33vw 33vw;
    grid-template-rows: 13.89vh 16.66vh 55.55vh;
  }
</style>
  