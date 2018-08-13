package pe.egcc.app.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.service.MateService;

@WebServlet(name = "AppController", urlPatterns = {"/AppSumar","/AppRestar"})
public class AppController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1").toString());
    int n2 = Integer.parseInt(request.getParameter("num2").toString());
    // Proceso
    MateService mateService = new MateService();
    int suma = mateService.sumar(n1, n2);
    // Forward
    request.setAttribute("n1", n1);
    request.setAttribute("n2", n2);
    request.setAttribute("suma", suma);
    RequestDispatcher dispatcher;
    dispatcher = request.getRequestDispatcher("respuesta.jsp");
    dispatcher.forward(request, response);
  }

  
  
}
