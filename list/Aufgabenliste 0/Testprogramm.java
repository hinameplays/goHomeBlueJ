class Testprogramm
{
    public static void testprogramm()
    {
        // Aufgabe in testprogramm definiert, da sonst unnötig
        class Aufgabe {
            String beschreibung;
        
            public Aufgabe(String b) {
                beschreibung = b;
            }
        }

        Liste<Aufgabe> liste = new Liste<Aufgabe>();
        // seit Java 7 auch möglich:
        // Liste<Aufgabe> liste = new Liste<>();
        liste.add(new Aufgabe("Aufstehen"));
        liste.add(new Aufgabe("Frühstücken"));
        liste.add(new Aufgabe("In die Schule gehen"));
        // Typecast ist nicht mehr notwendig; letztes Element ausgeben
        Aufgabe a = liste.getEndeContent();
        System.out.println(a.beschreibung);
        // Geht nicht mehr
        // liste.anhaengen(new String());
        System.out.println(liste.length);
        System.out.println(liste.get(1).content.beschreibung);
        System.out.println(liste.get(2).content.beschreibung);
        System.out.println(liste.get(3).content.beschreibung);
        //System.out.println(liste.get(4).content.beschreibung);
        //System.out.println(liste.get(0).content.beschreibung);
        System.out.println(liste.getPosition(liste.get(3)));
        liste.remove(liste.get(2));
        System.out.println(liste.get(2).content.beschreibung);
    }

    
    public static void main (String[] a) {
        testprogramm();
    }
}

