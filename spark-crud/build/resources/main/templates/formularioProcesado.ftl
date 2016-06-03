<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
    <h1>Procesando Formulario</h1>
    <table>
        <thead>

        </thead>
        <tbody>
        <title>blin blin</title>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Telefono</th>
        </tr>
        <tr>

            <td>${nombre}</td>
            <td>${apellido}</td>
            <td>${telefono}</td>
        </tr>

        <#list params as p>
           <tr><td>${p}</td>
        </#list>

        </tbody>
    </table>
</body>
</html>