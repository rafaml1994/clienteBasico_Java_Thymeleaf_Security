package com.example.hitoind_servidor.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuarios {


    private String nif;

    private String nombre;

    private String password;

    private String activo;

    public Usuarios(String nif, String nombre, String password, String activo) {
        this.nif = nif;
        this.nombre = nombre;
        this.password = password;
        this.activo = activo;
    }

    public Usuarios(){

    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getActivo() {
        return activo;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
