import java.util.ArrayList;

public class Officina {

    // varibile di campo della classe un arrayList dove immagazionare gli oggetti
    // auto dell'officina
    ArrayList<Auto> listaAuto = new ArrayList<>();

    // metodo per l'aggiunta di una nuova auto nell'arrayList tramite due parametri
    // poi passati nel costruttore della classe Auto
    void aggiungiAuto(String targa, String modello) {
        Auto newAuto = new Auto(); // creazione oggetto senza i parametri inizializzati
        newAuto.setTarga(targa); // set della targa
        newAuto.setModello(modello); // set del modello
        listaAuto.add(newAuto); // aggiunta dell'oggetto all'arrayList di oggetti Auto
    }

    // semplice stampa di ogni elemento dell'arrayList "listaAuto"
    void visualizzaListaMacchine() {
        for (Auto auto : listaAuto) {
            System.out.println("Targa auto: " + auto.getTarga());
            System.out.println("Modello auto: " + auto.getModello());
            System.out.println("------------------------------");
        }
    }

}

class Auto {

    // dichiarazione delle variabili della classe private
    private String targa;
    private String modello;

    // costruttore senza argomenti per gestire meglio la creazione nel metodo di
    // aggiunta oggetto auto nella classe Officina
    public Auto() {

    }

    // getter e setter
    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

}
