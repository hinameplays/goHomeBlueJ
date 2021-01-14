import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Karte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Karte
{
    private int wert;
    public Karte next;
    public Karte() {
        // Instanzvariable initialisieren
        Random r = new Random();
        this.wert = r.nextInt(10);
    }
    
    public Karte (int x) {
        this.wert = x;
    }
    
    public int getWert() {
        return this.wert;
    }
}
