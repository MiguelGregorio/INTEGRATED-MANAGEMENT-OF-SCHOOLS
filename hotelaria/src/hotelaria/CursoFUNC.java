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
public class CursoFUNC {
    
    
    public static ArrayList<Curso>cursos = new ArrayList<>();
    //public static ArrayList<Aluno>listaAlunos = new ArrayList<>();
     
     
    public static void RegistarCursoFile(){
        try{
            ObjectOutputStream os = new ObjectOutputStream
            ( new FileOutputStream ("cursos.txt"));
            
        os.writeInt(Curso.getUltimo());    
        os.writeObject(cursos);
        os.flush();
        
        }            
        catch(IOException e){
            System.out.println("Ocorreu um erro!"+e.getMessage());
        }
    }
    
     public static void LerCursoFile(){
        try{
            ObjectInputStream is = new ObjectInputStream
            (new FileInputStream("cursos.txt"));

            int ult= is.readInt();
            Curso.setUltimo(ult);
            cursos = (ArrayList) is.readObject();
            } 
            
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                
                catch ( ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
    }
     
     
      public static void CriarCurso(){
        Curso novoCurso = new Curso();
        int i;

        System.out.println("------- Criar Curso -------");
        System.out.println("----------------------------------");
        System.out.print("Nome do curso: ");
        novoCurso.setNome(Ler.umaString());
        
       
        
        
        for(i = 0; i<cursos.size();i++){
            if(cursos.get(i).equals(novoCurso)){
                System.out.println("O curso já foi criado anteriormente");
                break;
            }
        }
        if(i == cursos.size()){                                               //Percorreu toda a ArrayList
            cursos.add(novoCurso);
            RegistarCursoFile();
            System.out.println("Curso criado com sucesso");
            System.out.println("    ");            
            System.out.println("O numero atribuido foi: "+ Curso.getUltimo());
        }
        
    }
      
      
      
      public static Curso ProcuraCurso(String x){
        Curso curso;
        try{
                int numero = Integer.parseInt(x);
                curso = PesquisarCurso(numero);
            }
            catch(NumberFormatException e){
                curso = PesquisarCurso(x);
            }
        return curso;
    }
      
      
      public static Curso PesquisarCurso(int numero){
        for(int i = 0; i<cursos.size();i++){
            if(numero == cursos.get(i).getNumCurso())
                return cursos.get(i);        
        }
        return CursoNAOEXISTE();        
    }

    public static Curso PesquisarCurso(String nome){
        for(int i = 0; i<cursos.size();i++){
            if(nome.equals(cursos.get(i).getNome()))
                return cursos.get(i);        
        }
        return CursoNAOEXISTE();        
    }    
    
     public static Curso CursoNAOEXISTE(){
        Curso CursoNAOEXISTE = new Curso();
        CursoNAOEXISTE.setNome("#Erro Curso nao existe");
        return CursoNAOEXISTE;
    }
     
     public static String PesquisarCurso(){
        Curso nv;
        System.out.print("Nome ou numero do Curso: ");
        nv = ProcuraCurso(Ler.umaString());
        
        for (int i = 0; i<cursos.size();i++){
            if(cursos.get(i).equals(nv)){
                System.out.println("O curso existe");
                    System.out.println(cursos.get(i).toString());
                    break;
            }
        }
        return("O curso não existe.");
    }
     
      public static void ListarCursos(){
        if(cursos.isEmpty()){
            System.out.println("Não ha nenhum curso registado.");
        }
        for(int i = 0; i<cursos.size(); i++){
            System.out.println(cursos.get(i).toString());
            
        }
            
    }
    
      
    
       
      
      public static void ListarAlunosCurso(){
       int j;
       Curso curso;
       
        System.out.print("Qual o curso: ");
       do{
            curso = ProcuraCurso(Ler.umaString());
        }while(curso.getNome().equals("#Erro Curso nao existe")); 
       
        for(j=0; j<alunos.size(); j++){
            if ((alunos.get(j).getCurso().getNome()).equals(curso.getNome())){
                System.out.println(alunos.get(j));
           }
        }
               
      } 
      
      
      
    public static void EliminarCurso(){
        Curso nv;
        System.out.print("Nome/Numero do Curso: ");
        nv = ProcuraCurso(Ler.umaString());
        
        for(int i = 0; i<cursos.size(); i++){
            if(cursos.get(i).equals(nv)){
                
                cursos.remove(i);
                System.out.println("Curso Eliminado");
                RegistarCursoFile();
                return;
            }
        }
        System.out.println("O curso não existe");
    }
    
     public static void EliminarTodosCursos(){
        System.out.println("-------ATENÇÃO-------");
        System.out.println("---------------------");
        System.out.println(" Tem a certeza que deseja eliminar TODOS os cursos? (S/N)\n");
        System.out.print("-> ");

        String son = Ler.umaString();
        if (son.equals("s")||son.equals("S"))
            DeleteAll();
        else
            System.out.println("Operação Cancelada");
    }
    
    public static void DeleteAll(){
        cursos.clear();
        System.out.println("Todos os cursos foram eliminados.");
        Curso.setUltimo(0);
        RegistarCursoFile();
    }
    
    
    public static void EditarCurso(){ 
        Curso nv;         
         
        System.out.print("Nome/Numero do curso a modificar: ");
        nv = ProcuraCurso(Ler.umaString());
        
        for(int i=0; i<cursos.size();i++){
            Curso c = cursos.get(i);
            if(c.equals(nv)){        
 
                System.out.print("Novo nome do curso: (" + c.getNome() + "): ");
                c.setNome(Ler.umaString());
               
                
                
                RegistarCursoFile();
       
                System.out.println("Curso modificado com sucesso.");
                return;
            }
        }
        System.out.println("Curso não existe");
    }
}