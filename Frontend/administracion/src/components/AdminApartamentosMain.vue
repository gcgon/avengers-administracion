<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="nit">Conjunto</label>
                    <input type="number" v-model="conjunto" id="nit" name="nit">
                </fieldset>

                <fieldset>
                    <img src="./imgs/agregar.png" alt="agregar" id="add2" @click="ToCrearUsuario">
                    <label for="usuario" id="add1">Usuario</label>
                    <input type="text" v-model="usuario" id="usuario" name="usuario">
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="bloque">Bloque</label>
                    <input type="number" v-model="bloque_apartamento" id="bloque" name="bloque" required
                        placeholder="b5">
                </fieldset>

                <fieldset>
                    <label for="apartaamento">Apartamento</label>
                    <input type="number" v-model.number="numero_apartamento" id="apartamento" name="apartamento"
                        required placeholder="###">
                </fieldset>

            </section>
            <button>
                Crear
            </button>

        </form>
        <section class="section-inferior">

            <table>
                <tr>
                    <th>Conjunto</th>
                    <th>Usuario</th>
                    <th>Bloque</th>
                    <th>Apartamento</th>
                    <th>Conjunto</th>
                    <th></th>
                </tr>

                <tr v-for="(apartamento,index) in apartamentos" :key="index">
                    <td>{{apartamento.conjunto}}</td>
                    <td>{{apartamento.usuario}}</td>
                    <td>{{apartamento.bloque_apartamento}}</td>
                    <td>{{apartamento.numero_apartamento}}</td>
                    <td>
                        <img src="./imgs/lapiz.png" alt="agregar" @click="actualizar(apartamento)" />
                        <img src="./imgs/basura.png" alt="agregar" @click="eliminar(apartamento.idApartamento)" />
                    </td>
                </tr>

            </table>

            <button @click="Volver">
                Volver
            </button>
        </section>
    </main>

</template>

<script>

export default {
    data() {
        return {
            encabezados: ["Pagos", "Facturación", "Informes"],
            apartamentos: [],
            idApartamento: "",
            bloque_apartamento: "",
            numero_apartamento: "",
            conjunto: "",
            usuario: "",
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            actualizando: false,
            url: "http://localhost:8080/apartamento",
            metodo: "GET",
            parametros: {},

        };
    },

    methods: {
        crear() {
            if (this.entradaValida()) {
                this.parametros.numero_apartamento = this.numero_apartamento;
                this.parametros.bloque_apartamento = this.bloque_apartamento;

                if (!this.actualizando) {
                    this.parametros.idApartamento = this.idApartamento;
                    this.metodo = "POST";
                    this.hacerPeticion();
                    //this.$forceUpdate();
                } else {
                    this.metodo = "PUT";
                    this.url = this.url + `/${this.idApartamento}`
                    //this.hacerPeticion();
                };

            } else {
                this.mensajeError = "Por favor ingrese todos los datos.";
                alert(this.mensajeError);
            }
        },

        actualizar(apartamento) {
            //console.log(conjunto);
            this.idApartamento = apartamento.idApartamento;
            document.getElementById('idApartamento').disabled = true;
            this.numeroApartamento = apartamento.numero_apartamento;
            this.bloqueApartamento = apartamento.bloque_apartamento;
            document.getElementById('crear').innerText = "Actualizar";

            this.actualizando = true;
        },

        eliminar(idApartamento) {
            this.metodo = "DELETE";
            this.url = this.url + `/${idApartamento}`
            this.hacerPeticion();
            window.location.reload();
        },


        entradaValida() {
            return toString(this.numero_apartamento).trim() && toString(this.bloque_apartamento).trim();
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
                    for (let apartamento in data) {
                        const data1 = data[apartamento]
                        this.apartamentos.push(data1);
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
                    const data = await response.json();
                    consonle.log(data);
                    //window.location.reload();
                };
            });
        },
    },
    mounted() {
        this.consultar();
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
    grid-template-rows: 35%;
}

form {
    grid-row: 1/2;
    grid-column: 1/3;
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 60%;
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
    padding-top: 16px;
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
    width: 15%;
}

th:nth-child(2) {
    width: 25%;
}

th:nth-child(3) {
    width: 10%;
}

th:nth-child(4) {
    width: 20%;
}

th:nth-child(5) {
    width: 10%;
}

th:nth-child(6) {
    width: 15%;
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
    margin-right: 25px;
}

input[type=checkbox] {
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
    align-self: center;
}

button:hover {
    background-color: var(--background-second);
}

#add1 {
    width: 10%;
    margin-right: 14.8%;
}

#add2 {
    margin-left: 8%;
    cursor: pointer;
}
</style>