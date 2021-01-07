import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(790, 790, 1); 
        System.out.println("-----------------------------------");
        this.setup();
        System.out.println("-----------------------------------");
        Greenfoot.start();
    }
    
    public String turn;
    public Figur f1, f2, f3, f4, a1, a2;
 
    public void setup()
    {
        this.f1 = new Figur("Blau", -2, 2, 1);
        this.f2 = new Figur("Rot", 2, 2, 2);
        this.f3 = new Figur("Blau", 2, -2, 3);
        this.f4 = new Figur("Rot", -2, -2, 4);
        this.a1 = f1;
        this.a2 = f2;
        this.addObject(f1, 0, 0);
        this.addObject(f2, 0, 0);
        this.addObject(f3, 0, 0);
        this.addObject(f4, 0, 0);
        this.f1.position(this.f1.x, this.f1.y);
        this.f2.position(this.f2.x, this.f2.y);
        this.f3.position(this.f3.x, this.f3.y);
        this.f4.position(this.f4.x, this.f4.y);
        
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
        return Greenfoot.getRandomNumber(4)+1;
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
    public void act() {
        
        
        while(!(this.a1.gewonnen() || this.a2.gewonnen())){
            this.druckeAktuellenSpieler();
            this.aktuelleFigurNeu();    
            this.a1.druckePosition();
            this.a2.druckePosition();
            this.druckeSpielfeld();

            System.out.println(this.turn + " zieht. Gebe eine Richtung ein, in die beide Figuren gezogen werden. \n");
            System.out.println("Oben\nRechts\nUnten\nLinks\nEsc zum Beenden");
            String r;
            boolean gehen;
            do{
                
                gehen = true;
                if(Greenfoot.isKeyDown("up")) {
                    this.a1.gehe(0);
                    this.a2.gehe(0);
                } else if(Greenfoot.isKeyDown("right")) {
                    this.a1.gehe(1);
                    this.a2.gehe(1);
                   
                } else if(Greenfoot.isKeyDown("down")) {
                    this.a1.gehe(2);
                    this.a2.gehe(2);
                    
                } else if(Greenfoot.isKeyDown("left")) {
                    this.a1.gehe(3);
                    this.a2.gehe(3);
                    
                } else if(Greenfoot.isKeyDown("esc")) {
                    Greenfoot.stop();
                } else {
                    gehen = false;
                }
            } while (!gehen);

            this.a1.gegangen = false;
            this.a2.gegangen = false;
            this.turn = this.zugWechseln();
            System.out.println("-----------------------------------");
        }
        this.druckeGewinner();
    }
}
