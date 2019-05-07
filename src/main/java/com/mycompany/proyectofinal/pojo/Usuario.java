/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gtior
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
    
    public Usuario(){
        
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the constrasena
     */
    public String getConstrasena() {
        return constrasena;
    }

    /**
     * @param constrasena the constrasena to set
     */
    public void setConstrasena(String constrasena) {
        this.constrasena = constrasena;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }    
}
