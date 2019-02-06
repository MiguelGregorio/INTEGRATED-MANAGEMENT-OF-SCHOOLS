/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;

import static hotelaria.AlunoFUNC.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Miguel
 */
public class ProfessorFUNC {
     public static ArrayList<Professor>professores = new ArrayList<>();
    
    public static void RegistarProfessorFile(){
        try{
            ObjectOutputStream os = new ObjectOutputStream
            ( new FileOutputStream ("professores.txt"));
            
        os.writeInt(Professor.getUltimo());    
        os.writeObject(professores);
        os.flush();
        
        }            
        catch(IOException e){
            System.out.println("Ocorreu um erro!"+e.getMessage());
        }
    }
    
    
     public static void LerProfessorFile(){
        try{
            ObjectInputStream is = new ObjectInputStream
            (new FileInputStream("professores.txt"));

            int ult= is.readInt();
            Professor.setUltimo(ult);
            professores = (ArrayList) is.readObject();
            } 
            
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                
                catch ( ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
    }
     
     
      public static void RegistarProfessor(){
        Professor novoProfessor = new Professor();
        int i;

        System.out.println("------- Registo de professor -------");
        System.out.println("----------------------------------");
        System.out.print("Nome do professor: ");
        novoProfessor.setNome(Ler.umaString());
        //...
       
        
        
        for(i = 0; i<professores.size();i++){
            if(professores.get(i).getNome().equals(novoProfessor.getNome())){
                System.out.println("Professor já foi registado anteriormente");
                break;
            }
        }
        if(i == professores.size()){                                               
            professores.add(novoProfessor);
            RegistarProfessorFile();
            System.out.println("Professor criado com sucesso");
            System.out.println("    ");            
            System.out.println("O numero atribuido foi: "+ Professor.getUltimo());
        }
        
    }
      
       public static Professor ProcuraProfessor(String x){
        Professor professor;
        try{
                int numero = Integer.parseInt(x);
                professor = ProfessorFUNC.PesquisarProfessor(numero);
            }
            catch(NumberFormatException e){
                professor = ProfessorFUNC.PesquisarProfessor(x);
            }
        return professor;
    }
      
      
      public static Professor PesquisarProfessor(int numero){
        for(int i = 0; i<professores.size();i++){
            if(numero == professores.get(i).getNumero())
                return professores.get(i);        
        }
        return ProfessorNAOEXISTE();        
    }

    public static Professor PesquisarProfessor(String nome){
        for(int i = 0; i<professores.size();i++){
            if(nome.equals(professores.get(i).getNome()))
                return professores.get(i);        
        }
        return ProfessorNAOEXISTE();        
    }    
    
     public static Professor ProfessorNAOEXISTE(){
        Professor ProfessorNAOEXISTE = new Professor();
        ProfessorNAOEXISTE.setNome("#Erro professor nao existe");
        return ProfessorNAOEXISTE;
    }
     
     public static String PesquisarProfessor(){
        Professor nv;
        System.out.print("Nome ou numero do professor: ");
        nv = ProcuraProfessor(Ler.umaString());
        
        for (int i = 0; i<professores.size();i++){
            if(professores.get(i).equals(nv)){
                System.out.println("O professor existe");
                    System.out.println(professores.get(i).toString());
            }
        }
        return("O professor não existe.");
    }
     
      public static void ListarProfessores(){
        if(professores.isEmpty()){
            System.out.println("Não ha nenhum professor registado.");
        }
        for(int i = 0; i<professores.size(); i++)
            System.out.println(professores.get(i).toString());
    }
      
      
      public static void EditarProfessor(){ 
        Professor nv;         
         
        System.out.print("Nome/Numero do professor a modificar: ");
        nv = ProcuraProfessor(Ler.umaString());
        
        for(int i=0; i<professores.size();i++){
            Professor c = professores.get(i);
            if(c.equals(nv)){        
 
                System.out.print("Novo nome do professor: (" + c.getNome() + "): ");
                c.setNome(Ler.umaString());
                //faltam coisas !
                
                
                RegistarProfessorFile();
       
                System.out.println("Professor modificado com sucesso.");
                return;
            }
        }
        System.out.println("Professor não existe");
    }
      
       public static void EliminarProfessor(){
        Professor nv;
        System.out.print("Nome/Numero do professor: ");
        nv = ProcuraProfessor(Ler.umaString());
        
        for(int i = 0; i<professores.size(); i++){
            if(professores.get(i).equals(nv)){
                
                professores.remove(i);
                System.out.println("professor Eliminado");
                RegistarProfessorFile();
                return;
            }
        }
        System.out.println("O professor não existe");
    }
       
       public static void EliminarTodosProfessor(){
        System.out.println("-------ATENÇÃO-------");
        System.out.println("---------------------");
        System.out.println(" Tem a certeza que deseja eliminar TODOS os professores? (S/N)\n");
        System.out.print("-> ");

        String son = Ler.umaString();
        if (son.equals("s")||son.equals("S"))
            DeleteAll();
        else
            System.out.println("Operação Cancelada");
    }
    
    public static void DeleteAll(){
        professores.clear();
        System.out.println("Todos os professores foram eliminados.");
        Professor.setUltimo(0);
        RegistarProfessorFile();
    }
   
     public static void InserirNota(){
        Aluno nv;
        float soma = 0;
        float media = 0;
        float x;
        System.out.print("Nome do aluno: ");
        do{
            nv = AlunoFUNC.ProcuraAluno(Ler.umaString());
        }while(nv.getNome().equals("#Erro Aluno nao existe"));
        System.out.println(nv.getListaCadeiras());
        System.out.println("Inserir notas das cadeiras por ordem:");
        for(int i = 0; i<nv.getListaCadeiras().size(); i++){
            x = Ler.umInt();
            if((x<0) || (x>20)){
                while((x<0) || (x>20)){
                System.out.println("Insira um nota válida. 0->20");
                x = Ler.umInt();
                }
            }    
            soma = soma + x;
            System.out.println("Nota inserida com sucesso.");
        }
        media = soma / nv.getListaCadeiras().size();
        nv.setNota(media);
        RegistarAlunoFile();
    }
}
