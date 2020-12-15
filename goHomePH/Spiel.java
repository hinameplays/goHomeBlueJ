import java.util.Scanner;
import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    public String turn;
    public Figur f1, f2, f3, f4, a1, a2;
    
    /**
     * Konstruktor für Objekte der Klasse Spiel
     */
    public Spiel()
    {
        
        this.f1 = new Figur("Blau", -2, 2);
        this.f2 = new Figur("Rot", 2, 2);
        this.f3 = new Figur("Blau", 2, -2);
        this.f4 = new Figur("Rot", -2, -2);
        this.a1 = f1;
        this.a2 = f2;
        
        int i = draw(), j = draw();
        
        while (i==j){
            System.out.println("Rot würfelt eine "+ i);
            System.out.println("Blau würfelt eine "+ j);
            i = draw();
            j = draw();
            System.out.println("Neu würfeln!");
        }
        if(i<j){
            System.out.println("Rot würfelt eine "+ i);
            System.out.println("Blau würfelt eine "+ j);
            System.out.println("Blau beginnt");
            turn = "Blau";
        } else {
            System.out.println("Rot würfelt eine "+ i);
            System.out.println("Blau würfelt eine "+ j);
            System.out.println("Rot beginnt");
            turn = "Rot";
        }
    }
    
    public static int draw() {
        Random r = new Random();
        return r.nextInt(4);
    }
    
    public void druckeSpielfeld() {
        String[][] Field = {{"|", "|", "|", "|", "|"}, 
                            {"|", "|", "|", "|", "|"},
                            {"|", "|", "|", "|", "|"},
                            {"|", "|", "|", "|", "|"},
                            {"|", "|", "|", "|", "|"}};
        
        if ((f1 == a1) || (f1 == a2)) {
            Field[f1.x+2][f1.y+2] += ((f1.farbe == "Rot") ? " R ":" B ");
        } else {
            Field[f1.x+2][f1.y+2] += ((f1.farbe == "Rot") ? " r ":" b ");
        }
        if ((f2 == a1) || (f2 == a2)) {
            Field[f2.x+2][f2.y+2] += ((f2.farbe == "Rot") ? " R ":" B ");
        } else {
            Field[f2.x+2][f2.y+2] += ((f2.farbe == "Rot") ? " r ":" b ");
        }
        if ((f3 == a1) || (f3 == a2)) {
            Field[f3.x+2][f3.y+2] += ((f3.farbe == "Rot") ? " R ":" B ");
        } else {
            Field[f3.x+2][f3.y+2] += ((f3.farbe == "Rot") ? " r ":" b ");
        }
        if ((f4 == a1) || (f4 == a2)) {
            Field[f4.x+2][f4.y+2] += ((f4.farbe == "Rot") ? " R ":" B ");
        } else {
            Field[f4.x+2][f4.y+2] += ((f4.farbe == "Rot") ? " r ":" b ");
        }
        
        for (int x = 0; x<5; x++) {
            for (int y = 0; y<5; y++) {
                Field[x][y] = ((Field[x][y] == "|") ? Field[x][y]+"   |==":Field[x][y]+"|==");
            }
        }
         
        Field[2][2] = "|HOME|=";
        
        System.out.println("-----------------------------------");
        for (int i = 0; i <5; i++) {
            System.out.println(Field[i][0]+Field[i][1]+Field[i][2]+Field[i][3]+Field[i][4]);
            System.out.println("-----------------------------------");
        }
    }
    
    public void druckeGewinner() {
        if(f1.x == 0 && f1.y == 0) {
            System.out.println("Gewonnen hat: "+f1.farbe);
        } else if(f2.x == 0 && f2.y == 0) {
            System.out.println("Gewonnen hat: "+f2.farbe);
        } else if(f3.x == 0 && f3.y == 0) {
            System.out.println("Gewonnen hat: "+f3.farbe);
        } else if(f4.x == 0 && f4.y == 0) {
            System.out.println("Gewonnen hat: "+f4.farbe);
        } else {
            return;
        }
        System.exit(0);
    }
    public void druckeAktuellenSpieler() {
        if(turn != null) {
            System.out.println("An der Reihe ist "+turn);
            System.out.println("--------------------------------------------");
        }
    }
    
    public void aktuelleFigurNeu(){
        int neu = draw();
        if(neu == 1)
            a1 = f1;
        else if(neu == 2)
            a1 = f2;
        else if(neu == 3)
            a1 = f3;
        else 
            a1 = f4;
        neu = draw();
        if(neu == 1) 
            a2 = f1;
        else if(neu == 2) 
            a2 = f2;
        else if(neu == 3) 
            a2 = f3;
        else 
            a2 = f4;
        
    }
    public String zugWechseln(){
        return (turn.equals("Blau")) ? "Rot" : "Blau";
    }
    public static void main(String[] args) {
        Spiel s = new Spiel();
        Scanner l = new Scanner(System.in);
        System.out.println("-----------------------------------");

        while(!(s.a1.gewonnen() || s.a2.gewonnen())){
            s.druckeAktuellenSpieler();
            s.aktuelleFigurNeu();    
            s.a1.druckePosition();
            s.a2.druckePosition();
            s.druckeSpielfeld();

            System.out.println(s.turn + " zieht. Gebe eine Richtung ein, in die beide Figuren gezogen werden. \n");
            System.out.println("Oben\nRechts\nUnten\nLinks\nExit zum Beenden");
            String r;
            boolean gehen;
            do{
                r = l.next();
                gehen = true;
                switch(r){
                    case "Oben":
                    case "oben":
                        s.a1.gehe(0);
                        s.a2.gehe(0);
                        break;
                    case "Rechts":
                    case "rechts":
                        s.a1.gehe(1);
                        s.a2.gehe(1);
                        break;
                    case "Unten":
                    case "unten":
                        s.a1.gehe(2);
                        s.a2.gehe(2);
                        break;
                    case "Links":
                    case "links":
                        s.a1.gehe(3);
                        s.a2.gehe(3);
                        break;
                    case "exit":
                    case "Exit":
                        System.exit(0);
                    default:
                        System.out.println("Eingabe nicht erkannt, bitte nochmal");
                        gehen = false;
                }
            } while (!gehen);

            s.a1.gegangen = false;
            s.a2.gegangen = false;
            s.turn = s.zugWechseln();
            System.out.println("-----------------------------------");
        }
        s.druckeGewinner();
    }
        
}
