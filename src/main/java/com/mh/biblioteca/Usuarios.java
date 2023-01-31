package com.mh.biblioteca;

public class Usuarios {
    String DNI;
    String Nombre;
    String Telefono;
    String Email;
    String Pass;
    String foto;

    public Usuarios(String DNI, String nombre, String telefono, String email, String Pass, String foto) {
        this.DNI = DNI;
        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Email = email;
        this.Pass = Pass;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
