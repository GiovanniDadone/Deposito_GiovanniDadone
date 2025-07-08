import java.util.ArrayList;
import java.util.List;

public class EsercizioHamburgerDecorator {
    public static void main(String[] args) {
        Hamburger burgerbase = new BaseBurger();

        Hamburger decoratore1 = new FormaggioDecorator(burgerbase);
        Hamburger decoratore2 = new BaconDecorator(decoratore1);

        GestorePrezzi gestore = new GestorePrezzi();
        gestore.registraDecoratore((PrezziObserver) decoratore1);
        gestore.registraDecoratore((PrezziObserver) decoratore2);

        GestoreOrdine.getInstance();
        GestoreOrdine.aggiungiOrdine(decoratore1);
        GestoreOrdine.aggiungiOrdine(decoratore2);
        GestoreOrdine.aggiungiOrdine(burgerbase);

        GestoreOrdine.displayOrdini();

        gestore.setState(0.30, 0.40);

        GestoreOrdine.displayOrdini();
    }
}

// interfaccia che servirà da grande aggregatore di oggetti
interface Hamburger {
    // due metodi che specificano le due variabili di ogni burger
    String getDescrizione();

    double getPrezzo();
}

// classe base da decorare
class BaseBurger implements Hamburger {

    // metodi getter che ritornano valori prefissati
    public String getDescrizione() {
        return "Hamburger base";
    }

    public double getPrezzo() {
        return 4.50;
    }

}

// classe decorator astratta dei decoratori implementati più in giù, molto
// basilare
abstract class DecoratoreAggiunteBurger extends BaseBurger {
    protected Hamburger baseBurger;

    public DecoratoreAggiunteBurger(Hamburger baseBurger) {
        this.baseBurger = baseBurger;
    }
}

// interfaccia per riconoscere che gli observer e cosa vanno a cambiare
// qui avrei potuto usare due metodi per cambaire i corrispettivi prezzi
// differenti
interface PrezziObserver {
    void update(double price1, double price2);
}

// classe subject del pattern observer per cambiare la maggiorazione dei prezzi
// dei decoratori e aggiornare il costo finale dei burger
class GestorePrezzi {
    private List<PrezziObserver> decoratori = new ArrayList<>();
    private double prezzoFormaggio;
    private double prezzoBacon;

    // metodo che aggiorna i valori delle maggiorazioni
    public void setState(double prezzoFormaggio, double prezzoBacon) {
        this.prezzoFormaggio = prezzoFormaggio;
        this.prezzoBacon = prezzoBacon;
        notificaDecoratori(); // metodo che notifica i decoratori
    }

    // classica implementazione del pattern observer dei metodi
    // registra/rimuovi/notifica
    public void registraDecoratore(PrezziObserver o) {
        decoratori.add(o);
    }

    public void rimuoviDecoratore(PrezziObserver o) {
        decoratori.remove(o);
    }

    public void notificaDecoratori() {
        for (PrezziObserver observer : decoratori) {
            observer.update(prezzoFormaggio, prezzoBacon);
        }
    }
}

// decoratore per aggiungere il formaggio come extra e che fa da observer della
// maggiorazione dei prezzi
class FormaggioDecorator extends DecoratoreAggiunteBurger implements PrezziObserver {

    // il valore di stato che viene cambiato a seconda del cambio chiamato sul
    // subject
    private double maggiorazione;

    // costruttore che prende quello super della classe astratta padre
    public FormaggioDecorator(Hamburger baseBurger) {
        super(baseBurger);
    }

    // metodo che prende il baseBurger passato nel costruttore e aggiunge una
    // descrizione
    public String getDescrizione() {
        return baseBurger.getDescrizione() + " con aggiunta di Formaggio";
    }

    // metodo che prende il prezzo del baseBurger e gli applica l'aggiunta di
    // decorazione base più quella aggiornata con il GestorePrezzi
    public double getPrezzo() {
        return baseBurger.getPrezzo() + 0.50 + maggiorazione;
    }

    // override del metodo update come da regola che aggiorna il prezzo a seconda
    // del prezzo corrispondente, in questo caso si prende il valore "price"
    @Override
    public void update(double price, double price2) {
        System.out.println("Prezzi agiornati");
        this.maggiorazione = price;
    }

}

// decoratore per aggiungere il bacon come extra e che fa da observer della
// maggiorazione dei prezzi
class BaconDecorator extends DecoratoreAggiunteBurger implements PrezziObserver {

    // il valore di stato che viene cambiato a seconda del cambio chiamato sul
    // subject
    private double maggiorazione;

    // costruttore che prende quello super della classe astratta padre
    public BaconDecorator(Hamburger baseBurger) {
        super(baseBurger);
    }

    // metodo che prende il baseBurger passato nel costruttore e aggiunge una
    // descrizione
    public String getDescrizione() {
        return baseBurger.getDescrizione() + " con aggiunta di Bacon";
    }

    // metodo che prende il prezzo del baseBurger e gli applica l'aggiunta di
    // decorazione base più quella aggiornata con il GestorePrezzi
    public double getPrezzo() {
        return super.getPrezzo() + 0.80 + maggiorazione;
    }

    // override del metodo update come da regola che aggiorna il prezzo a seconda
    // del prezzo corrispondente, in questo caso si prende il valore "price2"
    @Override
    public void update(double price, double price2) {
        System.out.println("Prezzi agiornati");
        this.maggiorazione = price2;
    }

}

// gestore ordine con pattern singleton
class GestoreOrdine {
    private static ArrayList<Hamburger> listaOrdini = null;

    // costruttore privato vuoto
    private GestoreOrdine() {
    }

    // getInstance per inizializzare l'arrayList, che è sempre una
    public static ArrayList<Hamburger> getInstance() {
        if (listaOrdini == null) {
            listaOrdini = new ArrayList<>();
        }
        return listaOrdini;
    }

    // metodo statico per aggiungere un Hamburger all'ordine
    public static void aggiungiOrdine(Hamburger burger) {
        listaOrdini.add(burger);
    }

    // metodo statico per rimuovere un Hamburger all'ordine
    public static void rimuoviOrdine(Hamburger burger) {
        listaOrdini.remove(burger);
    }


    //metodo per fare la stampa in console di tutti gli ordini
    public static void displayOrdini() {
        for (Hamburger hamburger : listaOrdini) {
            System.out.println(hamburger.getDescrizione() + " " + hamburger.getPrezzo());
        }

        System.out.println("=============================");
    }
}
