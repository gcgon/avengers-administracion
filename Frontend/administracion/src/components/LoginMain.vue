<template>

    <Main>
        <h1>
            Bienvenido a Administración.com
        </h1>

        <form action="">
            <label for="documento_identidad">Número de documento</label>
            <input type="number" name="documento_identidad" required placeholder="1111111111">

            <label for="contrasena">Contraseña</label>
            <input type="password" name="contrasena" required placeholder="**********">

            <router-link to="#" tag="button" class="button-login">
                Iniciar Sesión
            </router-link>
        </form>
    </Main>

</template>

<script>
export default ({
    props:{
        numero: Number
    },
    data(){
        return{
            encabezados:['Pagos', 'Facturación', 'Informes']
        }
    }

})

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