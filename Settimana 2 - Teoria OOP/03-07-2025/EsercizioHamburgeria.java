import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHamburgeria {
    public static void main(String[] args) {

        // instanziazione di un oggetto Hamburgeria
        Hamburgeria loZozzoneDeNoartri = new Hamburgeria();

        // apertura di uno scanner per gli input degli Integer
        Scanner scannerInt = new Scanner(System.in);

        while (true) {

            // metodo che stampa in console il menù principale
            loZozzoneDeNoartri.displayMenuPrincipale();

            // raccolta dell'input dall'utente
            int sceltaMenù = scannerInt.nextInt();

            // gestione di uscita dal loop con un semplice break, altrimenti richiama il
            // metodo dell'hamburgheria per ordinare un hamburgeria
            if (sceltaMenù == 2) {
                break;
            } else {
                // il metodo accetta scanner come parametro e gli passo quello aperto prima
                loZozzoneDeNoartri.ordinaHamburger(scannerInt);
            }
        }

        // metodo del'hamburgeria per stampare lo scontrino
        loZozzoneDeNoartri.stampaScontrino();
    }
}

class Hamburgeria {

    // array di Hamburger che userò per immagazzinare gli ordini senza getter o
    // setter per tenerlo totalmente privato e accessibile solo ai metodi della
    // classe
    private ArrayList<Hamburger> listaOrdini = new ArrayList<>();

    // metodo che printo il menù
    public void displayMenuPrincipale() {
        System.out.println("""
                Scegli cosa vuoi fare:
                1. Ordina hamburger
                2. Stampa lo scontrino
                    """);
    }

    // stampa di tutti gli ordini iterando nella listaOrdini
    public void stampaScontrino() {
        System.out.println("========= SCONTRINO =======");
        for (Hamburger hamburger : listaOrdini) {
            System.out.println("Tipo di Hamburger: " + hamburger.getNome());
        }
    }

    // aggiunge un hamburger alla lista ordini
    public void ordinaHamburger(Scanner scannerInt) {
        while (true) {

            // print in console della lista dei panini e di come completare l'ordine
            displayBurgerMenu();

            // raccolta dell'input per quale tipo di panino aggiungere all'ordine
            int scelta = scannerInt.nextInt();

            // il metodo aggiungiPanino ritorna un oggetto Hamburger a seconda dell'input di
            // scelta
            Hamburger panino = aggiungiPanino(scelta);

            // se l'input equivale a 4 si esce direttamente dal loop
            if (scelta == 4) {
                break;
            }

            // se non si esce dal loop, si aggiunge il panino, anche se ritorna nullo viene
            // gestito dal metodo aggiungiAllOrdine
            aggiungiAllOrdine(panino);
        }
    }

    // se l'oggetto Hamburger passato come parametro non è nullo viene aggiunto agli
    // ordini altrimenti semplicemente non succede nulla
    private void aggiungiAllOrdine(Hamburger panino) {
        if (panino != null) {
            listaOrdini.add(panino);
            System.out.println("Panino aggiunto");
            System.out.println("==================================");
        }
    }

    // display menù delle scelte a livello di Hamburger e come chiudere l'ordine. da
    // notare che solo il numero 4 come input chiude il loop, qualsiasi altro numero
    // esita un paninoi nullo che non viene aggiunto
    private void displayBurgerMenu() {
        System.out.println("""
                Che panino vuoi ordinare?
                1. Cheeseburger
                2. Veg Burger
                3. Double Bacon burger
                4. Fine ordine
                Inserisci il numero corrispondente:""");
    }

    // metodo che ritorna un oggetto Hamburger differente a seconda della scelta
    // passata come parametro, la scelta 4 printa il completamento dell'ordine
    // mentre qualsiasi altro numero esita la scelta non valida
    public Hamburger aggiungiPanino(int scelta) {
        Hamburger panino = null;
        switch (scelta) {
            // i nomi degli hamburger sono volutamente hardcodati
            case 1:
                panino = new Cheeseburger("Cheeseburger");
                break;
            case 2:
                panino = new Vegburger("Veggie Burger");
                break;
            case 3:
                panino = new DoubleBacon("Double Bacon Burger");
                break;
            case 4:
                System.out.println("Ordine completato!");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
        return panino;
    }
}

class Hamburger {
    private String nome;

    public Hamburger(String nome) {
        this.nome = nome;
    }

    // metodo base che per struttura del codice non viene mai chiamato quindi ho
    // pensato all'inizio di gestirlo come print di errore
    public void prepara() {
        System.out.println("Metodo di Hamburger, c'è qualcquadra che non cosa");
    }

    public String getNome() {
        return nome;
    }

}

class Cheeseburger extends Hamburger {

    public Cheeseburger(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {

        System.out.println("Pane, carne, formaggio, ketchup");
    }

}

class Vegburger extends Hamburger {

    public Vegburger(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        System.out.println("Pane integrale, burger vegetale, insalata, pomodoro");
    }

}

class DoubleBacon extends Hamburger {

    public DoubleBacon(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        System.out.println("Pane, doppia carne, cheddar, maionese");
    }

}
