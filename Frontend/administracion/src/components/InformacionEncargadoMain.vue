<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="nit" >Nit</label>
                    <input type="number" id="nit" name="nit" required>
                </fieldset>

                <fieldset>
                    <label for="numero_cuotas">Nombre</label>
                    <input type="number" id="numero_coutas" name="numero_cuotas" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="direccion" >Dirección</label>
                    <input type="text" id="direccion" name="direccion" required>
                </fieldset>

                <fieldset>
                    <label for="telefono">Teléfono del conjunto</label>
                    <input type="number" id="telefono" name="telefono" required>
                </fieldset>

            </section>

            <button>
                Agregar
            </button>
            
        </form>
        <section class="section-inferior">

                <table>
                    <tr>
                        <th>Nit</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono del conjunto</th>
                        <th></th>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>

                    <tr>
                        <td>1111</td>
                        <td>Kumarú</td>
                        <td>Calle 150C #117-71</td>
                        <td>5376574</td>
                        <td>
                            <img src="./imgs/agregar.png" alt="agregar">
                            <img src="./imgs/lapiz.png" alt="agregar">
                            <img src="./imgs/basura.png" alt="agregar">
                        </td>
                    </tr>
                </table>
                
                <button @click="Prueba">
                    Agregar Factura
                </button>
            </section>
    </main>
    
</template>

<script>
export default ({
    data(){
        return{
            encabezados:['Pagos', 'Facturación', 'Informes'],
            detalles:{
                FechaFactura: Date,
                Ncuotas: Number,
                Vcuotas: Number,
                Conjunto: Text,
                Bloque: Number,
                Apartamento: Number,
            }
        }
    }, 
    methods: {
        Prueba(){
            this.FechaFactura = document.getElementById("numero_cuotas");
            console.log(document.getElementById("numero_cuotas"));
        }
    }
})

</script>


<style scoped>

main {
    height: 100%;
    grid-row: 2/3;
    grid-column: 1/4;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 40%;
}

form {
    grid-row: 1/2;
    grid-column: 1/3;
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 50%;
}

section {
    font-size: var(--md);
    grid-row: 1/2;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
    height: 100%;
}

.section-izquierda {
    grid-column: 1/2;
}

.section-derecha {
    grid-column: 2/3;
}

.section-inferior {
    width: 100%;
    grid-row: 2/3;
    grid-column: 1/3;
    display: flex;
}

fieldset {
    width: 100%;
    border: none;
    display: flex;
    flex-direction: row;
}

label {
    width: 40%;
    text-align: center;
    font-weight: bold;
}

input{
    width: 50%;
    border: none;
    background-color: var(--background-second);
    height: 100%;
    font-size: var(--md);
    border-radius: var(--border-others);
    text-align: center;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
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
    width: 25%;
}

th:nth-child(4) {
    width: 25%;
}

th:nth-child(5) {
    width: 20%;
}

th, td {
    background-color: transparent;
}

td, th {
    text-align: center;
    padding: 8px;
}

input[type=checkbox] {
    height: 20px;
}

img {
    height: 30px;
    background-color: transparent;
    margin-left: 30px;
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