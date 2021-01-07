import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Figur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Figur extends Actor
{
    /**
     * Act - do whatever the Figur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int x; // x und y sind momentan überall getauscht; kann man fixen, muss aber nicht
    public int y;
    public String farbe;
    public boolean gegangen = false; //merkt sich, ob die figur in dem zug schon bewegt wurde

    /**
     * Konstruktor für Objekte der Klasse Figur
     */
    public Figur(String farbe, int x0, int y0, int id)
    {
        // Instanzvariable initialisieren
        this.farbe = farbe;
        GreenfootImage f = new GreenfootImage(id+".png");
        f.scale(100, 100);
        this.setImage(f);
        this.x = x0;
        this.y = y0;
        
    }
    
    public void druckePosition(){
        System.out.printf("Farbe: %s, x: %s, y: %s \n", this.farbe, this.x, this.y);
    }
    
    public boolean gewonnen(){
        return (this.x == 0 && this.y == 0) ? true : false;
    }

    public void gehe(int richtung){
        if(!gegangen){
            switch (richtung){
                case 0: 
                    if(this.x>-2)
                        this.x--;
                    else
                        this.x = 2;
                    break;
                case 1: 
                    if(this.y<2)
                        this.y++;
                    else
                        this.y = -2;
                    break;
                case 2:
                    if(this.x<2) 
                        this.x++;
                    else
                        this.x = -2;
                    break;
                      
                case 3:
                    if(this.y>-2)
                        this.y--;
                    else
                        this.y = 2;
                    break;
            }
        }
        this.position(this.x, this.y);
        gegangen = true;
    }
    
    public void position(int x, int y) {
        this.setLocation(x*125+395, y*125+395);
    }
       
}
