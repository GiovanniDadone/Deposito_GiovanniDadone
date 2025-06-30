import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        // simulazione utente della biblioteca
        ArrayList<User> listaUtenti = new ArrayList<>();
        listaUtenti.add(new User("Marco"));

        // inizializzazione nuova biblioteca
        Library libreria = new Library();

        // libreria generata con deepseek con titoli semplice per velocizzare il testing
        // all'avvio del programma verranno stampati in console col metodo relativo
        libreria.addBook(new Book("It", "Stephen King"));
        libreria.addBook(new Book("Dune", "Frank Herbert"));
        libreria.addBook(new Book("Dracula", "Bram Stoker"));
        libreria.addBook(new Book("Emma", "Jane Austen"));
        libreria.addBook(new Book("Coraline", "Neil Gaiman"));

        boolean inputValido = false;

        // loop principale che gestisce l'esecuzione del programma
        while (!inputValido) {

            // display del menù a ogni iterazione
            System.out.println("""
                    Cosa vuoi fare?
                    1. Aggiungere un libro alla libreria?
                    2. Prendere un libro in prestito?
                    3. Restituire un libro?
                    4. Vedere tutti i titoli registrati?
                    5. Cerca un titolo o
                    6. Visualizza tutti titoli in prestito di un utente
                    6. Esci dal programma
                    """);

            // registrazione della scelta dell'utente
            int scelta = scannerInt.nextInt();

            // gestione scelte
            switch (scelta) {
                case 1:
                    System.out.println("Digitare titolo del libro da inserire");
                    String titolo = scannerString.nextLine();
                    System.out.println("Inserisci il nome dell'autore");
                    String autore = scannerString.nextLine();

                    // richiamo del metodo della classe Library per l'aggiunta di un libro
                    libreria.addBook(new Book(titolo, autore));
                    break;
                case 2:
                    System.out.println("Inserisci il titolo del libro da prendere in prestito");
                    String titoloRicerca = scannerString.nextLine();

                    // metodo per cambiare la disponibilità di un libro e aggiungerlo ai libri presi
                    // in prestito di un utente
                    listaUtenti.get(0).prestitoLibro(libreria.borrowBook(titoloRicerca, listaUtenti.get(0)));

                    break;
                case 3:
                    // metodo per cambiare la disponibilità di un libro e toglierlo ai libri presi
                    // in prestito di un utente
                    System.out.println("Inserisci il titolo del libro da prendere da ritornare");
                    String titoloRitorno = scannerString.nextLine();
                    listaUtenti.get(0).restituzioneLibro(libreria.borrowBook(titoloRitorno, listaUtenti.get(0)));
                    break;
                case 4:
                    // stampa in console tutti i titoli della libreria
                    libreria.displayBooks();
                    break;

                case 5:
                    // implementazione ricerca titoli o autori
                    System.out.println("Digita il titolo di un libro o di un autore");
                    String input = scannerString.nextLine();
                    libreria.searchBook(input);

                case 6:

                    break;

                case 7:
                    // uscita dal programma con cambiamento della variabile su cui si regge il loop
                    // principale
                    inputValido = true;
                    break;

                default:
                    // gestione input invalidi
                    System.out.println("Input non valido, ritenta");
                    break;
            }
        }
        scannerInt.close();
        scannerString.close();
    }
}
