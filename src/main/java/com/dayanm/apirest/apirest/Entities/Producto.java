package com.dayanm.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Indica que esta clase sera una entidad en la base de datos
@Entity
public class Producto {
    //@Id indica que sera la llave primaria de la tabla
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto indica que la generacion del id se ira incrementando automaticamente de forma ascendente
    private Long id;
    private String nombre;
    private double precio;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
