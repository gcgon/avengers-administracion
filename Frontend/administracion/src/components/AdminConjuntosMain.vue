<template>
    <main>
        <form action="">
            <section class="section-izquierda">
                <fieldset>
                    <label for="nit">Nit</label>
                    <input type="number" id="nit" v-model.number="nitConjunto" name="nitConjunto" required />
                </fieldset>

                <fieldset>
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" v-model="nombreConjunto" name="nombreConjunto" required />
                </fieldset>
            </section>

            <section class="section-derecha">
                <fieldset>
                    <label for="direccion">Dirección</label>
                    <input type="text" id="direccion" v-model="direccionConjunto" name="direccionConjunto" required />
                </fieldset>

                <fieldset>
                    <label for="telefono">Teléfono</label>
                    <input type="text" id="telefono" v-model="telefonoConjunto" name="telefonoConjunto" required />
                </fieldset>
            </section>
            <button id="crear" @click="crear" type="button" class="btn btn-outline-primary">Crear</button>
        </form>
        <section class="section-inferior">

            <table id="tabla">
                <tr>
                    <th>Nit</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono del conjunto</th>
                    <th></th>
                </tr>

                <tr v-for="(conjunto,index) in conjuntos" :key="index">
                    <td>{{conjunto.nitConjunto}}</td>
                    <td>{{conjunto.nombreConjunto}}</td>
                    <td>{{conjunto.direccionConjunto}}</td>
                    <td>{{conjunto.telefonoConjunto}}</td>
                    <td>
                        <img src="./imgs/agregar.png" alt="agregar"
                            @click="this.$router.push('crearUsuariosAdministrador')" />
                        <img src="./imgs/lapiz.png" alt="agregar" @click="actualizar(conjunto)" />
                        <img src="./imgs/basura.png" alt="agregar" @click="eliminar(conjunto.nitConjunto)" />
                    </td>
                </tr>
            </table>

            <button>Ver apartamentos</button>
        </section>
    </main>
</template>

<script>

export default {
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

                if (!this.actualizando) {
                    this.parametros.nitConjunto = this.nitConjunto;
                    this.parametros.nombreConjunto = this.nombreConjunto;
                    this.parametros.direccionConjunto = this.direccionConjunto;
                    this.parametros.telefonoConjunto = this.telefonoConjunto;
                    this.metodo = "POST";
                    this.hacerPeticion();
                    console.log(this.conjuntos);
                    this.nombreConjunto = this.direccionConjunto = "";
                    this.telefonoConjunto = this.nitConjunto = "";
                    this.mensajeError = "";
                    this.actualizando = false;
                    this.$forceUpdate();
                } else {
                    this.parametros.nombreConjunto = this.nombreConjunto;
                    this.parametros.direccionConjunto = this.direccionConjunto;
                    this.parametros.telefonoConjunto = this.telefonoConjunto;
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
            }

            fetch(this.url, options).then(async (response) => {
                if (!response.ok) {
                    const { error } = response;
                    //error.json = response.json();
                    this.mensajeError = error.message;
                    throw error;
                } else {
                    const data = await response.json();

                    if (data.length > 0) {
                        for (let conjunto in data) {
                            const data1 = data[conjunto]
                            this.conjuntos.push(data1);
                        };
                    }
                    else {
                        window.location.reload();
                    };
                };
            });
        },
    },
    mounted() {
        this.hacerPeticion();
    },
};
</script>

<style scoped>
main {
    height: 100%;
    grid-row: 2/3;
    grid-column: 1/4;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 30%;
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
    width: 10%;
}

th:nth-child(3) {
    width: 30%;
}

th:nth-child(4) {
    width: 30%;
}

th:nth-child(5) {
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

img {
    height: 30px;
    background-color: transparent;
    margin-left: 30px;
    cursor: pointer;
}

input[type="checkbox"] {
    height: 20px;
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
