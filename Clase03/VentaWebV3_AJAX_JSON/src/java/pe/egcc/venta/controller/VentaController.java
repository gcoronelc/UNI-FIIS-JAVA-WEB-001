package pe.egcc.venta.controller;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.venta.dto.VentaDto;
import pe.egcc.venta.service.VentaService;
import pe.egcc.venta.util.RptaJSON;

@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RptaJSON rpta = new RptaJSON();
    Gson gson = new Gson();
    try {
      // Datos
      double precio = Double.parseDouble(request.getParameter("precio"));
      int cantidad = Integer.parseInt(request.getParameter("cantidad"));
      // Proceso
      VentaDto dto = new VentaDto(precio, cantidad);
      VentaService service = new VentaService();
      service.procesarVenta(dto);
      // Datos para la vista
      String dtoJSON = gson.toJson(dto);
      rpta.setCodigo(1);
      rpta.setMensaje(dtoJSON);
    } catch (Exception e) {
      // El error se envia a la vista
      rpta.setCodigo(-1);
      rpta.setMensaje(e.getMessage());
    }
    // Enviar Respuesta al Browser
    //response.setContentType("text/plain;charset=UTF-8");
    response.setContentType("application/json;charset=UTF-8");
    ServletOutputStream sout = response.getOutputStream();
    sout.print(gson.toJson(rpta));
  }

  
}
