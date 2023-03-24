/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

/**
 *
 * @author cgalv
 */
public abstract class Transaccion {
    
    private int monto; 
    private float montoFlotante;

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * @return the montoFlotante
     */
    public float getMontoFlotante() {
        return montoFlotante;
    }

    /**
     * @param montoFlotante the montoFlotante to set
     */
    public void setMontoFlotante(float montoFlotante) {
        this.montoFlotante = montoFlotante;
    }
    
     public void ejecutar(){
        System.out.println("Se ejectuta la accion desde " +  this.getClass().getSimpleName());
    }
}
