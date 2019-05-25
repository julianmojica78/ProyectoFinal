/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.controller.UsuarioController;
import com.mycompany.pojo.Datos;
import com.mycompany.pojo.User;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author DAVID
 */
@javax.enterprise.context.RequestScoped
public class UsuarioService {  
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("usuario")
 public Response registroUsuario(User user){
    try{
        Datos datos = new Datos();
        return Response.ok(datos.envio(user)).build();
    }catch (Exception ex){
         return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
 } 
}
