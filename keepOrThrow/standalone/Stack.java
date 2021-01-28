/**
 * Library class to implement basic stack functionality myself
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Stack
{
    private GameObject t;
    
    public Boolean isEmpty() {
        return (t==null) ? true : false;
    }

    public GameObject top() {
        return this.t;
    }
    
    public void push(GameObject k) {
        if (!this.isEmpty()) k.next = this.t;
        this.t = k;        
    }
    
    public GameObject pop() {
        if (!this.isEmpty()) {
            GameObject k = this.t;
            this.t = this.t.next;
            k.next = null;
            return k;
        } else {
            return null;
        }
    }
    
    public int getLength() {
        Stack temp = new Stack();
        int i = 0;
        
        while (!this.isEmpty()) {
            GameObject n = this.pop();
            i++;
            temp.push(n);
        }
        while (!temp.isEmpty()) {
            this.push(temp.pop());
        }
        return i;       
    }
}
