package com.fashionpeak.dao;

import com.fashionpeak.modelo.Producto;
import java.util.List;

/**
 * Interface IProductoDAO - Define las operaciones CRUD para Producto.
 * Aplica el principio de abstracción del paradigma orientado a objetos.
 * 
 * @author Laura Valentina Torres Chaparro
 * @version 1.0
 */
public interface IProductoDAO {

    /**
     * Inserta un nuevo producto en la base de datos
     * @param producto objeto Producto a insertar
     * @return true si la inserción fue exitosa, false en caso contrario
     */
    boolean insertarProducto(Producto producto);

    /**
     * Consulta todos los productos de la base de datos
     * @return Lista de todos los productos
     */
    List<Producto> consultarTodos();

    /**
     * Consulta un producto por su ID
     * @param idProducto identificador único del producto
     * @return Producto encontrado o null si no existe
     */
    Producto consultarPorId(int idProducto);

    /**
     * Consulta productos por categoría
     * @param categoria categoría a filtrar (Mujer / Hombre)
     * @return Lista de productos de la categoría indicada
     */
    List<Producto> consultarPorCategoria(String categoria);

    /**
     * Actualiza los datos de un producto existente
     * @param producto objeto Producto con los datos actualizados
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    boolean actualizarProducto(Producto producto);

    /**
     * Elimina un producto de la base de datos por su ID
     * @param idProducto identificador del producto a eliminar
     * @return true si la eliminación fue exitosa, false en caso contrario
     */
    boolean eliminarProducto(int idProducto);
}
