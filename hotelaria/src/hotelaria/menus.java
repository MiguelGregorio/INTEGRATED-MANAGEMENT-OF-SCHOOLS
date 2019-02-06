
package hotelaria;
import java.io.*;

public class menus {
    public static void MenuPrincipal() throws IOException{
        
    int m;
    
    do{
     System.out.println("\n");
      
            System.out.println("------------------------------------");
            System.out.println("------- Escola de Hotelaria---------");
            System.out.println("------------------------------------");
            System.out.println("------------------------------------");
            System.out.println("---------- Menu Principal ----------");
            System.out.println("------------------------------------");
            System.out.println("    1 - Aluno");
            System.out.println("    2 - Professor");
            System.out.println("    3 - Curso");
            System.out.println("    4 - Estatísticas");
            System.out.println("");
            System.out.println("    0 - sair");
            System.out.print("-> ");
    
    
            try{
                m = Ler.umInt();
                
                switch(m){
                    case 1:
                       MenuAluno();
                        break;
                    case 2:
                        MenuProfessor();
                        break;
                    case 3:
                        MenuCurso();
                        break;
                    case 4:
                        MenuEstatistica();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        continue;
                    }
            }
            
            catch (Exception e){
                System.out.println("Seleção Errada. Tente novamente.");
            }
    }
while(true);
            
    }
    

