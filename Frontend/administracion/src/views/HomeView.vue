<script setup>
import InicioM from '../components/InicioMain.vue'
import InicioH from '../components/InicioHeader.vue'
import InicioF from '../components/InicioFooter.vue'
</script>

<template>

    <div class="contenedor">
        <InicioH/>
        <InicioM/>
        <InicioF/>
    </div>

</template>

<style scoped>
 .contenedor{
    display: grid;
    grid-template-columns: 33vw 33vw;
    grid-template-rows: 13.89vh 16.66vh 59.72vh;
  }
</style>
