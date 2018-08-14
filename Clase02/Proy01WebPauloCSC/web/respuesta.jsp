<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String titulo; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> <%= titulo = (request.getParameter("suma")==null)?request.getParameter("suma"):request.getParameter("resta") %> </title>
    </head>
    <body>
        <h1></h1>
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
                    <td> <%= request.getAttribute("n1") %> </td>
                </tr>
                <tr>
                    <td>Número 2:</td>
                    <td> <%= request.getAttribute("n2") %> </td>
                </tr>
                <tr>
                    <td>Resta:</td>
                    <td> <%= request.getAttribute("resta") %> </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
