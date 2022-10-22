<template>

    <main>
        <h2>Generar reporte de</h2>

        <section class="card-left">
            <h3>{{encabezados[0]}}</h3>

            <picture></picture>

            <button>
                Generar reporte
            </button>
        </section>

        <section class="card-center">
            <h3>{{encabezados[1]}}</h3>

            <picture></picture>

            <button>
                Generar reporte
            </button>
        </section>

        <section class="card-right">
            <h3>{{encabezados[2]}}</h3>

            <picture></picture>

            <button>
                Generar reporte
            </button>
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
            encabezados:['Deudores', 'Conjuntos', 'Pagos']
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
    grid-template-rows: 21.82%;
}

section {
    grid-row: 2/3;
    margin: 20px 77px;
    background-color: var(--background-second);
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

h3 {
    display: inline;
    background-color: transparent;
    font-size: var(--md-bg);
    font-weight: 900;
    margin: 20px 0;
}

picture {
    height: 150px;
    width: 150px;
}

.card-left picture {
    background: url("../components/imgs/deudores.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

.card-center picture {
    background: url("../components/imgs/conjuntos.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

.card-right picture {
    background: url("../components/imgs/pagos2.png");
    background-repeat: no-repeat;
    background-position: center center;
    background-size: cover;
}

button {
    grid-row: 2/3;
    grid-column: 1/3;
    font-size: var(--md);
    border: 2px solid;
    border-radius: var(--border-buttons);
    cursor: pointer;
    width: 300px;
    height: 60px;
    justify-self: center;
    font-weight: bold;
    margin: 20px 0;
}

button:hover {
    background-color: var(--background-second);
}

</style>