package pe.egcc.venta.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.venta.dto.VentaDto;
import pe.egcc.venta.service.VentaService;

@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      double precio = Double.parseDouble(request.getParameter("precio"));
      int cantidad = Integer.parseInt(request.getParameter("cantidad"));
      // Proceso
      VentaDto dto = new VentaDto(precio, cantidad);
      VentaService service = new VentaService();
      service.procesarVenta(dto);
      // Datos para la vista
      request.setAttribute("dto", dto);
    } catch (Exception e) {
      // El error se envia a la vista
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher dispatcher;
    dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }

  
}
