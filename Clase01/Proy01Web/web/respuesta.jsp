<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SUMA</title>
  </head>
  <body>
    <h1>SUMA</h1>
    <table>
      <thead>
        <tr>
          <th>DATO</th>
          <th>VALOR</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Número 1:</td>
          <td><%= request.getAttribute("n1") %></td>
        </tr>
        <tr>
          <td>Número 2:</td>
          <td><%= request.getAttribute("n2") %></td>
        </tr>
        <tr>
          <td>Suma:</td>
          <td><%= request.getAttribute("suma") %></td>
        </tr>
      </tbody>
    </table>

  </body>
</html>
