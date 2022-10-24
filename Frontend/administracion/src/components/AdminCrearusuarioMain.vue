<template>

    <main>

        <section class="section-formulario">

            <form action="">
                <section class="section-formulario-top">
                    <fieldset>
                        <label for="rol">Rol</label>
                        <input list="rolOptions" v-model="rol" id="rol" name="rol" required>
                        <datalist id="rolOptions">
                            <option value="administrador"></option>
                            <option value="usuario"></option>
                        </datalist>
                    </fieldset>
                </section>

                <section class="section-formulario-izquierda">

                    <fieldset>
                        <label for="nombre">Nombre(s) </label>
                        <input type="text" v-model="nombreUsuario" id="nombre" name="nombre" required>
                    </fieldset>

                    <fieldset>
                        <label for="tipo_documento">Tipo de documento</label>
                        <input type="text" v-model="tipoDocumento" id="tipo_documento" name="tipo_documento" required>
                    </fieldset>

                    <fieldset>
                        <label for="numero_contacto">Número de contacto</label>
                        <input type="number" v-model.number="telefono" id="numero_contacto" name="numero_contacto"
                            required>
                    </fieldset>

                </section>

                <section class="section-formulario-derecha">

                    <fieldset>
                        <label for="apellido">Apellido(s)</label>
                        <input type="text" v-model="apellido" id="apellido" name="apellido" required>
                    </fieldset>

                    <fieldset>
                        <label for="numero_documento">Número de Documento</label>
                        <input type="number" v-model.number="nro_documento_usuario" id="numero_documento"
                            name="numero_documento" required>
                    </fieldset>

                    <fieldset>
                        <label for="contrasenia">Contraseña</label>
                        <input type="password" v-model="clave" id="contrasenia" name="contrasenia" required>
                    </fieldset>

                </section>

                <section class="section-formulario-bottom">

                    <button id="crear" @click="crear">
                        Crear Usuario
                    </button>

                </section>

            </form>
        </section>

        <section class="section-tabla">
            <table>
                <tr>
                    <th>Tipo</th>
                    <th>No. de documento</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Teléfono</th>
                    <th>Rol</th>
                    <th>Clave</th>
                    <th></th>
                </tr>

                <tr v-for="(usuario,index) in usuarios" :key="index">
                    <td>{{usuario.tipoDocumento}}</td>
                    <td>{{usuario.nro_documento_usuario}}</td>
                    <td>{{usuario.nombreUsuario}}</td>
                    <td>{{usuario.apellido}}</td>
                    <td>{{usuario.telefono}}</td>
                    <td>{{usuario.rol}}</td>
                    <td>{{usuario.clave}}</td>
                    <td>
                        <img src="./imgs/lapiz.png" alt="agregar" @click="actualizar(usuario)" />
                        <img src="./imgs/basura.png" alt="agregar" @click="eliminar(usuario.nro_documento_usuario)" />
                    </td>
                </tr>
            </table>
        </section>

    </main>

</template>

<script>

export default {
    data() {
        return {
            encabezados: ["Pagos", "Facturación", "Informes"],
            usuarios: [],
            nombreUsuario: "",
            apellido: "",
            nro_documento_usuario: "",
            tipoDocumento: "",
            telefono: "",
            rol: "",
            clave: "",
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            actualizando: false,
            url: "http://132.145.158.155:8080/Administracion/api/usuario",
            metodo: "GET",
            parametros: {},

        };
    },

    methods: {
        crear() {
            if (this.entradaValida()) {
                this.parametros.nombreUsuario = this.nombreUsuario;
                this.parametros.apellido = this.apellido;
                this.parametros.tipoDocumento = this.tipoDocumento;
                this.parametros.telefono = this.telefono;
                this.parametros.rol = this.rol;
                this.parametros.clave = this.clave;

                if (!this.actualizando) {
                    this.parametros.nro_documento_usuario = this.nro_documento_usuario;
                    this.metodo = "POST";
                    this.hacerPeticion();
                    this.$forceUpdate();
                } else {
                    this.metodo = "PUT";
                    this.url = this.url + `/${this.nro_documento_usuario}`
                    this.hacerPeticion();
                    this.$forceUpdate();
                };

            } else {
                this.mensajeError = "Por favor ingrese todos los datos.";
                alert(this.mensajeError);
            }
        },

        actualizar(usuario) {
            console.log(usuario);
            this.nro_documento_usuario = usuario.nro_documento_usuario;
            document.getElementById('numero_documento').disabled = true;
            this.nombreUsuario = usuario.nombreUsuario;
            this.apellido = usuario.apellido;
            this.tipoDocumento = usuario.tipoDocumento;
            this.telefono = usuario.telefono;
            this.rol = usuario.rol;
            this.clave = usuario.clave;
            document.getElementById('crear').innerText = "Actualizar";

            this.actualizando = true;
        },

        eliminar(nro_documento_usuario) {
            this.metodo = "DELETE";
            this.url = this.url + `/${nro_documento_usuario}`
            this.hacerPeticion();
            window.location.reload();
        },


        entradaValida() {
            return toString(this.nro_documento_usuario).trim() && this.nombreUsuario.trim() && this.tipoDocumento.trim() && this.rol.trim() && this.clave.trim();
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
                    for (let usuario in data) {
                        const data1 = data[usuario]
                        this.usuarios.push(data1);
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
};
</script>


<style scoped>
main {
    height: 100%;
    grid-row: 2/3;
    grid-column: 1/4;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 50%;
}

section {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-direction: column;
    font-size: var(--md);
}

.section-formulario {
    grid-row: 1/2;
    grid-column: 1/3;
}

.section-tabla {
    grid-row: 2/3;
    grid-column: 1/3;
}

form {
    height: 100%;
    width: 100%;
    display: grid;
    grid-template-columns: 50%;
    grid-template-rows: 15% 60%;
}

.section-formulario-top {
    grid-row: 1/2;
    grid-column: 1/3;
    width: 60%;
    justify-self: center;
}

.section-formulario-izquierda {
    grid-row: 2/3;
    grid-column: 1/2;
}

.section-formulario-derecha {
    grid-row: 2/3;
    grid-column: 2/3;
}

.section-formulario-bottom {
    grid-row: 3/4;
    grid-column: 1/3;
    width: 40%;
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


table {
    width: 90%;
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
    width: 15%;
}

th:nth-child(4) {
    width: 15%;
}

th:nth-child(5) {
    width: 10%;
}

th:nth-child(6) {
    width: 10%;
}

th:nth-child(7) {
    width: 10%;
}

th:nth-child(8) {
    width: 10%;
}

th,
td {
    background-color: transparent;
    text-align: center;
    padding: 8px;
}

td {
    font-size: var(--md-sm);
}

img {
    height: 30px;
    background-color: transparent;
    margin-right: 25px;
    cursor: pointer;
}
</style>