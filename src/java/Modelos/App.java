
package Modelos;

import Modelos.Consultas;

public class App {
    public static void main(String[] args) {
        Consultas consulta=new Consultas();
       
        System.out.println(consulta.autenticacion("cristiangsanchez@gmail.com", "123"));
        
    }
     
}
