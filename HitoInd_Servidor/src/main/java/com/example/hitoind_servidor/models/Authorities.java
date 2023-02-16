package com.example.hitoind_servidor.models;

public class Authorities {

    private int id;

    private String nif;

    private String authority;

    public Authorities(int id, String nif, String authority) {
        this.id = id;
        this.nif = nif;
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
