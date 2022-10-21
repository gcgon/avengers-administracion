<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="nombre">Nombre(s) </label>
                    <input type="text" v-model="nombreUsuario" id="nombre" name="nombre" required>
                </fieldset>

                <fieldset>
                    <label for="apellido">Apellido(s)</label>
                    <input type="text" id="apellido" name="apellido" required>
                </fieldset>

                <fieldset>
                    <label for="contrasenia">Contraseña</label>
                    <input type="password" id="contrasenia" name="contrasenia" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="tipo_documento">Tipo de documento</label>
                    <input type="text" id="tipo_documento" name="tipo_documento" required>
                </fieldset>

                <fieldset>
                    <label for="numero_documento">Número de Documento</label>
                    <input type="number" id="numero_documento" name="numero_documento" required>
                </fieldset>

                <fieldset>
                    <label for="numero_contacto">Número de contacto</label>
                    <input type="number" id="numero_contacto" name="numero_contacto" required>
                </fieldset>

            </section>

            <section class="section-bottom">
                <fieldset>
                    <label for="rol">Rol</label>
                    <input type="text" id="rol" name="rol" required>
                </fieldset>

                <button>
                    Crear Usuario
                </button>
            </section>

        </form>

    </main>

</template>

<script>

export default {
    data() {
        return {
            conjuntos: [] /**este es el array para la lista de nombre en la box de nombres creados que se van apilando */,
            nombreConjunto: "" /*para el input denombre*/,
            nitConjunto: "" /*para el input de apellido */,
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
                    const error = response.statusText;
                    // error.json = response.json();
                    this.mensajeError = error.message;
                    throw error;
                } else {
                    const data = await response.json();
                    console.log(data);
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
}

form {
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 50% 50%;
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

.section-bottom {
    grid-row: 2/3;
    grid-column: 1/3;
    width: 50%;
    justify-self: center;
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