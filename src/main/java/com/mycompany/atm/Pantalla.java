/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author cgalv
 */
public class Pantalla {    
     
    public void mostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }
    
    public void limpiarPantalla(){
         System.out.print("\033[H\033[2J");  
         System.out.flush();  
    }
    
    public void mostrarMenu(){
        System.out.println("Menu Principal");
        System.out.println("1.- Ver Saldo");
        System.out.println("2.- Retirar Efectivo");
        System.out.println("3.- Depositar Fondos");
        System.out.println("4.- Salir");
        System.out.println("Escriba una opcion: ");        
    }
    
    public void mostrarMenuRetiro(){
        System.out.println("Menu De Retiro");
        System.out.println("1.- $20");
        System.out.println("2.- $40");
        System.out.println("3.- $60");
        System.out.println("4.- $100");
        System.out.println("5.- $200");
        System.out.println("6.- Salir");
        System.out.println("Elija un monto de retiro: ");        
    }
    
    public void mostrarMenuDeposito(){
        System.out.println("Ingrese un Monto a Depositar sin punto decimal \nejemplo 2500 es igual a 25.00 y 125 = 12.5");     
    }

}
