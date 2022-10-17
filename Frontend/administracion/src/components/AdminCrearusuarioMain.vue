<template>

    <main>
        <form action="">
            <section class="section-izquierda">

                <fieldset>
                    <label for="nombre" >Nombre(s)</label>
                    <input type="text" id="nombre" name="nombre" required>
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
                    <label for="tipo_documento" >Tipo de documento</label>
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