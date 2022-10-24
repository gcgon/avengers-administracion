<template>

    <main>

        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="conjunto">Conjunto</label>
                    <input list="conjuntos" v-model="conjunto" id="conjunto" name="conjunto" required>
                    <datalist name="conjuntos">
                        <option value="csasad"></option>
                    </datalist>
                </fieldset>

                <fieldset>
                    <label for="fecha_factura">Fecha de factura</label>
                    <input type="date" v-model="fechaFactura" id="fecha_factura" name="fecha_factura" required>
                </fieldset>

                <fieldset>
                    <label for="fecha_limite">Fecha límite de pago</label>
                    <input type="date" v-model="fechaLimitePago" id="fecha_limite" name="fecha_limite" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="apartamento">Apartamento</label>
                    <input list="apartamentos" v-model="apartamento" id="apartamento" name="apartamento" required>
                    <datalist name="apartamentos">
                        <option value="casadfasf"></option>
                        <option value="casadfasf"></option>
                    </datalist>
                </fieldset>

                <fieldset>
                    <label for="valor_cuotas">Cuota actual ($)</label>
                    <input type="number" v-model="valorCuota" id="valor_cuotas" name="valor_cuotas" required placeholder="$120000">
                </fieldset>

                <fieldset>
                    <label for="valor_total">Total factura</label>
                    <input type="number" v-model="valorFactura" id="valor_total" name="valor_total" disabled>
                </fieldset>

            </section>

            <section class="section-table">
                <table>
                    <tr>
                        <th>No.</th>
                        <th>Factura pendiente</th>
                        <th>Valor</th>
                    </tr>

                    <tr v-for="(conjunto,index) in conjuntos" :key="index">
                        <td>{{conjunto.nitConjunto}}</td>
                        <td>{{conjunto.nombreConjunto}}</td>
                        <td>{{conjunto.direccionConjunto}}</td>
                        <td>{{conjunto.telefonoConjunto}}</td>
                    </tr>

                </table>

                <button>
                    Crear Factura
                </button>

            </section>
        </form>

    </main>

</template>

<script>
export default ({
    data() {
        return {
            encabezados: ['Pagos', 'Facturación', 'Informes'],
            detalles: {
                FechaFactura: Date,
                Ncuotas: Number,
                Vcuotas: Number,
                Conjunto: Text,
                Bloque: Number,
                Apartamento: Number,
            },
            facturas: {},
            nroFactura: "",
            apartamento: {},
            fechaFactura: "",
            fechaLimitePago: "",
            cuotaActual: "",
            valorFactura: "",
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            parametros: {},
            url: "http://132.145.158.155:8080/Administracion/api/factura",
        }
    },
    methods: {
        crear() {
            if (this.entradaValida()) {
                const tablaDetalles = document.getElementById("tablaDetalles");
                for (let i = 1, row; row = tablaDetalles.rows[i]; i++) {
                    this.valorFactura = this.valorFactura + row.cell[2];
                }; console.log(this.valorFactura);
                this.valorFactura = this.valorFactura + this.cuotaActual;
                this.parametros.apartamento = this.apartamento.idApartamento;
                this.parametros.fechaFactura = this.fechaFactura;
                this.parametros.fechaLimitePago = this.fechaLimitePago;
                this.parametros.valorFactura = this.valorFactura;

                this.hacerPeticion();
                this.$forceUpdate();

            } else {
                this.mensajeError = "Por favor ingrese todos los datos.";
                alert(this.mensajeError);
            };
        },

        consultar() {
            const options = {
                method: this.metodo,
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + this.token,
                }
            };
            fetch(this.url, options).then(async (response) => {
                if (!response.ok) {
                    const { error } = response;
                    throw error;
                } else {
                    const data = await response.json();
                    for (let conjunto in data) {
                        const data1 = data[conjunto]
                        this.conjuntos.push(data1);
                    };
                };
            });
        },

        crearDetalleFactura(idApartamento, nroFactura, valorFactura) {
            this.parametros.idApartamento = idApartamento;
            this.parametros.nroFactura = nroFactura;
            this.parametros.valorFactura = valorFactura;
            this.url = "http://132.145.158.155:8080/Administracion/api/detalleFactura";
            this.hacerPeticion();
        },

        entradaValida() {
            return toString(this.apartamento).trim() && this.fechaFactura.trim() && this.fechaLimitePago.trim() && this.cuotaActual.trim();
        },

        async hacerPeticion() {
            const options = {
                method: "POST",
                body: JSON.stringify(this.parametros),
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + this.token,
                },
            };

            fetch(this.url, options).then(async (response) => {
                if (!response.ok) {
                    const { error } = response;
                    this.mensajeError = error.message;
                    throw error;
                } else {
                    alert("Factura creada exitosamente!")
                    const data = await response.json();
                    this.nroFactura = data.nroFactura;
                    this.parametros = {};
                    crearDetalleFactura(this.idApartamento, this.nroFactura, this.valorFactura);
                };
            });
        },
    },
});

</script>

<style scoped>
main {
    height: 100%;
    grid-row: 2/3;
    grid-column: 1/4;
}


form {
    grid-row: 2/3;
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

input {
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
    width: 60%;
}

th:nth-child(3) {
    width: 20%;
}

th,
td {
    background-color: transparent;
}

td,
th {
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