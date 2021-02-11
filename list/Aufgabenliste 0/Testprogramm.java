class Testprogramm
{
    public static void testprogramm()
    {
        class Aufgabe {
            String beschreibung;
        
            public Aufgabe(String b) {
                beschreibung = b;
            }
        }

        Liste<Aufgabe> liste = new Liste<Aufgabe>();
        // seit Java 7 auch möglich:
        // Liste<Aufgabe> liste = new Liste<>();
        liste.anhaengen(new Aufgabe("Aufstehen"));
        liste.anhaengen(new Aufgabe("Frühstücken"));
        liste.anhaengen(new Aufgabe("In die Schule gehen"));
        // Typecast ist nicht mehr notwendig
        Aufgabe a = liste.getEnde();
        System.out.println(a.beschreibung);
        // Geht nicht mehr
        // liste.anhaengen(new String());
        System.out.println(liste.length);
        System.out.println(liste.get(1).content.beschreibung);
        System.out.println(liste.get(2).content.beschreibung);
        System.out.println(liste.get(3).content.beschreibung);
        System.out.println(liste.get(4).content.beschreibung);
        System.out.println(liste.get(0).content.beschreibung);
    }

    
    public static void main (String[] a) {
        testprogramm();
    }
}

