package com.fashionpeak.modelo;

/**
 * Clase Producto - Modelo que representa un producto de Fashion Peak.
 * Aplica encapsulamiento del paradigma orientado a objetos.
 * 
 * @author Laura Valentina Torres Chaparro
 * @version 1.0
 */
public class Producto {

    // Atributos privados (Encapsulamiento)
    private int    idProducto;
    private String nombre;
    private double precio;
    private int    cantidad;
    private String categoria;
    private String imagen;

    /**
     * Constructor vacío
     */
    public Producto() {}

    /**
     * Constructor con todos los atributos
     * @param idProducto identificador único del producto
     * @param nombre     nombre del producto
     * @param precio     precio del producto
     * @param cantidad   cantidad disponible en inventario
     * @param categoria  categoría (Mujer / Hombre)
     * @param imagen     nombre del archivo de imagen
     */
    public Producto(int idProducto, String nombre, double precio,
                    int cantidad, String categoria, String imagen) {
        this.idProducto = idProducto;
        this.nombre     = nombre;
        this.precio     = precio;
        this.cantidad   = cantidad;
        this.categoria  = categoria;
        this.imagen     = imagen;
    }

    /**
     * Constructor sin ID (para inserción)
     */
    public Producto(String nombre, double precio,
                    int cantidad, String categoria, String imagen) {
        this.nombre    = nombre;
        this.precio    = precio;
        this.cantidad  = cantidad;
        this.categoria = categoria;
        this.imagen    = imagen;
    }

    // ===== GETTERS =====
    public int    getIdProducto() { return idProducto; }
    public String getNombre()     { return nombre; }
    public double getPrecio()     { return precio; }
    public int    getCantidad()   { return cantidad; }
    public String getCategoria()  { return categoria; }
    public String getImagen()     { return imagen; }

    // ===== SETTERS =====
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public void setNombre(String nombre)       { this.nombre = nombre; }
    public void setPrecio(double precio)       { this.precio = precio; }
    public void setCantidad(int cantidad)      { this.cantidad = cantidad; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setImagen(String imagen)       { this.imagen = imagen; }

    /**
     * Representación en texto del producto
     * @return String con los datos del producto formateados
     */
    @Override
    public String toString() {
        return String.format(
            "Producto{id=%d, nombre='%s', precio=$%.2f, cantidad=%d, categoria='%s'}",
            idProducto, nombre, precio, cantidad, categoria
        );
    }
}
