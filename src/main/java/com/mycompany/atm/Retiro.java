/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author cgalv
 */
public class Retiro extends Transaccion {
    
    public Retiro(){
        super();
    }
    
    @Override
    public void ejecutar(){
        System.out.println(String.format("Se esta realizando el retiro de: %s ", this.getMonto()));
    }
}
