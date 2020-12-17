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
    public Figur() {
        GreenfootImage f = new GreenfootImage("1.png");
        f.scale(100, 100);
        this.setImage(f);
    }
    public void act() 
    {
        
            this.setLocation(this.getX()+120, this.getY());
            this.setLocation(this.getX(), this.getY()+120);
            this.setLocation(this.getX(), this.getY()+120);
            this.setLocation(this.getX()-120, this.getY());
            this.setLocation(this.getX(), this.getY()-120);
        
    }    
}
