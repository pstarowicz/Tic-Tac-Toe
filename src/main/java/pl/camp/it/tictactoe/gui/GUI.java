package pl.camp.it.tictactoe.gui;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class GUI {
    private static boolean player = true;
    private static List<Character> lista = new ArrayList<>();

    private GUI() {
        for(int i=0; i<9; i++){
            lista.add(' ');
        }
    }

    public void showStart(){
        System.out.println(">>KÓŁKO I KRZYŻYK<<");
        System.out.println("Numery pól:");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9 ");
    }

    public void addChar(){
        Scanner scanner = new Scanner(System.in);
        char znak = GUI.player ? 'o' : 'x';
        System.out.println("Podaj numer pola (1-9), aby wstawić \""+ znak +"\":");
        int index = Integer.parseInt(scanner.nextLine())-1;
        if(index<0 || index>8){
            System.out.println("Podano niepoprawny numer pola!");
        }
        else if(!lista.get(index).equals(' ')){
            System.out.println("Pole zostało już wykorzystane!");
        }
        else {
            lista.set(index, znak);
            GUI.player = !GUI.player;
        }
    }

    public boolean checkIfOver(){
        char znak = !GUI.player ? 'o' : 'x';
        boolean cond1 = lista.get(0).equals(lista.get(1)) && lista.get(0).equals(lista.get(2)) && lista.get(0).equals(znak);
        boolean cond2 = lista.get(3).equals(lista.get(4)) && lista.get(3).equals(lista.get(5)) && lista.get(3).equals(znak);
        boolean cond3 = lista.get(6).equals(lista.get(7)) && lista.get(6).equals(lista.get(8)) && lista.get(6).equals(znak);
        boolean cond4 = lista.get(0).equals(lista.get(3)) && lista.get(0).equals(lista.get(6)) && lista.get(0).equals(znak);
        boolean cond5 = lista.get(1).equals(lista.get(4)) && lista.get(1).equals(lista.get(7)) && lista.get(1).equals(znak);
        boolean cond6 = lista.get(2).equals(lista.get(5)) && lista.get(2).equals(lista.get(8)) && lista.get(2).equals(znak);
        boolean cond7 = lista.get(0).equals(lista.get(4)) && lista.get(0).equals(lista.get(8)) && lista.get(0).equals(znak);
        boolean cond8 = lista.get(2).equals(lista.get(4)) && lista.get(2).equals(lista.get(6)) && lista.get(2).equals(znak);
        if(cond1 || cond2 || cond3 || cond4 || cond5 || cond6 || cond7 || cond8){
            System.out.println("Rezultat: wygrana gracza ze znakiem \""+ znak+"\"");
            return false;
        }
        else if(!lista.contains(' ')){
            System.out.println("Rezultat: remis, z powodu braku miejsca na planszy.");
            return false;
        }
        return true;
    }

    public void showGraph(){
        System.out.println(" " + lista.get(0) + " | " + lista.get(1) + " | " + lista.get(2) + " ");
        System.out.println("-----------");
        System.out.println(" " + lista.get(3) + " | " + lista.get(4) + " | " + lista.get(5) + " ");
        System.out.println("-----------");
        System.out.println(" " + lista.get(6) + " | " + lista.get(7) + " | " + lista.get(8) + " ");
    }

}
