//Classe Horario para o trabalho final
package hotelaria;
import java.io.*;
import java.util.*;

public class Horario implements Serializable {
    private int numero;
    private static int ultimo;
    private ArrayList<String> segunda;
    private ArrayList<String> terca;
    private ArrayList<String> quarta;
    private ArrayList<String> quinta;
    private ArrayList<String> sexta;
    /*Cada dia terá 4 blocos de 2h cada
       2 de manha e 2 de tarde*/
    
    public Horario(){
        ultimo++;
        numero=ultimo;
        segunda = new ArrayList<String>();
        terca = new ArrayList<String>();
        quarta = new ArrayList<String>();
        quinta = new ArrayList<String>();
        sexta = new ArrayList<String>();
    }

    public ArrayList<String> getSegunda() {
        return segunda;
    }

    public void setSegunda(ArrayList<String> segunda) {
        this.segunda = segunda;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static void setUltimo(int ultimo) {
        Horario.ultimo = ultimo;
    }

    public int getNumero() {
        return numero;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public ArrayList<String> getTerca() {
        return terca;
    }

    public void setTerca(ArrayList<String> terca) {
        this.terca = terca;
    }

    public ArrayList<String> getQuarta() {
        return quarta;
    }

    public void setQuarta(ArrayList<String> quarta) {
        this.quarta = quarta;
    }

    public ArrayList<String> getQuinta() {
        return quinta;
    }

    public void setQuinta(ArrayList<String> quinta) {
        this.quinta = quinta;
    }

    public ArrayList<String> getSexta() {
        return sexta;
    }

    public void setSexta(ArrayList<String> sexta) {
        this.sexta = sexta;
    }

    @Override
    public String toString() {
        String s = "HORARIO " + /*getNome +*/ "\n"; //acho que é esta a funcao que vai buscar o nome do curso
        String s1 = "Segunda:\n" + "9-11:" + segunda.get(0) + "\n11-13:" + segunda.get(1) + "\n14-16:" + segunda.get(2) + "\n16-18:" + segunda.get(3);
        String s2 = "\n\nTerca:\n" + "9-11:" + terca.get(0) + "\n11-13:" + terca.get(1) + "\n14-16:" + terca.get(2) + "\n16-18:" + terca.get(3);
        String s3 = "\n\nQuarta:\n" + "9-11:" + quarta.get(0) + "\n11-13:" + quarta.get(1) + "\n14-16:" + quarta.get(2) + "\n16-18:" + quarta.get(3);
        String s4 = "\n\nQuinta:\n" + "9-11:" + quinta.get(0) + "\n11-13:" + quinta.get(1) + "\n14-16:" + quinta.get(2) + "\n16-18:" + quinta.get(3);
        String s5 = "\n\nSexta:\n" + "9-11:" + sexta.get(0) + "\n11-13:" + sexta.get(1) + "\n14-16:" + sexta.get(2) + "\n16-18:" + sexta.get(3);
        return (s + s1 + s2 + s3 + s4 + s5) ;
    }

    
    
}
