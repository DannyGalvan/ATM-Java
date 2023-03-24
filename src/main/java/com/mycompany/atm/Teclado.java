/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;

import java.util.Scanner;

/**
 *
 * @author cgalv
 */
public class Teclado {
    private Scanner scann;
    
    public Teclado(){
        scann = new Scanner(System.in);
    }
    
    public int recibirEntrada(){
        return scann.nextInt();
    }
}
