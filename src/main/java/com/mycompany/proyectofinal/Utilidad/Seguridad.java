/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectofinal.Utilidad;

import com.mycompany.proyectofinal.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

/**
 *
 * @author DAVID
 */
public class Seguridad {
   
    public String token (User usuario){
        
      String KEY  = "mi_clave";
      long tiempo = System.currentTimeMillis();
      String jwt = Jwts.builder()
              .signWith(SignatureAlgorithm.HS256, KEY)
              .setSubject(usuario.getEmail())
              .setIssuedAt(new Date(tiempo))
              .setExpiration(new Date(tiempo+18000000))
              .claim("Correo",usuario.getEmail())
              .compact();
      JsonObject json = Json.createObjectBuilder().add("JWT",jwt).build();
      return jwt;
        
    }
    
}
