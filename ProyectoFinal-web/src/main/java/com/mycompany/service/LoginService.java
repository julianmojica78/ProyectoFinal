/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojo.Datos;
import com.mycompany.pojo.Mensaje;
import com.mycompany.pojo.User;
import com.mycompany.utilidad.Seguridad;
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
@javax.enterprise.context.RequestScoped
public class LoginService {
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/login")
 public Response loginUsuario(User user){
    try{
        Datos datos = new Datos();
        Seguridad sg = new Seguridad();
     if(datos.validacion(user) == true){
         Mensaje mensaje = new Mensaje();
         String token = sg.token(user);
         datos.updateToken(user, token);
         mensaje.setMensaje(token);
         
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
