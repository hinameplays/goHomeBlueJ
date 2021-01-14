
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    Stapel g = new Stapel(), k= new Stapel(), w = new Stapel();
    
    public Spiel() {
        System.out.println("Hi, ich will ein Spiel spielen!");
        
        for (int i = 0; i<10; i++) {
            g.push(new Karte());
        }
    }

    public void betrachteNaechsteKarte() {
        if (this.g.isEmpty()) {
            System.out.println("Der Ziehstapel ist leer, das Spiel ist vorbei");
        } else {
            System.out.println(this.g.top().getWert());
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
            k.push(c);
            System.out.println("Karte wurde auf Throw geworfen");
        } else {
            System.out.println("Der Ziehstapel ist leer, das Spiel ist vorbei");
        }
    }
    
    public void auswerten() {
        
    }
}
