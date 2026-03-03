package com.fashionpeak;

import com.fashionpeak.vista.MenuPrincipal;

/**
 * Clase Main - Punto de entrada del módulo CRUD de Fashion Peak.
 * Gestión de productos con conexión JDBC a MySQL.
 * 
 * @author Laura Valentina Torres Chaparro
 * @version 1.0
 * @since 2026
 */
public class Main {

    /**
     * Método principal - Inicia la aplicación Fashion Peak
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   FASHION PEAK - Módulo de Productos ║");
        System.out.println("║   Codificación JDBC con MySQL        ║");
        System.out.println("║   GA7-220501096-AA2-EV01             ║");
        System.out.println("╚══════════════════════════════════════╝");

        MenuPrincipal menu = new MenuPrincipal();
        menu.iniciar();
    }
}
