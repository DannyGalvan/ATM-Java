/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atm;
import java.util.InputMismatchException;

/**
 *
 * @author cgalv
 */
public class ATM {

     private Dispensador oDispensador;
     private Pantalla oPantalla;
     private RanuraDeDeposito oRanora;
     private Teclado oTeclado;
     private Transaccion oDeposito;
     private Transaccion oRetiro;
     private Cuenta oCuenta;
     private int SaldoATM;
     
     /**
     * @return the SaldoATM
     */
    public int getSaldoATM() {
        return SaldoATM;
    }

    /**
     * @param SaldoATM the SaldoATM to set
     */
    public void setSaldoATM(int SaldoATM) {
        this.SaldoATM = SaldoATM;
    }

    public ATM() {
        this.oDispensador = new Dispensador();
        this.oPantalla = new Pantalla();
        this.oRanora = new RanuraDeDeposito();
        this.oTeclado = new Teclado();
        this.oDeposito = new Deposito();
        this.oRetiro = new Retiro();
        this.oCuenta = new Cuenta();
        this.SaldoATM = 10000;
        this.inicializar();
    }
    
    
    public void despositar() {
        try {
            int monto;
            float montoFlotante;
            float saldo = this.oCuenta.getSaldoFLotante();
            float nuevoSaldo;
            int confirma;
            this.oPantalla.mostrarMenuDeposito();  
           
            monto = this.oTeclado.recibirEntrada();
        
            if (monto == 0)        
                this.oPantalla.mostrarMensaje("Ha Canselado la transaccion\n");
            
            montoFlotante = monto / 100;
            
            this.oPantalla.mostrarMensaje("Introduzca el sobre sobre la ranura de deposito antes de 2 minutos \n");
            this.oPantalla.mostrarMensaje(String.format("El Monto a depositar seria: %s \n", montoFlotante));
            
            this.oPantalla.mostrarMensaje("1. Confirar \n");
            this.oPantalla.mostrarMensaje("2. Cancelar \n");
            confirma = this.oTeclado.recibirEntrada();
            
            if (confirma == 1) {
                nuevoSaldo = saldo + montoFlotante;                
                this.oDeposito.setMontoFlotante(montoFlotante);
                this.oCuenta.setSaldoFLotante(nuevoSaldo);
                this.oDeposito.ejecutar();
            }
         
        } catch (InputMismatchException e) {
            System.out.println("No se Pueden Ingresar Puntos Decimales");
        }
        
    }

    public void mostarSaldo(int numeroDeCuenta) {
        float saldo = this.oCuenta.consultar(numeroDeCuenta);   
        float saldoFlotante = this.oCuenta.getSaldoFLotante();
        float total = saldo + saldoFlotante;
        this.oPantalla.mostrarMensaje("Consulta de Saldo \n");
        this.oPantalla.mostrarMensaje(String.format("Saldo Disponible: %s \n", saldo));
        this.oPantalla.mostrarMensaje(String.format("Saldo Flotante: %s \n", saldoFlotante));
        this.oPantalla.mostrarMensaje(String.format("Saldo Total de la Cuenta: %s \n", total));
        this.oPantalla.mostrarMensaje("-------------------------------------------------- \n");
    }

    public void retirar(int numeroDeCuenta) { 
        int op = 10;       
        int monto = 0;
  
        while (op > 6) {      
            this.oPantalla.mostrarMenuRetiro();  
            op = this.oTeclado.recibirEntrada();
            switch (op) {
            case 1:
                monto = 20;                
                break;
            case 2:
                monto = 40;               
                break;
            case 3:
                monto = 60;  
                break;
            case 4:
                monto = 100;   
                break;
            case 5:
                monto = 200; 
                break;
            case 6:
               this.oPantalla.mostrarMensaje("La Transaccion ha sido canselada \n");
               break;
            default:
                this.oPantalla.mostrarMensaje("Ingrese una opcion valida \n");
            }      
            
            float saldo = this.oCuenta.getSaldo();
            int saldoAtm = this.getSaldoATM();
            
            if (saldo > monto) {
                this.oRetiro.setMonto(monto);
                float nuevoSaldoCuenta = saldo - (float)monto;
                this.oCuenta.setSaldo(nuevoSaldoCuenta);                
            }else{
                this.oPantalla.mostrarMensaje("Su Cuenta NO Tiene Suficiente Saldo \n");
                return;
            }
            
            if (saldoAtm > monto) {
                this.oRetiro.ejecutar();
                int nuevoSaldoAtm = saldoAtm - monto;
                this.setSaldoATM(nuevoSaldoAtm);
                this.oPantalla.mostrarMensaje(String.format("Su nuevo saldo de la cuenta es %s \n",this.oCuenta.getSaldo()));
            }else{
                this.oPantalla.mostrarMensaje("El Cajero no Tiene Fondos Suficientes \n");
                return;
            }  
        }
    }

    public boolean autenticar(int nip, int numeroDeCuenta) {        
        this.oPantalla.mostrarMensaje(String.format("El numero de cuenta que ingresaste fue: %s \nTu nip es: %s\n", numeroDeCuenta, nip));
        return true;        
    }
    
    public void ejecutar(int opcion, int cuenta){
        switch (opcion) {
            case 1:
                this.mostarSaldo(cuenta);
                break;
            case 2:                
                this.retirar(cuenta);
                break;
            case 3:
                this.despositar();
                break;
            case 4:
                this.oPantalla.mostrarMensaje("Ha Salido del Programa");
                break;
            default:
                this.oPantalla.mostrarMensaje("Ingrese una Opcion Valida");
                break;
        }        
    }  
    
    private void inicializar(){
        int nip;
        int numeroDeCuenta;
        int op = 0;
        this.oCuenta.setSaldo(10000);
        this.oPantalla.mostrarMensaje("Bienvenido al Mejor Cajero Del Mundo \n");
        this.oPantalla.mostrarMensaje("Ingrese su Número de Cuenta:  ");
        numeroDeCuenta = this.oTeclado.recibirEntrada();
        
        this.oPantalla.mostrarMensaje("Ingrese su nip:  ");
        nip = this.oTeclado.recibirEntrada();
        
        this.autenticar(nip, numeroDeCuenta); 
        
        while (op != 4) {  
            this.oPantalla.mostrarMenu();
            op = this.oTeclado.recibirEntrada();
            this.ejecutar(op, numeroDeCuenta);
            this.oPantalla.limpiarPantalla();
        }          
    }
}
