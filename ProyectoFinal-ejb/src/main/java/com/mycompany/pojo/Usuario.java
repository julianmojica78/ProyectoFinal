/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.io.Serializable;

/**
 *
 * @author DAVID
 */
public class Usuario implements Serializable{
    
    private int idUsuario;
    private String usuario;
    private String constrasena;
    private String token;

    public Usuario(int idUsuario, String usuario, String constrasena, String token) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.constrasena = constrasena;
        this.token = token;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getConstrasena() {
        return constrasena;
    }

    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
