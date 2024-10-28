/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodonna;

/**
 *
 * @author antho
 */

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Coneccion {


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/minimarket";
    private static final String USER = "root"; // Cambia esto según tu configuración
    private static final String PASSWORD = "root"; // Cambia esto según tu configuración

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el driver de MySQL (opcional en versiones más recientes)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos exitosa.");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        }
        return connection;
    }
} 
}
