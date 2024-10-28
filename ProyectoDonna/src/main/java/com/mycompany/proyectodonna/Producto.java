/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectodonna;

/**
 *
 * @author antho
 */
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;

    public Producto(int id, String nombre, String categoria, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
