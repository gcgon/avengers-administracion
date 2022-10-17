<template>

    <main>
        <section>
                <table>
                    <tr>
                        <th>No.</th>
                        <th>Apartamento</th>
                        <th>Fecha</th>
                        <th>Valor Total</th>
                        <th>Detalle</th>
                        <th>Pagar</th>
                    </tr>

                    <tr>
                        <td>1</td>
                        <td>512</td>
                        <td>22 Febrero</td>
                        <td>$214.000</td>
                        <td>Cuota mes</td>
                        <td>
                            <img src="./imgs/pagar.png" alt="agregar">
                        </td>
                    </tr>

                </table>
            
                <button >
                    Actualizar
                </button>
            </section>
    </main>
    
</template>


<style scoped>

main {
    height: 100%;
    grid-row: 2/3;
    grid-column: 1/4;
    display: grid;
}

section {
    font-size: var(--md);
    grid-row: 1/2;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
    height: 100%;
    width: 100%;
}

table {
    width: 80%;
    border: none;
    background-color: var(--background-second);
    border-radius: var(--border-buttons);
}

th:nth-child(1) {
    width: 10%;
}

th:nth-child(2) {
    width: 20%;
}

th:nth-child(3) {
    width: 20%;
}

th:nth-child(4) {
    width: 20%;
}

th:nth-child(5) {
    width: 20%;
}

th:nth-child(6) {
    width: 10%;
}

th, td {
    background-color: transparent;
}

td, th {
    text-align: center;
    padding: 8px;
}

img {
    height: 30px;
    background-color: transparent;
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