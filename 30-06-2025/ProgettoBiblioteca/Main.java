import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        // simulazione lista utenti della biblioteca cono popolazione predefinita per
        // testare le funzionalità
        ArrayList<User> listaUtenti = new ArrayList<>();
        User marco = new User("Marco");
        User paolo = new User("Paolo");
        User debora = new User("Debora");
        User carla = new User("Carla");

        // utenti aggiunti manualmente
        listaUtenti.add(marco);
        listaUtenti.add(paolo);
        listaUtenti.add(debora);
        listaUtenti.add(carla);

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
                    7. Fai passare (x) giorni
                    8. Esci dal programma
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
                    // processo per cambiare la disponibilità di un libro e aggiungerlo ai libri
                    // presi
                    // in prestito di un utente preciso
                    System.out.println("Chi sta prendendo il libro in prestito?");

                    // iterazione in tutta la lista degli utenti con un forEach + counter
                    int counter = 1;
                    for (User user : listaUtenti) {
                        System.out.println(counter++ + ". " + user.name);
                    }

                    // richiesta del numerodell'utente corrispondente che vuole chiedere il presttio
                    System.out.println("Inserisci il numero identificativo dell'utente");
                    int utenteScelto = scannerInt.nextInt();

                    // richiesta del titolo del libro da prendere in prestito
                    System.out.println("Inserisci il titolo del libro da prendere in prestito");
                    String titoloRicerca = scannerString.nextLine();

                    System.out.println("Titolo preso in prestito");

                    // il metodo searchBook ritorna il libro che si vuole prendere in prestito,
                    // passandolo come parametro al metodo prestitoLibro che aggiunge il libro nella
                    // lista dei libri in prestito di uno specifico utente e cambia la disponibilità
                    // del libro
                    listaUtenti.get(utenteScelto - 1).prestitoLibro(libreria.searchBook(titoloRicerca));
                    System.out.println("---------------------------");

                    break;

                case 3:
                    // processo per cambiare la disponibilità di un libro e toglierlo dai libri
                    // presi
                    // in prestito di un utente
                    System.out.println("Chi sta restituendo un libro?");

                    // iterazione in tutta la lista degli utenti con un forEach + counter
                    int counter2 = 1;
                    for (User user : listaUtenti) {
                        System.out.println(counter2++ + ". " + user.name);
                    }

                    // richiesta del numero dell'utente corrispondente che vuole restituire un
                    // volume
                    System.out.println("Inserisci il numero identificativo dell'utente");
                    int utenteSelezionato = scannerInt.nextInt();

                    
                    User utente = listaUtenti.get(utenteSelezionato);

                    if (utente.borrowedBooks.size() > 0) {

                        // display della lista dei libri da restituire di un particolare utente
                        utente.displayBorrowedBooks();

                        // richiesta del numero del libro da restituire dalla lista dei libri di un
                        // particolare utente
                        System.out.println("Inserisci il numero identificativo del libro da restituire");
                        int numeroLibro = scannerInt.nextInt();
                        utente.borrowedBooks.remove(numeroLibro - 1);
                    }

                    System.out.println("---------------------------");
                    break;

                case 4:
                    // stampa in console tutti i titoli disponibili della libreria
                    for (Book book : libreria.listaLibri) {
                        if (book.isAvailable) {
                            book.displayBookInfo();
                        }
                        System.out.println("---------------------------");
                    }
                    break;

                case 5:
                    // implementazione ricerca titoli o autori
                    System.out.println("Digita il titolo di un libro o di un autore");
                    String input = scannerString.nextLine();
                    libreria.searchBook(input);
                    System.out.println("---------------------------");
                    break;
                case 6:
                    // printa in console tutti i libri attualmente presi in prestito e da chi
                    for (User user : listaUtenti) {
                        if (user.borrowedBooks.size() > 0) {
                            System.out.println("Libri in prestito di: " + user.name);
                            for (Book book : user.borrowedBooks) {
                                book.displayBookInfo();
                                System.out.println("---------------------------");
                            }
                        }
                    }
                    System.out.println("---------------------------");
                    break;

                case 7:
                    System.out.println("Quanti giorni vuoi far passare?");
                    int giorniPassati = scannerInt.nextInt();
                    libreria.passanoTotGiorni(giorniPassati);
                    break;

                case 8:
                    // uscita dal programma con cambiamento della variabile su cui si regge il loop
                    // principale
                    inputValido = true;
                    break;

                default:
                    // gestione input invalidi
                    System.out.println("Input non valido, ritenta");
                    System.out.println("---------------------------");
                    break;
            }
        }
        scannerInt.close();
        scannerString.close();
    }
}
