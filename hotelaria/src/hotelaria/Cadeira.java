/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class Cadeira implements Serializable {
    private String nome;
    private int numero;
    private static int ultimo;
    private Professor professor;
    private Curso curso;
    
    public Cadeira(){
        ultimo++;
        numero=ultimo;
        nome="";
        professor= null;
        curso=null;
        
       
    }
    
    public void adicionarProfessor(Professor professor){
        this.professor=professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        Cadeira.ultimo = ultimo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Cadeira{" + "nome=" + nome + ", numero=" + numero + ", professor=" + professor +'}' +  "\n";
    }
    

  

    


    
 
 
}





