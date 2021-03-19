package game;

import java.io.Closeable;
import java.io.FileWriter;
import java.util.Scanner;

import game.lib_custom.json.JSONArray;
import game.lib_custom.json.JSONObject;
import game.lib_custom.json.JSONWriter;

public class Spiel {
    Ort start, ziel;
    Ort[] Orte;
    Spieler s;
    static final String dataPath = "data.json";
    static Boolean closeable;
    

    public Spiel() {

        Ort[] temp = { new Ort("No1", "b", false, true, 1), new Ort("No2", "B", true, false, 2) }; //initialiser-declaration umgehen
        Orte = temp;


        Orte[0].baueWeg("oben", Orte[1]);
        start = Orte[0];
        ziel = Orte[1];

        this.save();

        s = new Spieler(start);
        closeable = false;


    }

    public void spielen() {
        Scanner sc = new Scanner(System.in);
        while (s.ort != ziel) {
            System.out.println("Du befindest dich hier: " + s.ort.name);
            System.out.println("Wohin möchtest du gehen?");
            while (!s.gehe(sc.next())) {
                System.out.println("Ungültige Eingabe, bitte wiederholen.");
            }
        }
        System.out.println("Gz; du bist am Ziel!");
        sc.close();
    }

    public static void rebuild() {

        ortBuild();
    }

    public static void ortBuild() {

    }

    public void save() {
        try {
            FileWriter w = new FileWriter(dataPath);
            JSONWriter j = new JSONWriter(w);

            JSONArray locations = new JSONArray();

            for (Ort o: Orte) {
                JSONObject temp = new JSONObject(o);
                temp.put("name", o.name);
                temp.put("beschreibung", o.beschreibung);
                temp.put("l", (o.l != null ? o.l.id : null));
                temp.put("r", (o.r != null ? o.r.id : null));
                temp.put("o", (o.o != null ? o.o.id : null));
                temp.put("u", (o.u != null ? o.u.id : null));
                temp.put("isStart", o.isStart);
                temp.put("isGoal", o.isGoal);
                Object[] t = {o.Item1, o.Item2, o.Item3};
                temp.put("items", new JSONArray(t));

                locations.put(temp);
            }

            locations.write(w);
            
            closeable = true;
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
            e.printStackTrace();
            closeable = false;
        }
        
    }
}
