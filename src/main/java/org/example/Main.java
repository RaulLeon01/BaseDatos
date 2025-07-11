package org.example;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Variables
        String wallet = "G:\\1-UTEZ\\3-.Cuatrimestre\\POO\\Trabajos\\1-Cartera\\Biblioteca";
        System.setProperty("oracle.net.icl8aqfau8e0bzlc_high", wallet);

        // Se crea la URL del nombre y la dirección de la base de datos
        // Nombre: icl8aqfau8e0bzlc_high
        String jdbcUrl = "jdbc:oracle:thin:@icl8aqfau8e0bzlc_high";

        // Creación para acceder a los datos
        String username = "ADMIN";
        String password = "Biblioteca01";

        // Capturar los errores que se vayan a tener
        try {
            // Obliga a cargar el driver de la base de datos
            Class.forName("oracle.jdbc.OracleDiver");

            // Hace la conexión y pasa los datos de la base de datos para poder trabajar
            //Verifica si se hizo la conexión correctamente
            Connection conexion = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Conexión exitosa");
            Statement stmt = conexion.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM AUTORES");

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