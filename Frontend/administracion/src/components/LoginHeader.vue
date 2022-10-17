<template>

    <header>
        <h1>Administración.com</h1>

        <router-link to="/" tag="button" class="button-login">
            Volver al inicio
        </router-link>
    </header>

</template>

<script>
export default ({
    props:{
        numero: Number
    },
    data(){
        return{
            encabezados:['Pagos', 'Facturación', 'Informes']
        }
    }

})

</script>


<style scoped>

header {
    grid-row: 1/2;
    grid-column: 1/4;
    display: grid;
    grid-template-columns: 31.16vw 50vw;
    grid-template-rows: 20% 60%;
}

h1 {
    grid-column: 1/2;
    grid-row: 2/3;
    height: 100%;
    width: 100%;
    font-size: var(--bg);
    text-align: center;
}

.button-login {
    grid-column: 3/4;
    grid-row: 2/3;
    font-size: var(--md);
    justify-self: start;
    width: 93%;
    cursor: pointer;
}

.button-login:hover {
    border-radius: var(--border-buttons);
}

</style>