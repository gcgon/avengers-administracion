<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="fecha_factura" >Fecha de factura</label>
                    <input type="date" id="fecha_factura" name="fecha_factura" required>
                </fieldset>

                <fieldset>
                    <label for="numero_cuotas">Cuotas</label>
                    <input type="number" id="numero_coutas" name="numero_cuotas" required>
                </fieldset>

                <fieldset>
                    <label for="valor_cuotas">Valor por cuota</label>
                    <input type="number" id="valor_cuotas" name="valor_cuotas" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="conjunto" >Conjunto</label>
                    <input type="text" id="conjunto" name="conjunto" required>
                </fieldset>

                <fieldset>
                    <label for="bloque">Bloque</label>
                    <input type="number" id="bloque" name="bloque" required>
                </fieldset>

                <fieldset>
                    <label for="apartamento">Apartamento</label>
                    <input type="number" id="apartamento" name="apartamento" required>
                </fieldset>

            </section>

            <section class="section-table">
                <table>
                    <tr>
                        <th>No.</th>
                        <th>Detalle</th>
                        <th>Agregar</th>
                    </tr>

                    <tr>
                        <td>1</td>
                        <td>Cuota mensual administración</td>
                        <td><input type="checkbox"></td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>Moroso de cuotas</td>
                        <td><input type="checkbox"></td>
                    </tr>
                </table>
                
                <button @click="Prueba">
                    Agregar Factura
                </button>

            </section>
        </form>

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
}

form {
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 45% 50%;
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

.section-table {
    grid-row: 2/3;
    grid-column: 1/3;
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
    width: 50%;
    border: none;
    background-color: var(--background-second);
    border-radius: var(--border-buttons);
}

th:nth-child(1) {
    width: 10%;
}

th:nth-child(2) {
    width: 60%;
}

th:nth-child(3) {
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

button {
    grid-row: 3/4;
    grid-column: 1/3;
    font-size: var(--md);
    border: 2px solid;
    border-radius: var(--border-buttons);
    cursor: pointer;
    width: 300px;
    height: 60px;
    justify-self: center;
    font-weight: bold;
}

button:hover {
    background-color: var(--background-second);
}

</style>