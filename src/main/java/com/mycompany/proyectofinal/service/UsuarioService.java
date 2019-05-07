/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal.service;

import com.mycompany.proyectofinal.controller.UsuarioController;
import com.mycompany.proyectofinal.pojo.Datos;
import com.mycompany.proyectofinal.pojo.User;
import com.mycompany.proyectofinal.pojo.Usuario;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
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
 * @author gtior
 */

@Stateless
@Path("usuario")
public class UsuarioService {
    UsuarioController mt = new UsuarioController();
    Usuario user = new Usuario();
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 public Response retornUsuario(){
   return Response.status(Response.Status.OK).build();
   //return Response.ok(mt.getListaUsuario()).build();
   }      
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public Response registroUsuario(User user){
    try{
        Datos datos = new Datos();
        return Response.ok(datos.envio(user)).build();
    }catch (Exception ex){
         return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
 }
 
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/{usuario}/")
 public Response cerrarSesion(@PathParam("usuario")String usuario){
     return Response.ok(mt.cerrarSesion(usuario)).build();
 }
}
