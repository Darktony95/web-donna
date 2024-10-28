/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodonna;

/**
 *
 * @author antho
 */
import java.util.List;

public interface ProductoDAO {
    void agregarProducto(Producto producto);
    void actualizarProducto(Producto producto);
    void eliminarProducto(int id);
    Producto obtenerProductoPorId(int id);
    List<Producto> obtenerTodosLosProductos();
}
