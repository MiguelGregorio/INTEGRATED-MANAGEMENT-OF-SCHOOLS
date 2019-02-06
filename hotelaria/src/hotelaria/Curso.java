/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Curso implements Serializable { 
    private int numCurso;
    private static int ultimo;
    private String nome;
    private ArrayList<Cadeira> cadeiras;
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Horario> horarios;
    
public Curso(){
    ultimo++;
    numCurso=ultimo;
    cadeiras=new ArrayList <Cadeira>();
    listaAlunos=new ArrayList <Aluno>();
    horarios = new ArrayList <Horario>();
    nome="";
}

public Curso(String nome ){
    this.nome=nome;
    ultimo++;
    numCurso=ultimo;
    this.cadeiras=new ArrayList <Cadeira>();
    
}

public void adicionarCadeira(Cadeira c){
    cadeiras.add(c);
}

 public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }
    
    public void adicionarHorario(Horario h){
        horarios.add(h);
    }

    public static void incUltimo(){
        ultimo++;
    }

    public int getNumCurso() {
        return numCurso;
    }

    public void setNumCurso(int numCurso) {
        this.numCurso = numCurso;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Curso.ultimo = ultimo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cadeira> getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(ArrayList<Cadeira> cadeiras) {
        this.cadeiras = cadeiras;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    @Override
    public String toString() {
        return "Curso{" + "numCurso=" + numCurso + ", nome=" + nome + '}';
    }

}
