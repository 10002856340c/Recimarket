package Modelos;

import Modelos.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
creamos una clase llamada Consultas en el cual a ha heredar todo los metodos que tenga la
clase Conexion 
*/
public class Consultas extends Conexion{

/*Creamos un metodo  de tipo boolean llamado "autenticacion" en el cual va a recibir dos variables de tipo String en cual va hacer el usuario 
y la clave , en el cual nos va a retornar un true si ese usuario existe en nuestra base de datos o false si no existe */
public boolean autenticacion(String CorreoElectronico, String password){

     /*
PreparedStatemen --> En los sistemas de administración de bases de datos, una declaración preparada, 
una declaración parametrizada o una consulta parametrizada es una función que se utiliza para compilar previamente el código SQL, 
separándolo de los datos.

ResultSet --> Un ResultSet, o conjunto de resultados, contiene los resultados de una consulta SQL, por lo que es un conjunto de filas 
obtenidas desde una base de datos, así como Metadatos sobre la consulta y los tamaños de cada columna

*/
    //inicializamos las variables pst y rs en null
    PreparedStatement pst=null;
    ResultSet rs=null;

    try {
//Hacemos la consulta con sintaxis sql
        String conculta ="select * from  usuarios where CorreoElectronico= ? and password= ?";
//almacenamos en la variable pst la consulta sql
        pst=getConexion().prepareStatement(conculta,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//setString del 1 signo --> ?--> username 
//setString del 2 signo --> ?-->password
        pst.setString(1, CorreoElectronico);
        pst.setString(2, password);
        //guardamos nuestra consulta en nuestro resultset y ejecutamos 
        rs=pst.executeQuery();

//si tiene un registro 
        if(rs.absolute(1)){
        return true;
        }

    } catch (Exception e) {

        System.err.println("Error ---> "+e.getMessage());
//finalemente vamos hacer un cierre de conexion 
    }finally{
        try {
        //si la conexion esta abierta 
        if(getConexion()!=null){
        //la cerramos close()
        getConexion().close();
        }
        if(pst!=null){
         pst.close();
        }
        if(rs!=null){
        rs.close();
        }
            
        } catch (Exception e) {
            System.err.println("Error : "+e.getMessage());

        }

}
    
    return false;

}


public boolean registrar(String Nombres,String Apellidos, String Identificacion,String CorreoElectronico,String Telefono,String password){

/*PreparedStatemen --> En los sistemas de administración de bases de datos, una declaración preparada, 
una declaración parametrizada o una consulta parametrizada es una función que se utiliza para compilar previamente el código SQL, 
separándolo de los datos.*/
        PreparedStatement pst =null;

    try {
        /*Agregamos nuestra consulta en sintaxis sql organizado respectivamente como esta en el metodo */
            String consulta2="insert into usuarios(Nombres,Apellidos,Identificacion,CorreoElectronico,Telefono,password) values (?,?,?,?,?,?)";
         pst=getConexion().prepareStatement(consulta2);
       
            /*Hacemos la conexion de nuestra consulta */
          
         /*Asignamos los valores por medio de un set 
        estos valores que se van agregar son los mismos que le vamos a pasar por el metodo  */
    
          pst.setString(1, Nombres);
          pst.setString(2, Apellidos);
          pst.setString(3, Identificacion);
          pst.setString(4,CorreoElectronico);
         pst.setString(5, Telefono);
         pst.setString(6, password);
         

         //si hay una modificacion en la actualizacion de alguna tabla 
          if(pst.executeUpdate()==1){
          return true;
        }
        
    } catch (Exception e) {
        System.err.println("Error 1"+e.getMessage());
    }finally{
            //Cerramos la conexion cuando este abierta despues de que se haga la ejecucion de la sentencia 
        try {
            if(getConexion()!=null){
              getConexion().close();
            }if(pst!=null){
                pst.close();
            }
        } catch (Exception e) {
            System.out.println("Error 2"+e.getMessage());
        }
    }



    return  false;
}

}
    
