package pe.egcc.venta.prueba;

import pe.egcc.venta.dto.VentaDto;
import pe.egcc.venta.service.VentaService;


public class Prueba01 {
  public static void main(String[] args) {
    //Dato
    VentaDto dto = new VentaDto(35.13, 8);
    //Proceso
    VentaService service = new VentaService();
    service.procesarVenta(dto);
    //reporte
    System.out.println("Import: "+dto.getImporte());
    System.out.println("Impuesto: "+dto.getImpuesto());
    System.out.println("Total: "+dto.getTotal());
  }
}
