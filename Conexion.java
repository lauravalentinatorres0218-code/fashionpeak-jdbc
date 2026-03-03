package com.fashionpeak.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion - Gestiona la conexión a la base de datos MySQL
 * mediante JDBC para el proyecto Fashion Peak.
 * 
 * @author Laura Valentina Torres Chaparro
 * @version 1.0
 */
public class Conexion {

    // Constantes de conexión
    private static final String URL      = "jdbc:mysql://localhost:3306/fashionpeak";
    private static final String USUARIO  = "root";
    private static final String PASSWORD = "1234";
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";

    // Instancia única (Singleton)
    private static Conexion instancia;
    private Connection conexion;

    /**
     * Constructor privado - Patrón Singleton
     */
    private Conexion() {
        try {
            Class.forName(DRIVER);
            this.conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("✅ Conexión establecida con Fashion Peak DB");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver MySQL no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la BD: " + e.getMessage());
        }
    }

    /**
     * Obtiene la instancia única de la conexión (Singleton)
     * @return instancia de Conexion
     */
    public static Conexion getInstancia() {
        if (instancia == null || esConexionCerrada()) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Retorna el objeto Connection para ejecutar sentencias SQL
     * @return Connection activa
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Verifica si la conexión está cerrada
     * @return true si la conexión está cerrada o es nula
     */
    private static boolean esConexionCerrada() {
        try {
            return instancia.conexion == null || instancia.conexion.isClosed();
        } catch (SQLException e) {
            return true;
        }
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("🔒 Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
