<template>

    <main>
        <h2>Bienvenido encargado</h2>

        <article>
            En este espacio podrás encontrar información sobre el historial de tus facturas, el historial de pagos e Información sobre tus bienes
        </article>

        <section class="card-left">
            <h3>{{encabezados[0]}}</h3>

            <picture></picture>
        </section>

        <section class="card-center">
            <h3>{{encabezados[1]}}</h3>

            <picture></picture>
        </section>

        <section class="card-right">
            <h3>{{encabezados[2]}}</h3>

            <picture></picture>

        </section>
    </main>
    
</template>

<script>
export default ({
    props:{
        numero: Number
    },
    data(){
        return{
            encabezados:['Pagos', 'Facturas', 'Información']
        }
    }
})

</script>


<style scoped>

main {
    grid-row: 2/4;
    grid-column: 1/4;
    display: grid;
    grid-template-columns: 33.3vw 33.3vw;
    grid-template-rows: 22% 22%;
}

section {
    grid-row: 3/4;
    margin: 20px 77px;
    border-radius: var(--border-others);
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
}

h2 {
    grid-column: 2/3;
    grid-row: 1/2;
    height: 100%;
    width: 100%;
    font-size: var(--md-bg);
    font-weight: bold;
    display: flex;
    align-items: center;
    justify-content: center;
}

article {
    justify-self: center;
    width: 80%;
    grid-column: 1/4;
    grid-row: 2/3;
    text-align: center;
    font-size: var(--md);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

h3 {
    display: inline;
    background-color: transparent;
    font-size: var(--md);
    font-weight: normal;
    margin: 20px 0;
}

picture {
    height: 150px;
    width: 150px;
}

.card-left picture {
    background: url("../components/imgs/pagos.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

.card-center picture {
    background: url("../components/imgs/facturacion.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

.card-right picture {
    background: url("../components/imgs/informes.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

.p-cards {
    width: 83.33%;
    height: 30.77%;
    text-align: center;
    font-size: var(--sm);
    display: flex;
    align-items: center;
    background-color: transparent;
    line-height: 40px;
}

</style>