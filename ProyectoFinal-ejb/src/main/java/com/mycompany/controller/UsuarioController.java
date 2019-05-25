/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.pojo.Mensaje;
import com.mycompany.pojo.Usuario;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DAVID
 */
public class UsuarioController {
     
    private List<Usuario> listaUsuario;
    
    public UsuarioController(){
    listaUsuario = new ArrayList();
    listaUsuario.add(new Usuario(1,"Andres","1234","0"));
    listaUsuario.add(new Usuario(2,"Julian","12345","0"));
    }
    
    /**
     * 
     * @return 
     */
    public List<Usuario> getListaUsuario(){
        return listaUsuario;
    }
    /**
     * 
     * @param listaUsuario 
     */
    public void setListaUsuario(List<Usuario> listaUsuario){
        this.listaUsuario = listaUsuario;
    }
    
        public List<Usuario> getListaMateria() {
        return listaUsuario;
    }
    
    /**
      * 
      * @param usuario
      * @param contrasena
      * @return 
      */
     public Mensaje getUsuarioEsp(String usuario,String contrasena){
       for(Usuario usuario1 : listaUsuario){
           if(usuario1.getUsuario().equals(usuario)){
           if(usuario1.getUsuario().equals(usuario) && usuario1.getConstrasena().equals(contrasena)){
               Mensaje mensaje = new Mensaje();
               mensaje.setMensaje("Ingreso Valido");
               //listaUsuario = new ArrayList<Usuario>();
                 int num = (int) (Math.random() * 99999) + 1;
                 String numero = String.valueOf(num);
                 ZonedDateTime dateFormat = ZonedDateTime.now();
                 String token = numero + dateFormat;
                 usuario1.setToken(token);                
              return mensaje;
           }
           else{
               Mensaje mensaje1 = new Mensaje();
               mensaje1.setMensaje("Usuario o Contraseña Invalidos");
               return mensaje1;
           }
         }
       }
       Mensaje mensaje1 = new Mensaje();
       mensaje1.setMensaje("Usuario o Contraseña Invalidos");
       return mensaje1;
     }
     public Mensaje cerrarSesion(String usuario){
         Mensaje msg = new Mensaje();
         for(Usuario usuario1 : listaUsuario){
             if(usuario1.getUsuario().equals(usuario)&&usuario1.getToken().length()>1){
                 usuario1.setToken("0");
                 msg.setMensaje("Sesion Cerrada Correctamente");
                 return msg;
             }
         }
         msg.setMensaje("No se puede cerrar sesion sin estar Loggeado");
         return msg;
     }
}
