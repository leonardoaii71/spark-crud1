<!DOCTYPE html>
<html>
<head>
    <title>Crear Estudiante</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

    <link rel="stylesheet" href="/css/demo.css">
    <link rel="stylesheet" href="/css/sky-forms.css">

</head>
<body class="bg-cyan">
<div class="body body-s">

    <form action="/procesarFormulario/" method="post" class="sky-form">
        <header>Crear estudiante</header>


        <fieldset>
            <div class="row">
                <section class="col col-6">
                    <label class="input">
                        <input type="text" name="nombre" placeholder="Nombre">
                    </label>
                </section>
                <section class="col col-6">
                    <label class="input">
                        <input type="text" name="apellido" placeholder="Apellido">


                    </label>
                </section>
                <section class="col -6">
                    <label class="input">
                        <!--<i class="icon-append icon-user"></i> -->
                        <input type="text" name="telefono" placeholder="Telefono">
                        <b class="tooltip tooltip-bottom-right">Solo numeros</b>
                    </label>
                    <label class="input">
                        <!--<i class="icon-append icon-user"></i> -->
                        <input type="text" name="matricula" placeholder="Matricula">
                        <b class="tooltip tooltip-bottom-right">Solo numeros</b>
                    </label>
                </section>

            </div>

            <section>
                <label class="select">
                    <select name="gender">
                        <option value="0" selected disabled>Gender</option>
                        <option value="1">Male</option>
                        <option value="2">Female</option>
                        <option value="3">Other</option>
                    </select>
                    <i></i>
                </label>
            </section>

        </fieldset>
        <footer>
            <button type="submit" class="button">Crear</button>
        </footer>
    </form>

</div>
</body>
</html>