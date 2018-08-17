package pe.egcc.eureka.prueba;

import pe.egcc.eureka.service.impl.CuentaService;

public class Prueba03 {

  public static void main(String[] args) {
    CuentaService service = new CuentaService();
    int rpta = service.procRetiro("00100001", 10, "123456", "0005");
    System.out.println("Rpta: " + rpta);
    System.out.println("Mensaje: " + service.getMensaje());
  }

}
