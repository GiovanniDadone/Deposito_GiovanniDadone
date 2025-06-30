import java.util.ArrayList;

public class User {
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    //gestione prestiti con limite massimo
    public void prestitoLibro(Book book) {
        if (borrowedBooks.size() < 4) {
            borrowedBooks.add(book);
            book.isAvailable = false;
        } else {
            System.out.println("Troppi libri presi in prestito, ritornane prima qualcuno");
        }
    }

    //gestione ritorni
    public void restituzioneLibro(Book book) {
        borrowedBooks.remove(book);
        book.isAvailable = true;
    }
}
