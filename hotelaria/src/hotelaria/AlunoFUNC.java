/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;
import java.util.*;
import java.io.*;

/**
 *
 * @author Miguel
 */
public class AlunoFUNC {
     public static ArrayList<Aluno>alunos = new ArrayList<>();
     
    public static void RegistarAlunoFile(){
        try{
            ObjectOutputStream os = new ObjectOutputStream
            ( new FileOutputStream ("alunos.txt"));
            
        os.writeInt(Aluno.getUltimo());    
        os.writeObject(alunos);
        os.flush();
        
        }            
        catch(IOException e){
            System.out.println("Ocorreu um erro!"+e.getMessage());
        }
    }
    
    
     public static void LerAlunoFile(){
        try{
            ObjectInputStream is = new ObjectInputStream
            (new FileInputStream("alunos.txt"));

            int ult= is.readInt();
            Aluno.setUltimo(ult);
            alunos = (ArrayList) is.readObject();
            } 
            
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                
                catch ( ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
    }
     
     
      public static void RegistarAluno(){
        //ArrayList <Cadeira> listaCadeiras = new ArrayList <>();
        Aluno novoAluno = new Aluno();
        int i;
        Curso curso;
        ArrayList <Cadeira> cd;

        System.out.println("------- Registo de Aluno -------");
        System.out.println("----------------------------------");
        System.out.print("Nome do Aluno: ");
        novoAluno.setNome(Ler.umaString());
        for(i = 0; i<alunos.size();i++){
            if(alunos.get(i).getNome().equals(novoAluno.getNome())){
                System.out.println("Aluno já foi registado anteriormente");
                break;
            }
        }
        
        System.out.print("Curso do Aluno: ");                             
        
        do{
            curso = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(curso.getNome().equals("#Erro Curso nao existe"));
        novoAluno.setCurso(curso);
        
        
        cd = curso.getCadeiras();
        novoAluno.setListaCadeiras(cd);
 
        if(i == alunos.size()){//Percorreu toda a ArrayList
            
            alunos.add(novoAluno);
            RegistarAlunoFile();
            System.out.println("Aluno criado com sucesso");
            System.out.println("    ");            
            System.out.println("O numero atribuido foi: "+ Aluno.getUltimo());
        }
        
    }
      
       public static Aluno ProcuraAluno(String x){
        Aluno aluno;
        try{
                int numero = Integer.parseInt(x);
                aluno = AlunoFUNC.PesquisarAluno(numero);
            }
            catch(NumberFormatException e){
                aluno = AlunoFUNC.PesquisarAluno(x);
            }
        return aluno;
    }
      
      
      public static Aluno PesquisarAluno(int numero){
        for(int i = 0; i<alunos.size();i++){
            if(numero == alunos.get(i).getNumero())
                return alunos.get(i);        
        }
        return AlunoNAOEXISTE();        
    }

    public static Aluno PesquisarAluno(String nome){
        for(int i = 0; i<alunos.size();i++){
            if(nome.equals(alunos.get(i).getNome()))
                return alunos.get(i);        
        }
        return AlunoNAOEXISTE();        
    }    
    
     public static Aluno AlunoNAOEXISTE(){
        Aluno AlunoNAOEXISTE = new Aluno();
        AlunoNAOEXISTE.setNome("#Erro Aluno nao existe");
        return AlunoNAOEXISTE;
    }
     
      public static void ListarAlunos(){
        if(alunos.isEmpty()){
            System.out.println("Não ha nenhum aluno registado.");
        }
        for(int i = 0; i<alunos.size(); i++)
            System.out.println(alunos.get(i).toString() );
    }
      
      public static String PesquisarAluno(){
        Aluno nv;
        System.out.print("Nome ou numero do aluno: ");
        nv = ProcuraAluno(Ler.umaString());
        
        for (int i = 0; i<alunos.size();i++){
            if(alunos.get(i).equals(nv)){
                System.out.println("O aluno existe");
                    System.out.println(alunos.get(i).toString());
            }
        }
        return("O aluno não existe.");  
    }
      
      public static void EditarAluno(){ 
        Aluno nv;         
         
        System.out.print("Nome/Numero do aluno a modificar: ");
        nv = ProcuraAluno(Ler.umaString());
        
        for(int i=0; i<alunos.size();i++){
            Aluno c = alunos.get(i);
            if(c.equals(nv)){        
 
                System.out.print("Novo nome do aluno: (" + c.getNome() + "): ");
                c.setNome(Ler.umaString());
                //faltam coisas !
                
                
                RegistarAlunoFile();
       
                System.out.println("Aluno modificado com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não existe");
    }
      
      public static void EliminarAluno(){
        Aluno nv;
        System.out.print("Nome/Numero do Aluno: ");
        nv = ProcuraAluno(Ler.umaString());
        
        for(int i = 0; i<alunos.size(); i++){
            if(alunos.get(i).equals(nv)){
                
                alunos.remove(i);
                System.out.println("Aluno Eliminado");
                RegistarAlunoFile();
                return;
            }
        }
        System.out.println("O aluno não existe");
    }
      
      public static void EliminarTodosAlunos(){
        System.out.println("-------ATENÇÃO-------");
        System.out.println("---------------------");
        System.out.println(" Tem a certeza que deseja eliminar TODOS os alunos? (S/N)\n");
        System.out.print("-> ");

        String son = Ler.umaString();
        if (son.equals("s")||son.equals("S"))
            DeleteAll();
        else
            System.out.println("Operação Cancelada");
    }
    
    public static void DeleteAll(){
        alunos.clear();
        System.out.println("Todos os alunos foram eliminados.");
        Aluno.setUltimo(0);
        RegistarAlunoFile();
    }
}
