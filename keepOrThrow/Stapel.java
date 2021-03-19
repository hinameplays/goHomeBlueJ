
/**
 * Beschreiben Sie hier die Klasse Stapel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stapel
{
    private Karte t;
    
    public Boolean isEmpty() {
        return (t==null) ? true : false;
    }

    public Karte top() {
        return this.t;
    }
    
    public void push(Karte k) {
        if (!this.isEmpty()) k.next = this.t;
        this.t = k;        
    }
    
    public Karte pop() {
        Karte k = this.t;
        this.t = this.t.next;
        k.next = null;
        return k;
    }
}
