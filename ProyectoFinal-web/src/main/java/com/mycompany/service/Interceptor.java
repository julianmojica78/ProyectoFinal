/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.pojo.Datos;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author DAVID
 */
@Provider
@PreMatching
public class Interceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Datos dts = new Datos();
        String url = requestContext.getUriInfo().getAbsolutePath().toString();
        if(url.contains("api/login") || url.contains("api/usuario"))
            return;
        String token = requestContext.getHeaderString("tokenAuto");
        if(token == null){
            JsonObject json = Json.createObjectBuilder()
                    .add("Mensaje","Token Requerido para Continuar")
                    .build();
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
            .entity(json)
            .type(MediaType.APPLICATION_JSON)
            .build());
        }else if(!token.equals(dts.traerToken(token))){
        JsonObject json = Json.createObjectBuilder()
                .add("userToken","Token Incorrecto")
                .build();
        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
        .entity(json)
        .type(MediaType.APPLICATION_JSON)
        .build());
    }
    }
    
    
    
}
