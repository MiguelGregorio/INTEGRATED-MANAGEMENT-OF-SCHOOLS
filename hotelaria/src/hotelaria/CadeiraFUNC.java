/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;


import static hotelaria.CursoFUNC.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class CadeiraFUNC {
     public static ArrayList<Cadeira>cadeiras = new ArrayList<>();
    
    public static void RegistarCadeiraFile(){
        try{
            ObjectOutputStream os = new ObjectOutputStream
            ( new FileOutputStream ("cadeiras.txt"));
            
        os.writeInt(Cadeira.getUltimo());    
        os.writeObject(cadeiras);
        os.flush();
        
        }            
        catch(IOException e){
            System.out.println("Ocorreu um erro!"+e.getMessage());
        }
    }
    
    
     public static void LerCadeiraFile(){
        try{
            ObjectInputStream is = new ObjectInputStream
            (new FileInputStream("cadeiras.txt"));

            int ult= is.readInt();
            Cadeira.setUltimo(ult);
            cadeiras = (ArrayList) is.readObject();
            } 
            
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                
                catch ( ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
    }
     
    public static Cadeira ProcuraCadeira(String x){
        Cadeira cadeira;
        try{
                int numero = Integer.parseInt(x);
                cadeira = CadeiraFUNC.PesquisarCadeira(numero);
            }
            catch(NumberFormatException e){
                cadeira = CadeiraFUNC.PesquisarCadeira(x);
            }
        return cadeira;
    }
      
      
      public static Cadeira PesquisarCadeira(int numero){
        for(int i = 0; i<cadeiras.size();i++){
            if(numero == cadeiras.get(i).getNumero())
                return cadeiras.get(i);        
        }
        return CadeiraNAOEXISTE();        
    }

    public static Cadeira PesquisarCadeira(String nome){
        for(int i = 0; i<cadeiras.size();i++){
            if(nome.equals(cadeiras.get(i).getNome()))
                return cadeiras.get(i);        
        }
        return CadeiraNAOEXISTE();        
    }    
    
     public static Cadeira CadeiraNAOEXISTE(){
        Cadeira CadeiraNAOEXISTE = new Cadeira();
        CadeiraNAOEXISTE.setNome("#Erro Cadeira nao existe");
        return CadeiraNAOEXISTE;
    }

     
     public static void CriarCadeira(){ 
        Cadeira novaCadeira;
        Curso curso;
        String nome;
        Professor professor;
        
        
        
        System.out.println("------- Criar Cadeira -------");
        System.out.println("----------------------------------");
        System.out.print("Curso onde quer inserir a cadeira: ");
       
        do{
            curso = ProcuraCurso(Ler.umaString());
        }while(curso.getNome().equals("#Erro Curso nao existe"));
        
        
        
            novaCadeira = new Cadeira ();
            System.out.print("Nome da cadeira: ");
            nome=Ler.umaString();
           

            novaCadeira = ProcuraCadeira(nome);
            if(!(novaCadeira.getNome().equals(nome))){
            novaCadeira.setNome(nome);
            novaCadeira.setCurso(curso);
            
            
            System.out.print("Nome do professor: ");
                do{
                    professor = ProfessorFUNC.ProcuraProfessor(Ler.umaString());
                }while(professor.getNome().equals("#Erro professor nao existe"));
            novaCadeira.setProfessor(professor);
                System.out.println("Professor atribuido com sucesso");
            
            cadeiras.add(novaCadeira);
            
            for (int j = 0; j < cursos.size(); j++) {
                if (cursos.get(j).getNome().equals(curso.getNome())){
                   cursos.get(j).adicionarCadeira(novaCadeira);
                    break;
                }}
           
            RegistarCadeiraFile();
            System.out.println("Cadeira criada com sucesso");           
            System.out.println("O numero atribuido à cadeira foi: "+ Cadeira.getUltimo());
            }
        }
     
     
     /*public static void EliminarCadeira(){
        Cadeira nv;
        System.out.print("Nome da cadeira: ");
        do{
            nv = CadeiraFUNC.ProcuraCadeira(Ler.umaString());
        }while(nv.getNome().equals("#Erro professor nao existe"));
        
        for(int i = 0; i<cadeiras.size(); i++){
            if(cadeiras.get(i).getNome().equals(nv)){
                cadeiras.remove(i);
                System.out.println("Cadeira Eliminada");
                RegistarCadeiraFile();
                return;
            }
        }
        System.out.println("A cadeira não existe");
    }*/
    }


        
