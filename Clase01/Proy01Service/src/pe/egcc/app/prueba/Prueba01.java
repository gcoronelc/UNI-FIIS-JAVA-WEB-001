package pe.egcc.app.prueba;

import pe.egcc.app.service.MateService;

public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    int n1 = 56;
    int n2 = 13;
    // Proceso
    MateService mateService = new MateService();
    int suma = mateService.sumar(n1, n2);
    // Reporte
    System.out.println("Número 1: " + n1);
    System.out.println("Número 2: " + n2);
    System.out.println("Suma: " + suma);
  }
  
}
