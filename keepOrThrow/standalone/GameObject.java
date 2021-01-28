public class GameObject extends Object{
    
    public GameObject next;
    protected int wert;
    
    public GameObject (int x) {
        wert = x;
    }

    public void setWert(int u) {
        this.wert = u;
    }
    public int getWert() {
        return this.wert;
    }
}
