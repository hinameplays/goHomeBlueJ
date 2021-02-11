class Liste<T> {
    Listenelement anfang;
    Listenelement ende;
    int length = getLength();
    
    void anhaengen(T o) {
        Listenelement neuesElement = new Listenelement(o);
        if(anfang == null) {
            anfang = neuesElement;
            ende = neuesElement;
        } else {
            ende.next = neuesElement;
            ende = neuesElement;
        }
        length = getLength();
    }

    T getEnde () {
        // Gib nicht das Listenelement, sondern dessen content zurück
        return ende.content;
    }

    Listenelement get (int i) {
        if(i>length||i<1) {
            return null;
        } else if (i==length) {
            return ende;
        }
        Listenelement a = anfang;
        for (int h = 1; h<i; h++) {
            a = a.next;
        }
        return a;
    }
    
    int getLength () {
        Listenelement a = anfang;
        int i=0;
        while (a!=null) {
            i++;
            a = a.next;
        }
        return i;
    }

    class Listenelement {
        Listenelement next;
        T content;
        
        public Listenelement(T o) {
            content = o;
        }
    }
    
}