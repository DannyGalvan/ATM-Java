/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author cgalv
 */
public class SqlConnection {
    private static String connectionString = "jdbc:sqlserver://DESKTOP-4L7JSNJ:1433;"
                        + "database=eureka502Pruebas;"
                        + "user=sa;"
                        + "password=andrea2911;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";
    
   
     public static Connection getConection(){
        try{
            Connection connection = DriverManager.getConnection(connectionString);            
            System.out.println("conexion exitosa");
            return connection;
        }
        catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
     }
}
