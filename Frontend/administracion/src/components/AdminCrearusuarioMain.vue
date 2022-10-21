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
                    <input type="text" v-model="apellido" id="apellido" name="apellido" required>
                </fieldset>

                <fieldset>
                    <label for="contrasenia">Contraseña</label>
                    <input type="password" v-model="clave" id="contrasenia" name="contrasenia" required>
                </fieldset>

            </section>

            <section class="section-derecha">

                <fieldset>
                    <label for="tipo_documento">Tipo de documento</label>
                    <input type="text" v-model="tipoDocumento" id="tipo_documento" name="tipo_documento" required>
                </fieldset>

                <fieldset>
                    <label for="numero_documento">Número de Documento</label>
                    <input type="number" v-model.number="nro_documento_usuario" id="numero_documento"
                        name="numero_documento" required>
                </fieldset>

                <fieldset>
                    <label for="numero_contacto">Número de contacto</label>
                    <input type="number" v-model.number="telefono" id="numero_contacto" name="numero_contacto" required>
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

                <table id="tabla">
                    <tr>
                        <th>Tipo documento</th>
                        <th>Número de documento</th>
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
                            <img src="./imgs/basura.png" alt="agregar"
                                @click="eliminar(usuario.nro_documento_usuario)" />
                        </td>
                    </tr>
                </table>

            </section>

        </form>

    </main>

</template>

<script>

export default {
    data() {
        return {
            usuarios: [],
            nombreUsuario: "",
            apellido: "",
            tipoDocumento: "",
            nro_documento_usuario: "",
            telefono: "",
            rol: "",
            clave: "",
            token: localStorage.getItem("tokenLogin"),
            mensajeError: "",
            actualizando: false,
            url: "http://localhost:8080/api/usuario",
            metodo: "GET",
            parametros: {},

        };
    },

    methods: {
        crear() {
            if (this.entradaValida()) {

                if (!this.actualizando) {
                    this.parametros.nombreUsuario = this.nombreUsuario;
                    this.parametros.apellido = this.apellido;
                    this.parametros.nro_documento_usuario = this.nro_documento_usuario;
                    this.parametros.tipoDocumento = this.tipoDocumento;
                    this.parametros.telefono = this.telefono;
                    this.parametros.rol = this.rol;
                    this.parametros.clave = this.clave;
                    this.metodo = "POST";
                    this.hacerPeticion();
                    console.log(this.usuarios);
                    this.nombreUsuario = "";
                    this.apellido = "";
                    this.telefono = "";
                    this.nro_documento_usuario = "";
                    this.tipoDocumento = "";
                    this.rol = "";
                    this.clave = "";
                    this.mensajeError = "";
                    this.actualizando = false;
                    this.$forceUpdate();
                } else {
                    this.parametros.nombreUsuario = this.nombreUsuario;
                    this.parametros.apellido = this.apellido;
                    this.parametros.tipoDocumento = this.tipoDocumento;
                    this.parametros.telefono = this.telefono;
                    this.parametros.rol = this.rol;
                    this.parametros.clave = this.clave;
                    this.metodo = "PUT";
                    this.url = this.url + `/${this.nro_documento_usuario}`
                    this.hacerPeticion();
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
            this.telefono = usuario.telefono;
            this.tipoDocumento = usuario.tipoDocumento;
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
            return toString(this.nro_documento_usuario).trim() && this.tipoDocumento.trim() && this.nombreUsuario.trim() && this.apellido.trim() && toString(this.telefono).trim && this.rol.trim() && this.clave.trim();
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
                        for (let usuario in data) {
                            const data1 = data[usuario]
                            this.usuarios.push(data1);
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