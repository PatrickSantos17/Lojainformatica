/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica2;

/**
 *
 * @author patri
 */

public class Computador {

    int idComputador;
    static String marca = "Patrick Santos";
    String hd;
    String processador;

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public static String getMarca() {
        return marca;
    }

    public static void setMarca(String marca) {
        Computador.marca = marca;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public Computador() {
    }

    public Computador(String hd, String processador) {
        this.hd = hd;
        this.processador = processador;
    }

    public Computador(int idComputador, String hd, String processador) {
        this.idComputador = idComputador;
        this.hd = hd;
        this.processador = processador;
    }
    
    

    
}

