import java.util.ArrayList;

public class User {
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    // metodo per aggiungere un libro dalla lista dei libri utente se non ce ne sono
    // già tre presenti
    public void prestitoLibro(Book book) {
        if (borrowedBooks.size() < 4) {
            borrowedBooks.add(book);
            book.isAvailable = false;
        } else {
            System.out.println("Troppi libri presi in prestito, ritornane prima qualcuno");
        }
    }

    // metodo per rimuovere un libro ritornato dalla lista utente
    public void restituzioneLibro(Book book) {
        if (book.daysBorrowed > 14) {
            System.out.println("Applicazione penale di 1$ per giorno oltre la soglia: \nTotale: "
                    + (book.daysBorrowed - 14) + "$");
        }
        book.daysBorrowed = 0;
        borrowedBooks.remove(book);
        book.isAvailable = true;
    }

    // metodo per stampare tuti i libri presi in prestito da un singolo utente
    void displayBorrowedBooks() {
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println("Book #" + (i + 1) + ": ");
            borrowedBooks.get(i).displayBookInfo();
        }
    }

}