    public static void MenuAluno() throws IOException{
    int m;
    
        do{
    
            System.out.println("---------- ALUNOS ----------");
            System.out.println("------------------------------");
            System.out.println("    1 - Criar aluno");
            System.out.println("    2 - Pesquisar Aluno");
            System.out.println("    3 - Listar Alunos");
            System.out.println("    4 - Eliminar Aluno");
            System.out.println("    5 - Eliminar todos os Alunos");
            System.out.println("    6 - Editar Aluno");
            System.out.println("");
            System.out.println("    0 - Voltar atrás");
            System.out.print("-> ");
            
            try{
                m = Ler.umInt();
            
                switch(m){
                   case 1:
                       AlunoFUNC.RegistarAluno();
                       Esperar();
                        break;
                    case 2:
                       AlunoFUNC.PesquisarAluno();
                       Esperar();
                        break;
                    case 3:
                        AlunoFUNC.ListarAlunos();
                        Esperar();
                        break;
                    case 4:
                        AlunoFUNC.EliminarAluno();
                        Esperar();
                        break;
                    case 5:
                        AlunoFUNC.EliminarTodosAlunos();
                        Esperar();
                        break;
                    case 6:
                        AlunoFUNC.EditarAluno();
                        Esperar();
                        break;
                    case 0:
                        MenuPrincipal();
                        break;
                    default:
                        System.out.println("Seleção Errada. Tente novamente.");
                }
            }
            catch (Exception e){
                break;
            }
    }
        while(true);
    }
    
    
     public static void MenuProfessor() throws IOException{
    int m;
    
        do{
    
            System.out.println("---------- PROFESSORES ----------");
            System.out.println("------------------------------");
            System.out.println("    1 - Criar professor");
            System.out.println("    2 - Pesquisar professor");
            System.out.println("    3 - Listar professores");
            System.out.println("    4 - Eliminar professor");
            System.out.println("    5 - Eliminar todos os professores");
            System.out.println("    6 - Editar professor");
            System.out.println("    7 - Inserir nota de um aluno");
            System.out.println("");
            System.out.println("    0 - Voltar atrás");
            System.out.print("-> ");
            
            try{
                m = Ler.umInt();
            
                switch(m){
                   case 1:
                       ProfessorFUNC.RegistarProfessor();
                       Esperar();
                        break;
                    case 2:
                       ProfessorFUNC.PesquisarProfessor();
                       Esperar();
                        break;
                    case 3:
                        ProfessorFUNC.ListarProfessores();
                        Esperar();
                        break;
                    case 4:
                        ProfessorFUNC.EliminarProfessor();
                        Esperar();
                        break;
                    case 5:
                        ProfessorFUNC.EliminarTodosProfessor();
                        Esperar();
                        break;
                    case 6:
                        ProfessorFUNC.EditarProfessor();
                        Esperar();
                        break;
                    case 7:
                        ProfessorFUNC.InserirNota();
                        Esperar();
                        break;    
                    case 0:
                        MenuPrincipal();
                        break;
                    default:
                        System.out.println("Seleção Errada. Tente novamente.");
                }
            }
            catch (Exception e){
                break;
            }
    }
        while(true);
    }
     
public static void MenuCurso() throws IOException{
    int m;
    
        do{
    
            System.out.println("---------- CURSOS ----------");
            System.out.println("------------------------------");
            System.out.println("    1 - Criar curso");
            System.out.println("    2 - Pesquisar curso");
            System.out.println("    3 - Listar cursos");
            System.out.println("    4 - Eliminar curso");
            System.out.println("    5 - Eliminar todos os cursos");
            System.out.println("    6 - Editar curso");
            System.out.println("---------CADEIRAS---------------");
            System.out.println("    7 - Criar cadeira ");
            System.out.println("    9 - Listar alunos por curso ");
            System.out.println("---------HORÁRIO-----------------");
            System.out.println("    10 - Criar horário ");
            System.out.println("    11 - Procurar horário ");
            System.out.println("    12 - Eliminar horário");
            System.out.println("");
            System.out.println("    0 - Voltar atrás");
            System.out.print("-> ");
            
            try{
                m = Ler.umInt();
            
                switch(m){
                   case 1:
                       CursoFUNC.CriarCurso();
                       Esperar();
                        break;
                    case 2:
                        CursoFUNC.PesquisarCurso();
                        Esperar();
                        break;
                    case 3:
                        CursoFUNC.ListarCursos();
                        Esperar();
                        break;
                    case 4:
                        CursoFUNC.EliminarCurso();
                        Esperar();
                        break;
                    case 5:
                        CursoFUNC.EliminarTodosCursos();
                        Esperar();
                        break;
                    case 6:
                        CursoFUNC.EditarCurso();
                        Esperar();
                        break;
                    case 7:
                        CadeiraFUNC.CriarCadeira();
                        Esperar();
                        break;
                    
                    case 9:
                        CursoFUNC.ListarAlunosCurso();
                        Esperar();
                        break;
                    case 10:
                        HorarioFUNC.CriarHorario();
                        Esperar();
                        break;
                    case 11:
                        HorarioFUNC.ProcurarHorario();
                        Esperar();
                        break;
                    case 12 :
                        HorarioFUNC.EliminarHorario();
                        Esperar();
                        break;
                    case 0:
                        MenuPrincipal();
                        break;
                    default:
                        System.out.println("Seleção Errada. Tente novamente.");
                }
            }
            catch (Exception e){
                break;
            }
    }
        while(true);
    }


 public static void MenuEstatistica() throws IOException{
    int m;
    
        do{
    
            System.out.println("---------- ESTATISTICAS ----------");
            System.out.println("------------------------------");
            System.out.println("    1 - Melhor aluno do Curso");
            System.out.println("    2 - Numero de alunos por curso");
            System.out.println("");
            System.out.println("    0 - Voltar atrás");
            System.out.print("-> ");
            
            try{
                m = Ler.umInt();
            
                switch(m){
                   case 1:
                       Estatísticas.MelhorAlunoCurso();
                       Esperar();
                        break;
                    case 2:
                       Estatísticas.NumeroAlunos();
                       Esperar();
                        break;    
                    case 0:
                        MenuPrincipal();
                        break;
                    default:
                        System.out.println("Seleção Errada. Tente novamente.");
                }
            }
            catch (Exception e){
                break;
            }
    }
        while(true);
    }
     
     
     
     
    public static void Esperar(){
        try{
            System.in.read();
        } catch (IOException e) {
        }
    }
}
              
        

    
               
            

            
