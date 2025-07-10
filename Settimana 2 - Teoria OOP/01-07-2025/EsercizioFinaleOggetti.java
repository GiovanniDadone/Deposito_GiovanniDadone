import java.util.Scanner;

public class EsercizioFinaleOggetti {
    public static void main(String[] args) {

        // apertura di due scanner, quello per le stringhe per l'immissione dei modelle
        // e delle targhe e quello per gli int per la scelta del menù
        Scanner scannerStringhe = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        // inizializzazione oggetto officina per richiamarne i metodi
        Officina officina = new Officina();

        // booleano per definire la permanenza o meno nel ciclo del menù
        boolean uscitaMenu = false;

        while (!uscitaMenu) {

            // print del menù interattivo con scelta tramite input id un int
            System.out.println("Cosa vuoi fare?\n" +
                    "1. Aggiungi auto nuova\n" +
                    "2. Guarda la lista di tutte le auto in officina\n" +
                    "3. Esci dal programma");
            int scelta = scannerInt.nextInt(); // salviamo la scelta in una variabile locale
            switch (scelta) {
                case 1:

                    // richiesta delle generalità dell'auto all'utente e successiva aggiunta di un
                    // oggetto Auto nuovo tramite metodo dell'officina "aggiungiAuto()" passando i due input come parametri
                    System.out.println("Inserisci il modello dell'auto da inserire");
                    String modello = scannerStringhe.nextLine();    //input primo paramtro
                    System.out.println("Inserisci la targa dell'auto");
                    String targa = scannerStringhe.nextLine();      //input secondo parametro

                    //aggiunta all'arrayList delle auto dell'officina
                    officina.aggiungiAuto(targa, modello);

                    break;

                case 2:

                //stampa di tutti gli oggetti auto nell' arraylist listaAuto dell'oggetto officina
                    officina.visualizzaListaMacchine();
                    break;

                case 3:

                //cambio della variabile per uscire dalo ciclo del manù
                    System.out.println("Uscita dal programma");
                    uscitaMenu = true;

                default:

                //messaggio di default per gli input al di fuori della scelta del menù
                    System.out.println("Scelta non valida riprova");
                    break;
            }
        }

        //chiusura scanner per buona pratica
        scannerInt.close();
        scannerStringhe.close();
    }
}
