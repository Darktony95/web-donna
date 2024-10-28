/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodonna;

/**
 *
 * @author antho
 */
import com.google.common.collect.ImmutableList;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpls implements ProductoDAO {
    private Connection connection;

    public ProductoDAOImpls(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, categoria, cantidad, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getCategoria());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, categoria = ?, cantidad = ?, precio = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getCategoria());
            statement.setInt(3, producto.getCantidad());
            statement.setDouble(4, producto.getPrecio());
            statement.setInt(5, producto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Producto obtenerProductoPorId(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("categoria"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Producto producto = new Producto(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("categoria"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precio")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
        }
        // Devuelve una lista inmutable de productos
        return ImmutableList.copyOf(productos);
    }
}