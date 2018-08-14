package pe.egcc.venta.service;

import pe.egcc.venta.dto.VentaDto;

public class VentaService {
  
  public void procesarVenta( VentaDto dto){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = dto.getPrecio() * dto.getCantidad();
    importe = total / 1.18;
    impuesto = total - importe;
    // Resultado
    dto.setImporte(importe);
    dto.setImpuesto(impuesto);
    dto.setTotal(total);
  }
  
}
