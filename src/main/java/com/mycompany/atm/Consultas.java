/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cgalv
 */
public class Consultas {
    
     public static void Consulta(){
         try (Statement sql = SqlConnection.getConection().createStatement()) {
             String query = "select top(10) * from tbl_productos";
             ResultSet resultado = sql.executeQuery(query);
             
             while(resultado.next()){
                 String data = String.format("id: %s  nombre: %s",resultado.getString("Id") , resultado.getString("Descripcion"));
                 System.out.println(data);
             }
         } catch (SQLException ex) { 
             Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
         }      
     }  
}
