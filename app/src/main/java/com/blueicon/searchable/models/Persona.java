package com.blueicon.searchable.models;

/**
 * Created by developer on 16/08/17.
 */

public class Persona {

    private String nombre;
    private String apellido;
    private double peso;
    private int edad;

    public Persona(String nombre, String apellido, double peso, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
