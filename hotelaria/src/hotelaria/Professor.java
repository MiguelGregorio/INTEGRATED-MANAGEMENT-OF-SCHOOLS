/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

import java.io.*;

public class Professor implements Serializable {
    private int numero;
    private static int ultimo;
    private String nome;
 

    Professor() {
        ultimo++;
        numero=ultimo;
        nome="";
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Professor.ultimo = ultimo;
    }

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" + "numero=" + numero + ", nome=" + nome +  '}';
    }

   

    
    
    
    
}

