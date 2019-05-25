/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utilidad;

import com.mycompany.pojo.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author DAVID
 */
public class Seguridad {
       public String token (User usuario){
        
      
      long tiempo = System.currentTimeMillis();
      String jwt = Jwts.builder()
              .signWith(SignatureAlgorithm.HS512, "l8H|nq|1CJ:=pU")
              .setSubject(usuario.getEmail())
              .setIssuedAt(new Date(tiempo))
              .setExpiration(new Date(tiempo+18000000))
              .claim("Correo",usuario.getEmail())
              .compact();
      JsonObject json = Json.createObjectBuilder().add("JWT",jwt).build();
      return jwt;
        
    }
}
