package com.example.datosproducto;

import java.io.Serializable;

public class Producto implements Serializable {

    //Atributos

    private int codProducto;
    private String marca;
    private String denominacion;
    private Float precio;

    //Constructor

    public Producto(int codProducto, String marca, String denominacion, Float precio) {
        this.codProducto = codProducto;
        this.marca = marca;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    //Getters y setters

    public int getCodProducto() {
        return codProducto;
    }

    public String getMarca() {
        return marca;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public Float getPrecio() {
        return precio;
    }

    //Imprimir

    @Override
    public String toString() {
        return "Producto{" +
                "producto='" + codProducto + '\'' +
                ", marca='" + marca + '\'' +
                ", denominacion='" + denominacion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
