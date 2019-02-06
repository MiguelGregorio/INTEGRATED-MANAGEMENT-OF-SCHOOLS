/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/ 
package hotelaria;

import static hotelaria.AlunoFUNC.*;

/*
 *
 * @author tcanh
*/ 
public class Estatísticas {
    public static void MelhorAlunoCurso(){ 
        Curso c;
        float x = 0;
        String nome = null;
        System.out.println("Nome ou numero do curso:");
        
        do{
            c = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(c.getNome().equals("#Erro Curso nao existe"));
        
        for(int i = 0; i<alunos.size(); i++){
            if(alunos.get(i).getCurso().equals(c)){
                if(x < alunos.get(i).getNota()){
                    nome = alunos.get(i).getNome();
                    x = alunos.get(i).getNota();
                }
            }
        }
        System.out.println("Melhor aluno do curso: " + nome + " " + x);
    }
    
    
    public static void NumeroAlunos(){
        Curso cd;
        int x = 0;
        System.out.println("Nome do curso:");
        do{
            cd = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(cd.getNome().equals("#Erro Curso nao existe"));
        for(int i = 0; i<alunos.size(); i++){
            if(alunos.get(i).getCurso().equals(cd)){
                x++;
            }
        }
        System.out.println("Numero de alunos no curso:" + x +"");
    }
}
