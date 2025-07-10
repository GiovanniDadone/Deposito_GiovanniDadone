import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioBorsaMedio {
    public static void main(String[] args) {

        // inzializzazione scanner
        Scanner doubleScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        // inizializzazione getInstance() alrtimenti sia l'istance che il metodo sono
        // null
        AgenziaBorsa.getInstance();

        // aggiunta di due investitori random
        AgenziaBorsa.aggiungiInvestitore(new InvestitoreBancario("Paolo"));
        AgenziaBorsa.aggiungiInvestitore(new InvestitorePrivato("Carlo"));

        // menu while che cicla per 3 volte per provare che gli observers investitori
        // vengono notificati correttamente
        int counter = 0;
        while (counter < 3) {
            // try/catch per evitare input sbagliati per lo scanner dei double
            try {

                System.out.println("Scegli il nome dell'azione");
                String nome = stringScanner.nextLine();
                System.out.println("Scegli il nuovo valore");
                double valore = doubleScanner.nextDouble();

                AgenziaBorsa.aggiornaValoreAzione(nome, valore);

                counter++;

                // gestione dell' eccezione input mismatch
            } catch (InputMismatchException e) {
                System.out.println("Riprova a inserire valori corretti");
                doubleScanner.nextLine(); // rimuovi il buffer per via dell'inserimento invalido
            }
        }

        stringScanner.close();
        doubleScanner.close();
    }
}

// interfaccia da observer Investitore
interface Investitore {
    void notifica(String azione, double valore);
}

// classe subject
class AgenziaBorsa {

    // implementazione del singleton pattern
    private static AgenziaBorsa instance = null;

    // anche la lista static in modo che si va a modificare sempre la stessa lista
    private static ArrayList<Investitore> listaInvestitore = null;

    // valori da notificare
    private static double valore;
    private static String azione;

    // costruttore privato per implementare il singleton pattern
    private AgenziaBorsa() {};

    // getInstance() che inizializza si instance che l'arrayList
    public static AgenziaBorsa getInstance() {
        if (instance == null) {
            instance = new AgenziaBorsa();
            listaInvestitore = new ArrayList<>();
        }
        return instance;
    }

    // implementazione metodi subject, aggiungi/rimuovi/notifica observer
    public static void aggiungiInvestitore(Investitore investitore) {
        listaInvestitore.add(investitore);
    }

    public static void rimuoviInvestitore(Investitore investitore) {
        listaInvestitore.remove(investitore);
    }

    private static void notificaInvestitori() {
        for (Investitore investitore : listaInvestitore) {
            investitore.notifica(azione, valore);
        }
    }

    // metodo di aggiornamento dello state del subject come previsto da observer
    // Pattern che notifica tutti gli observer nella lista
    public static void aggiornaValoreAzione(String nomeAzione, double valoreAzione) {
        valore = valoreAzione;
        azione = nomeAzione;
        notificaInvestitori();
    }

}

// classe observer implementata con il sistema di notifica dell'observer
// pattern, l'observer in questo caso semplicemnte printa in console l'avvenuto
// cambio di stato del subject
class InvestitorePrivato implements Investitore {

    // variabile d'identificazione, può essere sostituito don uno UUID per
    // singolarità
    private String nome;

    // costruttore con String nome per avere un può di specifiche in più ringuardo
    // al singolo observer
    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    // implementazione del sistema di notifica, in programmi reali dovrebbe cambiare
    // pure lo statod ell'observer
    @Override
    public void notifica(String azione, double valore) {
        System.out.println("[Investitore Privato: " + getNome() + "] le azioni di " + azione
                + " hanno adesso un valore di: " + valore);
    }

    // get nome in quanto la variabile nome è privata
    public String getNome() {
        return nome;
    }

}

// precisa identica a sopra, acmbio giusto il print statement per dimostrare il
// polimorfismo del metodo overridato notifica richiamto nella classe subject
class InvestitoreBancario implements Investitore {

    private String nome;

    public InvestitoreBancario(String nome) {
        this.nome = nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("[Investitore Bancario: " + getNome() + "] le azioni di " + azione
                + " hanno adesso un valore di: " + valore);

    }

    public String getNome() {
        return nome;
    }

}