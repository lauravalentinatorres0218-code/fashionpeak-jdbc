package com.fashionpeak.vista;

import com.fashionpeak.dao.ProductoDAO;
import com.fashionpeak.modelo.Producto;

import java.util.List;
import java.util.Scanner;

/**
 * Clase MenuPrincipal - Interfaz de consola para gestionar los productos
 * de Fashion Peak. Permite realizar operaciones CRUD desde la terminal.
 * 
 * @author Laura Valentina Torres Chaparro
 * @version 1.0
 */
public class MenuPrincipal {

    private final ProductoDAO productoDAO;
    private final Scanner     scanner;

    /**
     * Constructor - Inicializa el DAO y el lector de consola
     */
    public MenuPrincipal() {
        this.productoDAO = new ProductoDAO();
        this.scanner     = new Scanner(System.in);
    }

    /**
     * Inicia la ejecución del menú principal
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 0);

        scanner.close();
        System.out.println("👋 ¡Hasta luego! - Fashion Peak");
    }

    /**
     * Muestra el menú principal en consola
     */
    private void mostrarMenu() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║       FASHION PEAK - CRUD        ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║  1. Insertar producto            ║");
        System.out.println("║  2. Consultar todos              ║");
        System.out.println("║  3. Consultar por ID             ║");
        System.out.println("║  4. Consultar por categoría      ║");
        System.out.println("║  5. Actualizar producto          ║");
        System.out.println("║  6. Eliminar producto            ║");
        System.out.println("║  0. Salir                        ║");
        System.out.println("╚══════════════════════════════════╝");
    }

    /**
     * Procesa la opción seleccionada por el usuario
     * @param opcion número de opción del menú
     */
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> insertarProducto();
            case 2 -> consultarTodos();
            case 3 -> consultarPorId();
            case 4 -> consultarPorCategoria();
            case 5 -> actualizarProducto();
            case 6 -> eliminarProducto();
            case 0 -> System.out.println("Cerrando aplicación...");
            default -> System.out.println("⚠️  Opción no válida. Intente de nuevo.");
        }
    }

    // =============================================
    // OPERACIÓN 1 - INSERTAR
    // =============================================
    private void insertarProducto() {
        System.out.println("\n➕ INSERTAR NUEVO PRODUCTO");
        System.out.println("─────────────────────────────");

        String nombre    = leerTexto("Nombre del producto: ");
        double precio    = leerDecimal("Precio: ");
        int    cantidad  = leerEntero("Cantidad disponible: ");
        String categoria = leerCategoria();
        String imagen    = leerTexto("Nombre imagen (ej: camiseta.png): ");

        Producto nuevoProducto = new Producto(nombre, precio, cantidad, categoria, imagen);
        boolean  exito         = productoDAO.insertarProducto(nuevoProducto);

        System.out.println(exito
            ? "✅ Producto insertado correctamente."
            : "❌ No se pudo insertar el producto.");
    }

    // =============================================
    // OPERACIÓN 2 - CONSULTAR TODOS
    // =============================================
    private void consultarTodos() {
        System.out.println("\n📋 TODOS LOS PRODUCTOS");
        System.out.println("─────────────────────────────");

        List<Producto> listaProductos = productoDAO.consultarTodos();

        if (listaProductos.isEmpty()) {
            System.out.println("⚠️  No hay productos registrados.");
        } else {
            System.out.printf("%-5s %-30s %-12s %-10s %-10s%n",
                "ID", "NOMBRE", "PRECIO", "CANTIDAD", "CATEGORÍA");
            System.out.println("─".repeat(70));
            for (Producto p : listaProductos) {
                System.out.printf("%-5d %-30s $%-11.2f %-10d %-10s%n",
                    p.getIdProducto(), p.getNombre(),
                    p.getPrecio(), p.getCantidad(), p.getCategoria());
            }
        }
    }

    // =============================================
    // OPERACIÓN 3 - CONSULTAR POR ID
    // =============================================
    private void consultarPorId() {
        System.out.println("\n🔍 CONSULTAR PRODUCTO POR ID");
        System.out.println("─────────────────────────────");

        int     idBuscado = leerEntero("ID del producto: ");
        Producto producto  = productoDAO.consultarPorId(idBuscado);

        if (producto != null) {
            System.out.println("\n" + producto);
        } else {
            System.out.println("⚠️  No se encontró un producto con ID " + idBuscado);
        }
    }

    // =============================================
    // OPERACIÓN 4 - CONSULTAR POR CATEGORÍA
    // =============================================
    private void consultarPorCategoria() {
        System.out.println("\n🏷️  CONSULTAR POR CATEGORÍA");
        System.out.println("─────────────────────────────");

        String         categoria      = leerCategoria();
        List<Producto> listaProductos = productoDAO.consultarPorCategoria(categoria);

        if (listaProductos.isEmpty()) {
            System.out.println("⚠️  No hay productos en la categoría: " + categoria);
        } else {
            listaProductos.forEach(System.out::println);
        }
    }

    // =============================================
    // OPERACIÓN 5 - ACTUALIZAR
    // =============================================
    private void actualizarProducto() {
        System.out.println("\n✏️  ACTUALIZAR PRODUCTO");
        System.out.println("─────────────────────────────");

        int      idProducto = leerEntero("ID del producto a actualizar: ");
        Producto existente  = productoDAO.consultarPorId(idProducto);

        if (existente == null) {
            System.out.println("⚠️  No se encontró un producto con ID " + idProducto);
            return;
        }

        System.out.println("Producto actual: " + existente);
        System.out.println("(Ingresa los nuevos datos)");

        String nombre    = leerTexto("Nuevo nombre [" + existente.getNombre() + "]: ");
        double precio    = leerDecimal("Nuevo precio [" + existente.getPrecio() + "]: ");
        int    cantidad  = leerEntero("Nueva cantidad [" + existente.getCantidad() + "]: ");
        String categoria = leerCategoria();
        String imagen    = leerTexto("Nueva imagen [" + existente.getImagen() + "]: ");

        Producto productoActualizado = new Producto(
            idProducto, nombre, precio, cantidad, categoria, imagen
        );

        boolean exito = productoDAO.actualizarProducto(productoActualizado);
        System.out.println(exito
            ? "✅ Producto actualizado correctamente."
            : "❌ No se pudo actualizar el producto.");
    }

    // =============================================
    // OPERACIÓN 6 - ELIMINAR
    // =============================================
    private void eliminarProducto() {
        System.out.println("\n🗑️  ELIMINAR PRODUCTO");
        System.out.println("─────────────────────────────");

        int idEliminar = leerEntero("ID del producto a eliminar: ");
        System.out.print("¿Confirmas eliminar el producto con ID " + idEliminar + "? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();

        if (confirmacion.equals("s")) {
            boolean exito = productoDAO.eliminarProducto(idEliminar);
            System.out.println(exito
                ? "✅ Producto eliminado correctamente."
                : "❌ No se pudo eliminar el producto.");
        } else {
            System.out.println("⚠️  Eliminación cancelada.");
        }
    }

    // =============================================
    // MÉTODOS AUXILIARES DE LECTURA
    // =============================================

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            int valor = Integer.parseInt(scanner.nextLine().trim());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("⚠️  Valor inválido, ingresa un número entero.");
            return leerEntero(mensaje);
        }
    }

    private double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠️  Valor inválido, ingresa un número decimal.");
            return leerDecimal(mensaje);
        }
    }

    private String leerCategoria() {
        System.out.print("Categoría (1=Mujer / 2=Hombre): ");
        String opcion = scanner.nextLine().trim();
        return opcion.equals("1") ? "Mujer" : opcion.equals("2") ? "Hombre" : "Mujer";
    }
}
