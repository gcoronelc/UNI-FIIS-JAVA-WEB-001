<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>VENTA</title>
  </head>
  <body>
    <h1>VENTA ON-LINE</h1>
    <!-- ERROR -->
    <c:if test="${error != null}">
      <div style="color:red;">${error}</div>
    </c:if>
    
    
    <c:if test="${dto != null}">
      <fieldset>
        <legend>RESULTADO</legend>
        <h2>INPUT</h2>
        <div>Precio: ${dto.precio}</div>
        <div>Cantidad: ${dto.cantidad}</div>
        <h2>OUTPUT</h2>
        <div>Importe: ${dto.importe}</div>
        <div>Impuesto: ${dto.impuesto}</div>
        <div>Total: ${dto.total}</div>
      </fieldset>      
    </c:if>

  </body>
</html>
