/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal.service;

import com.mycompany.proyectofinal.Utilidad.Seguridad;
import com.mycompany.proyectofinal.pojo.Datos;
import com.mycompany.proyectofinal.pojo.Mensaje;
import com.mycompany.proyectofinal.pojo.User;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DAVID
 */
@Stateless
@Path("login")
public class LoginService {
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public Response loginUsuario(User user){
    try{
        Datos datos = new Datos();
        Seguridad sg = new Seguridad();
     if(datos.validacion(user) == true){
         Mensaje mensaje = new Mensaje();
         String token = sg.token(user);
         datos.updateToken(user, token);
         mensaje.setMensaje("Ingreso Correcto");
         
         return Response.ok(mensaje).build();
     }else{
         Mensaje mensaje = new Mensaje();
         mensaje.setMensaje("Usuario o Contraseña Incorrectos");
         return Response.status(Response.Status.UNAUTHORIZED).entity(mensaje).build();
     }
    }catch (Exception ex){
         return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
 }


}
