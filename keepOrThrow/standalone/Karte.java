import java.util.Random;
/**
 * Beschreiben Sie hier die Klasse Karte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Karte extends GameObject {

    public Karte() {
        // Instanzvariable initialisieren
        super(-1);
        Random r = new Random();
        this.setWert(r.nextInt(10));
    }

	public Karte(int u) {
        super(u);
	}
}
    
