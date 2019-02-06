/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelaria;
import java.io.IOException;

/**
 *
 * @author Miguel
 */
public class Hotelaria {

  
    public static void main(String[] args) throws IOException{
        
        AlunoFUNC.LerAlunoFile();
        ProfessorFUNC.LerProfessorFile();
        CursoFUNC.LerCursoFile();
        CadeiraFUNC.LerCadeiraFile();
        HorarioFUNC.LerHorarioFile();
        menus.MenuPrincipal();

    }
    
}
