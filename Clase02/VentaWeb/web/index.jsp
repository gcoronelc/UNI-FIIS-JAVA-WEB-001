<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VENTA</title>
  </head>
  <body>
    <h1>VENTA ON-LINE</h1>
    <!-- FORMULARIO -->
    <form method="post" action="VentaController">
      <fieldset>
        <legend>DATOS DE LA VENTA</legend>
        <div>
          <label>Precio: </label>
          <input type="text" name="precio" />
        </div>
        <div>
          <label>Cantidad </label>
          <input type="text" name="cantidad" />
        </div>
        <div>
          <input type="submit" value="Procesar Venta" />
        </div>   
      </fieldset>
    </form>
  </body>
</html>
