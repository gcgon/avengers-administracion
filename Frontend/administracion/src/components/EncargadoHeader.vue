<template>

    <header>
        <h1>Administración.com</h1>

        <nav>
            <ul>
                <RouterLink v-for="(enlace, index) in enlaces" :key="enlace" :to="enlace" class="nav-links">{{encabezados[index]}}</RouterLink>
            </ul>
        </nav>

        <section>
            <figure>
                <figcaption>Encargado</figcaption>
                <img src="./imgs/usuario.png" alt="Administrador">
            </figure>
        </section>
        
    </header>

</template>

<script>
export default ({
    data(){
        return{
            encabezados:['Inicio', 'Facturas', 'Pagos', 'Información'],
            enlaces: ['inicioEncargado', 'facturasEncargado', 'pagosEncargado', 'informacionEncargado']
        }
    }
})

</script>


<style scoped>

header {
    grid-row: 1/2;
    grid-column: 1/3;
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
    display: flex;
    flex-direction: column;
    justify-content: center;
    text-align: center;
}

nav {
    grid-column: 2/3;
    grid-row: 2/3;
}

ul {
    list-style-type: none;
    display: flex;
    justify-content: space-evenly;
    height: 100%;
}

.nav-links {
    font-size: var(--md);
    width: 30%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    text-align: center;
}

.nav-links:hover {
    background-color: var(--background-second);
    border-radius: var(--border-buttons);
}

section {
    grid-column: 3/4;
    grid-row: 2/3;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: var(--md);
    font-weight: bold;
}

figure {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    margin-left: 20px;
}

img {
    padding-left: 20px;
    height: 60px;
}

</style>