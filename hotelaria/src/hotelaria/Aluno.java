/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;
import java.io.*;
import java.util.ArrayList;



public class Aluno implements Serializable {
    private int numero;
    private static int ultimo;    
    private String nome;
    private Curso curso;
    private float nota;
    ArrayList <Cadeira> listaCadeiras;

    
    public Aluno(){
    ultimo++;
    numero=ultimo;
    curso =null;
    nome="";
    nota = 0;
    listaCadeiras=new ArrayList <Cadeira>();
   
      
}

   
   public Aluno(String nome, Curso curso, ArrayList <Cadeira> listaCadeiras, float nota){
    this.nome=nome;
    ultimo++;
    numero=ultimo;
    this.curso=curso;
    this.nota = nota;
    this.listaCadeiras = listaCadeiras;
}   

   public static void incUltimo(){
        ultimo++;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
   
    public int getNumero() {
        return numero;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Aluno.ultimo = ultimo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ArrayList<Cadeira> getListaCadeiras() {
        return listaCadeiras;
    }

    public void setListaCadeiras(ArrayList<Cadeira> listaCadeiras) {
        this.listaCadeiras = listaCadeiras;
    }
    

    @Override
    public String toString() {
        return "Aluno{" + "numero=" + numero + ", nome=" + nome + ", curso=" + curso + ", cadeiras" + listaCadeiras + ", nota" + nota + '}';
    }
    
    

   

   

    

    
    
    

   
    
    

   

    
}


