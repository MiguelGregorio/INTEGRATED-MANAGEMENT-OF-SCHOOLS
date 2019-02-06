//escrita do horario
package hotelaria;
import static hotelaria.CadeiraFUNC.*;
import static hotelaria.CursoFUNC.*;
import java.io.*;
import java.util.*;

public class HorarioFUNC {
    public static ArrayList<Horario>horarios = new ArrayList<>();
    public static ArrayList<String> l1 = new ArrayList<String>(); //segunda
    public static ArrayList<String> l2 = new ArrayList<String>(); //terca
    public static ArrayList<String> l3 = new ArrayList<String>(); //quarta
    public static ArrayList<String> l4 = new ArrayList<String>(); //quinta
    public static ArrayList<String> l5 = new ArrayList<String>(); //sexta
        
    public static void RegistarHorarioFile(){
        try{
            ObjectOutputStream os = new ObjectOutputStream
            ( new FileOutputStream ("horarios.txt"));
            
        os.writeInt(Horario.getUltimo());    
        os.writeObject(horarios);
        os.flush();
        
        }            
        catch(IOException e){
            System.out.println("Ocorreu um erro!"+e.getMessage());
        }
    }
    
    
     public static void LerHorarioFile(){
        try{
            ObjectInputStream is = new ObjectInputStream
            (new FileInputStream("horarios.txt"));

            int ult= is.readInt();
            Horario.setUltimo(ult);
            horarios = (ArrayList) is.readObject();
            } 
            
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                
                catch ( ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
    }
    
    public static void CriarHorario(){
        Horario h1 = new Horario();
        Curso curso;
        String entrada;
        int t = cadeiras.size();
        System.out.print("Curso: ");
        do{
            curso = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(curso.getNome().equals("#Erro Curso nao existe"));
        System.out.println("Começar a inserir horário:");
        for(int j = 0; j<5; j++){
            //controla os dias da semana
            for(int i = 0; i<4; i++){
                //controla as horas
                if(j == 0){
                    if(i==0){
                        System.out.println("Segunda das 9-11: ");
                        entrada = Ler.umaString();
                        l1.add(entrada);
                    }
                    if(i==1){
                        System.out.println("Segunda das 11-13: ");
                        entrada = Ler.umaString();
                        l1.add(entrada);
                    }
                    if(i==2){
                        System.out.println("Segunda das 14-16: ");
                        entrada = Ler.umaString();
                        l1.add(entrada);
                    }
                    if(i==3){
                        System.out.println("Segunda das 16-18: ");
                        entrada = Ler.umaString();
                        l1.add(entrada);
                    }
                }
                 if(j == 1){
                    if(i==0){
                        System.out.println("Terca das 9-11: ");
                        entrada = Ler.umaString();
                        l2.add(entrada);
                    }
                    if(i==1){
                        System.out.println("Terca das 11-13: ");
                        entrada = Ler.umaString();
                        l2.add(entrada);
                    }
                    if(i==2){
                        System.out.println("Terca das 14-16: ");
                        entrada = Ler.umaString();
                        l2.add(entrada);
                    }
                    if(i==3){
                        System.out.println("Terca das 16-18: ");
                        entrada = Ler.umaString();
                        l2.add(entrada);
                    }
                 }
                if(j == 2){
                    
                    if(i==0){
                        System.out.println("Quarta das 9-11: ");
                        entrada = Ler.umaString();
                        l3.add(entrada);
                    }
                    if(i==1){
                        System.out.println("Quarta das 11-13: ");
                        entrada = Ler.umaString();
                        l3.add(entrada);
                    }
                    if(i==2){
                        System.out.println("Quarta das 14-16: ");
                        entrada = Ler.umaString();
                        l3.add(entrada);
                    }
                    if(i==3){
                        System.out.println("Quarta das 16-18: ");
                        entrada = Ler.umaString();
                        l3.add(entrada);
                    }
                }
                if(j == 3){
                    if(i==0){
                        System.out.println("Quinta das 9-11: ");
                        entrada = Ler.umaString();
                        l4.add(entrada);
                    }
                
                    if(i==1){
                        System.out.println("Quinta das 11-13: ");
                        entrada = Ler.umaString();
                        l4.add(entrada);
                    }
                    if(i==2){
                        System.out.println("Quinta das 14-16: ");
                        entrada = Ler.umaString();
                        l4.add(entrada);
                    }
                    if(i==3){
                        System.out.println("Quinta das 16-18: ");
                        entrada = Ler.umaString();
                        l4.add(entrada);
                    }
                }
                
                if(j == 4){
                    
                    if(i==0){
                        System.out.println("Sexta das 9-11: ");
                        entrada = Ler.umaString();
                        l5.add(entrada);
                    }
                    if(i==1){
                        System.out.println("Sexta das 11-13: ");
                        entrada = Ler.umaString();
                        l5.add(entrada);
                    }
                    if(i==2){
                        System.out.println("Sexta das 14-16: ");
                        entrada = Ler.umaString();
                        l5.add(entrada);
                    }
                    if(i==3){
                        System.out.println("Sexta das 16-18: ");
                        entrada = Ler.umaString();
                        l5.add(entrada);
                    }
                }
            }               
        }
        h1.setSegunda(l1);
        h1.setTerca(l2);
        h1.setQuarta(l3);
        h1.setQuinta(l4);
        h1.setSexta(l5);
        horarios.add(h1);
        for (int j = 0; j < cursos.size(); j++) {
            if (cursos.get(j).getNome().equals(curso.getNome())){
                cursos.get(j).adicionarHorario(h1);
                break;
            }
        }
        RegistarHorarioFile();
        System.out.println(h1.toString());
        
    }
    
    public static void ProcurarHorario(){
        Curso c;
        ArrayList <Horario> h;
        System.out.print("Curso: ");
        do{
            c = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(c.getNome().equals("#Erro Curso nao existe"));
        for (int j = 0; j < cursos.size(); j++) {
            if (cursos.get(j).getNome().equals(c.getNome())){
                h = c.getHorarios();
                System.out.println(h);
                break;
            }
        }
    }
    
    
    
    
    
    public static void EliminarHorario(){
        Curso c;
        System.out.print("Curso: ");
        do{
            c = CursoFUNC.ProcuraCurso(Ler.umaString());
        }while(c.getNome().equals("#Erro Curso nao existe"));
        for (int j = 0; j < cursos.size(); j++) {
            if (cursos.get(j).getNome().equals(c.getNome())){
                cursos.get(j).setHorarios(null);
                System.out.println("Horario Eliminado");
                RegistarHorarioFile();
                return;
            }
        }
         System.out.println("O horario não existe");
    }
        
        
}        
        
        
        
        
        
        
      