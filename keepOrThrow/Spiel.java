import java.util.Scanner;
import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
class Game {
    Stapel g = new Stapel(), k= new Stapel(), w = new Stapel();
    
    
    public Game() {
        System.out.println("Hi, ich will ein Spiel spielen!");
        int [] z = {1,2,3,4,5,6,7,8,9,10};
        int index, temp;
        Random r = new Random();
        
        for (int i=z.length-1; i>0; i--) {
            index = r.nextInt(i+1);
            temp = z[index];
            z[index] = z[i];
            z[i] = temp;            
        }
        for (int u : z) {
            g.push(new Karte(u));
        }
    }

    public void betrachteNaechsteKarte() {
        if (this.g.isEmpty()) {
            System.out.println("Der Ziehstapel ist leer, das Spiel ist vorbei");
        } else {
            System.out.println("Aktuelle Karte: "+this.g.top().getWert());
            System.out.println("Es sind noch "+g.getLength()+" Karten auf dem Stapel.");
        }
    }
    
    public void behalten() {
        if(!this.g.isEmpty()) {
            Karte c = g.pop();
            if(this.k.isEmpty()||this.k.top().getWert()>c.getWert()) {
                k.push(c);
                System.out.println("Karte wurde auf Keep gelegt");
            } else {
                this.g.push(c);
                System.out.println("Karte kann nicht auf Keep, sie liegt noch immer auf dem Ziehstapel");
            }
        } else {
            System.out.println("Der Ziehstapel ist leer, das Spiel ist vorbei");
        }
    }
    
    public void wegwerfen() {
        if(!this.g.isEmpty()) {
            Karte c = g.pop();
            w.push(c);
            System.out.println("Karte wurde auf Throw geworfen");
        } else {
            System.out.println("Der Ziehstapel ist leer, das Spiel ist vorbei");
        }
    }
    
    public void auswerten() {
        Stapel temp = new Stapel();
        int i = 0;
        
        while (!k.isEmpty()) {
            Karte n = k.pop();
            System.out.println("Karte N° "+ String.valueOf(i+1) +" auf keep-Stapel: "+n.getWert());
            i++;
            temp.push(n);
        }
        
        System.out.println("Insgesamte Kartenanzahl auf keep: "+i);
        while (!temp.isEmpty()) {
            k.push(temp.pop());
        }
    }
}    
    
public class Spiel {    
    private int spielen() {
        try {
            Game S = new Game();
            Scanner c = new Scanner(System.in);
            System.out.println("Die Stapel sind bereit, letse go!");
            System.out.println("Um eine Karte zu behalten, wählen sie bitte die 1.\nUm eine Karte wegzuwerfen drücken sie bitte die 2.");
            while (!S.g.isEmpty()) {
                S.betrachteNaechsteKarte();
                int r = c.nextInt();
                if (r == 1) {
                    S.behalten();
                } else if (r == 2) {
                    S.wegwerfen();
                }
            }
            S.auswerten();
            System.out.println("Spiel vorbei.\n---------------------------------------------------");
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return -69420;
        }
    }
    
    public Spiel () {
        System.out.println("Program exited with: "+spielen());
    }
}

