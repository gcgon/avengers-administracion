<template>

    <header>
        <h1>Administración.com</h1>

        <router-link to="/login" tag="button" class="button-login">
            Iniciar sesión
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
            encabezados:['Facturación', 'Pagos', 'Informes']
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
    border: 2px solid;
    border-radius: var(--border-buttons);
    justify-self: start;
    width: 93%;
    cursor: pointer;
}


</style>