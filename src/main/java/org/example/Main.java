package org.example;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Variables
        String wallet = "G:\\1-UTEZ\\3-.Cuatrimestre\\POO\\Trabajos\\Semana11\\BaseDatos\\BaseDatos\\src\\Wallet";
        System.setProperty("oracle.net.tns_admin", wallet);

        // Se crea la URL del nombre y la dirección de la base de datos
        // Nombre: UJG9Y951JKFMPG52
        String jdbcUrl = "jdbc:oracle:thin:@UJG9Y951JKFMPG52" + "G:\\1-UTEZ\\3-.Cuatrimestre\\POO\\Trabajos\\Semana11\\BaseDatos\\BaseDatos\\src\\Wallet";

        // Creación para acceder a los datos
        String username = "ADMIN";
        String password = "Spartan$3108jefe&";

        // Capturar los errores que se vayan a tener
        try {
            // Obliga a cargar el driver de la base de datos
            Class.forName("oracle.jdbc.OracleDiver");

            // Hace la conexión y pasa los datos de la base de datos para poder trabajar
            //Verifica si se hizo la conexión correctamente
            Connection conexion = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexión exitosa");
            Statement stmt = conexion.createStatement();

            ResultSet rs = stmt.executeQuery("*select *from AUTOR");

            // Recorre la tabla
            while (rs.next()){
                // Imprime una por una en campo, en este caso, la columna 1
                System.out.println(rs.getString(1));
            }
            rs.close();
            stmt.close();
            conexion.close();
        } catch (Exception e){
            //
            System.out.println("Error en la conexión");
            e.printStackTrace();

        }

    }
}