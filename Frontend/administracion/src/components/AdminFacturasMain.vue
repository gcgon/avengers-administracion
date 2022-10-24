<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="fecha_factura">Fecha de factura</label>
                    <input type="date" v-model="fechaFactura" id="fecha_factura" name="fecha_factura" required>
                </fieldset>

                <fieldset>
                    <label for="numero_cuotas">Cuotas</label>
                    <input type="number" v-model="cuotas" id="numero_coutas" name="numero_cuotas" required>
                </fieldset>

                <fieldset>
                    <label for="valor_cuotas">Valor por cuota</label>
                    <input type="number" v-model="valorCuota" id="valor_cuotas" name="valor_cuotas" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="conjunto">Conjunto</label>
                    <input type="text" v-model="conjunto" id="conjunto" name="conjunto" required>
                </fieldset>

                <fieldset>
                    <label for="bloque">Bloque</label>
                    <input type="number" id="bloque" name="bloque" required>
                </fieldset>

                <fieldset>
                    <label for="apartamento">Apartamento</label>
                    <input type="number" v-model="apartamento" id="apartamento" name="apartamento" required>
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
            valordetalle: "",//tentativamente pues puedo almacenar el valor de detalle en valor y al final sumarle el valor de la cuota actual 
            valorFactura: "",//suma los valores en la tabla detalles y el de la cuota actual
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            //actualizando: false,
            parametros: {},
            url: "http://localhost:8080/api/factura",
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

                // if (!this.actualizando) {

                this.hacerPeticion();
                this.$forceUpdate();
                /* } else {
                     this.metodo = "PUT";
                     this.url = this.url + `/${this.nitConjunto}`
                     this.hacerPeticion();
                 };*/

            } else {
                this.mensajeError = "Por favor ingrese todos los datos.";
                alert(this.mensajeError);
            };
        },

        crearDetalleFactura(idApartamento, nroFactura, valorFactura) {
            this.parametros.idApartamento = idApartamento;
            this.parametros.nroFactura = nroFactura;
            this.parametros.valorFactura = valorFactura;
            this.url = "http://localhost:8080/api/detalleFactura";
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
                    //error.json = response.json();
                    this.mensajeError = error.message;
                    throw error;
                } else {
                    alert("Factura creada exitosamente!")

                    const data = await response.json();
                    this.nroFactura = data.nroFactura;
                    this.parametros = {};
                    crearDetalleFactura(this.idApartamento, this.nroFactura, this.valorFactura);
                    /* if (data.length > 0) {
                          for (let conjunto in data) {
                              const data1 = data[conjunto]
                              this.conjuntos.push(data1);
                          };
                      }
                      else {
                          window.location.reload();
                      };*/
                };
            });
        },
    },
    /*mounted() {
         this.hacerPeticion();
     },*/
});

</script>





<script>

/*export default {
    data() {
        return {
            encabezados: ["Pagos", "Facturación", "Informes"],
            conjuntos: [],
            nombreConjunto: "",
            nitConjunto: "",
            direccionConjunto: "",
            telefonoConjunto: "",
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            actualizando: false,
            url: "http://localhost:8080/api/Conjunto",
            metodo: "GET",
            parametros: {},

        };
    },

    methods: {
        crear() {
            if (this.entradaValida()) {
                this.parametros.nombreConjunto = this.nombreConjunto;
                this.parametros.direccionConjunto = this.direccionConjunto;
                this.parametros.telefonoConjunto = this.telefonoConjunto;

                if (!this.actualizando) {
                    this.parametros.nitConjunto = this.nitConjunto;
                    this.metodo = "POST";
                    this.hacerPeticion();
                    this.$forceUpdate();
                } else {
                    this.metodo = "PUT";
                    this.url = this.url + `/${this.nitConjunto}`
                    this.hacerPeticion();
                };

            } else {
                this.mensajeError = "Por favor ingrese todos los datos.";
                alert(this.mensajeError);
            }
        },

        actualizar(conjunto) {
            console.log(conjunto);
            this.nitConjunto = conjunto.nitConjunto;
            document.getElementById('nit').disabled = true;
            this.nombreConjunto = conjunto.nombreConjunto;
            this.direccionConjunto = conjunto.direccionConjunto;
            this.telefonoConjunto = conjunto.telefonoConjunto;
            document.getElementById('crear').innerText = "Actualizar";

            this.actualizando = true;
        },

        eliminar(nitConjunto) {
            this.metodo = "DELETE";
            this.url = this.url + `/${nitConjunto}`
            this.hacerPeticion();
            window.location.reload();
        },


        entradaValida() {
            return toString(this.nitConjunto).trim() && this.nombreConjunto.trim() && this.direccionConjunto.trim();
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

        async hacerPeticion() {
            let options = {};

            if (this.metodo != "GET" && this.metodo != "DELETE") {
                options = {
                    method: this.metodo,
                    body: JSON.stringify(this.parametros),
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": "Bearer " + this.token,
                    },
                };
            } else {
                options = {
                    method: this.metodo,
                    headers: {
                        "Content-Type": "application/json",
                        "Authorization": "Bearer " + this.token,
                    },
                };
            };

            fetch(this.url, options).then(async (response) => {
                if (!response.ok) {
                    const { error } = response;
                    console.log(error);
                    throw error;
                } else {
                    window.location.reload();
                };
            });
        },
    },
    mounted() {
        this.consultar();
    },
};*/
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