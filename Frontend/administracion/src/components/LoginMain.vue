<template>
  <Main>
    <h1>Bienvenido a Administración.com</h1>

    <form action="" @submit.prevent="iniciarSesion">
      <label for="documento_identidad">Número de documento</label>
      <input type="number" v-model="documentoIdentidad" name="documento_identidad" required placeholder="1111111111" />

      <label for="contrasena">Contraseña</label>
      <input type="password" v-model="contrasenia" name="contrasena" required placeholder="**********"
        autocomplete="off" />
      <hr />
      <div v-show="mensajeError" class="alert alert-danger col-12" role="alert">
        <h4 class="alert-heading">Error</h4>
      </div>

      <router-link :to=redireccionamiento @click="iniciarSesion" tag="button" class="button-login">
        Iniciar Sesión
      </router-link>

      <div v-show="mensajeError" class="alert alert-danger col-12" role="alert">
        <h4 class="alert-heading">Error</h4>
        <p>clave y/o usuario errados</p>
      </div>
    </form>
  </Main>
</template>

<script>
export default {
  props: {
    numero: Number,
  },
  data() {
    return {
      encabezados: ["Pagos", "Facturación", "Informes"],
      documentoIdentidad: "",
      contrasenia: "",
      rol: "",
      redireccionamiento: "",
      token: "pendiente",
      mensajeError: "",
      persona: {},
      authUser: {},
    };
  },

  methods: {
    iniciarSesion() {
      if (this.entradaValida()) {
        this.authUser = {
          nro_documento_usuario: this.documentoIdentidad,
          clave: this.contrasenia,
        };
        this.mensajeError = "";
        this.obtenerData();
      } else {
        this.mensajeError = "Por favor ingrese todos los datos.";
        alert(this.mensajeError);
        this.$forceUpdate();
      }
    },

    entradaValida() {
      return toString(this.documentoIdentidad).trim() && this.contrasenia.trim();
    },

    async obtenerData() {
      const options = {
        method: "POST",
        body: JSON.stringify(this.authUser),
        headers: {
          "Content-Type": "application/json",
        },
      };

      fetch("http://132.145.158.155:8080/Administracion/api/authorization", options).then(async (response) => {
        if (!response.ok) {
          const { error } = response;
          this.mensajeError = error.message;
          throw error;
        } else {
          const data = await response.json();
          [this.token, this.persona] = data.access.split("(");
          localStorage.setItem("tokenLogin", this.token);
          localStorage.setItem("persona", this.persona);
          let temp = this.persona.split(" ");
          if (temp[6] == "rol=administrador,"){
            this.redireccionamiento = '/reportesAdministrador';
          }else {
            this.redireccionamiento = '/inicioEncargado';
          }
        }
      });
    },
  },
};
</script>

<style scoped>
main {
  grid-column: 2/3;
  grid-row: 2/4;
  display: grid;
  grid-template-rows: 28%;
}

h1 {
  grid-row: 1/2;
  display: flex;
  align-items: center;
  font-size: var(--md);
  justify-content: center;
  font-weight: normal;
}

form {
  grid-row: 2/3;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

label {
  font-size: var(--md);
  font-weight: 600;
}

input {
  border: none;
  background-color: var(--background-second);
  width: 80%;
  height: 40px;
  border-radius: var(--border-others);
  text-align: center;
  font-size: var(--md);
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

.button-login {
  font-size: var(--md);
  width: 300px;
  height: 60px;
  cursor: pointer;
  border: 2px solid;
  border-radius: var(--border-buttons);
  font-size: var(--md);
  font-weight: bold;
}
</style>
