/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAVID
 */
public class Datos {
static Connection con =null;
    static Statement stnt =null;
    static ResultSet rs=null;
    String server;
    String user;
    String pass;

    public Datos() {
        
        server = "jdbc:postgresql://localhost:5432/ProyectoFinalDB";
        user = "postgres";
        pass = "1234";
        
        Conexion c = new Conexion();
        if(c.indica_1()==1 && c.indica_2()==1){
            stnt=c.stamt();
            con =c.con();
        }
    }
    
    
     public Mensaje envio(User usuario){
            Mensaje mensaje = new Mensaje();
            try {
                boolean validar = validarRegistro(usuario);
            if(validar == true){
                 mensaje.setMensaje("Correo ya Existe Intente con Otro");
                 return mensaje;
            }else{
            String qry = "Insert into usuario(nombre,apellido,email,contrasena) values ("+"'" + usuario.getNombres()+ "'"+","+"'" + usuario.getApellidos() + "'"+","+"'" + usuario.getEmail()+ "'"+","+"'" + usuario.getContrasena()+ "'"+")";
                stnt.executeUpdate(qry);
                mensaje.setMensaje("Registro Exitoso");
                return mensaje;
            }
            } catch (SQLException e) {
                mensaje.setMensaje("Error en el Registro");
                return mensaje;                
            }
    }
     
      public Boolean validacion(User usuario){
          boolean estado;
            String qry = "SELECT * FROM public.usuario where email="+"'" + usuario.getEmail()+ "'"+"and contrasena="+"'" + usuario.getContrasena()+ "'"+"";
            try {
                rs=stnt.executeQuery(qry);
                rs.first();
                if(rs.getString(4).isEmpty()){
                     estado=false;
                     return estado;
                }else{
                    estado=true;
                    return estado;
                }
                
               
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        return false;
    }
    public Boolean validarRegistro(User usuario){
          boolean estado;
            String qry = "SELECT * FROM public.usuario where email="+"'" + usuario.getEmail()+ "'";
            try {
                rs=stnt.executeQuery(qry);
                rs.first();
                if(rs.getString(4).isEmpty()){
                     estado=false;
                     return estado;
                }else{
                    estado=true;
                    return estado;
                }
                
               
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        return false;
    }
    
     public void updateToken(User usuario,String jwt){
          
            String qry = "UPDATE public.usuario SET  token="+"'" + jwt+ "'"+"WHERE email="+"'" + usuario.getEmail()+ "'"+"";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
       
    }
     
    public String traerToken(String token){
        String qry ="SELECT token FROM public.usuario where token ="+"'" + token +"'"+"";
        try{
            stnt.executeQuery(qry);
            //return qry;
        } catch(SQLException e){
            System.out.println("Fallo en la Operacion");
        }
        return qry;
    } 
     
    public static ArrayList<User> traerInfo(){
            String qry = "SELECT * FROM usuario";
            ArrayList<User> listauser = new ArrayList<User>();
            try {
                 rs=stnt.executeQuery(qry);
                 listauser=llenado(rs);
                 
            } catch (SQLException e) {
                System.out.println("fallo");
            }
            
           return listauser;
    } 
    
    public static ArrayList<User> llenado(ResultSet rs){
        ArrayList<User> listauser = new ArrayList<User>();
        try {
            while(rs.next()){
               
                    User user = new User();
                    user.setNombres(rs.getString("nombre"));
                    user.setApellidos(rs.getString("apellido"));
                    user.setEmail(rs.getString("correo"));
                    user.setContrasena(rs.getString("contrasena"));
                    
                    listauser.add(user);
                   
            }
            return listauser;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        listauser = null;
        return listauser;
    }

public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(server, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("ConnectDB " + e.getMessage());
        }
    }
public void disconnet() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ConnectDB " + ex.getMessage());
            }
        }
    }
 
    public Connection getConnect() {
        return con;
    }
}

