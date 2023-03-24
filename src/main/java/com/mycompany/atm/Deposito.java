/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author cgalv
 */
public class Deposito extends Transaccion {    
    
    public Deposito(){
        super();
    }
    
    @Override
    public void ejecutar(){
        System.out.println(String.format("Se esta realizando el deposito de: %s", this.getMontoFlotante()));
        System.out.println(String.format("El Dinero se acreditara a su cuenta en 24 horas"));
    }
}
