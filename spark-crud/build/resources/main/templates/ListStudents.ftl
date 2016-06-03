<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Estudiantes</title>


    <link rel="stylesheet" href="/css/normalize.css">
    <link rel="stylesheet" href="/css/style1.css">

</head>

<body>

<h1>Estudiantes </h1>

<table class="responstable">

    <tr>
        <th>Main driver</th>
        <th data-th="Driver details"><span>Matricula</span></th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>telefono</th>
    </tr>
<#list estudiantes as estudiante>
    <tr>
        <td><input  type="radio"/></td>
        <td>${estudiante.matricula} </td>
        <td>${estudiante.nombre}</td>
        <td>${estudiante.apellido}</td>
        <td>${estudiante.telefono}</td>
        <td>
            <a href="${ "/update/${estudiante.matricula}"}"><span>editar </span></a>
            <a href="${ "/delete/${estudiante.matricula}"}"><span> borrar</span></a>
        </td>
    </tr>
</#list>

</table>
<script src='http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js'></script>





</body>
</html>
