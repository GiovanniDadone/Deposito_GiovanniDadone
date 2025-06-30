import java.util.ArrayList;

public class Library {
    ArrayList<Book> listaLibri = new ArrayList<>();

    // metodo per aggiungere un libro, attenzione accetta oggetti di tipo Book,
    // quindi l'inizializzazione è da gestire esternamente
    void addBook(Book book) {
        listaLibri.add(book);
        System.out.println("Aggiunto il seguente libro: ");
        book.displayBookInfo();
        System.out.println("---------------------------");

    }

    // metodo per mostarre in console la lista dei libri all'interno dell'arraylist
    void displayBooks() {
        for (int i = 0; i < listaLibri.size(); i++) {
            System.out.println("Libro #" + (i+1) + ": ");
            listaLibri.get(i).displayBookInfo();
            System.out.println("---------------------------");
        }
    }

    //metodo che cambia la disponibiltà di un titolo in falso
    Book borrowBook(String title, User user) {
        Book borrowedBook = null;
        for (Book book : listaLibri) {
            if (book.title.equals(title) && user.borrowedBooks.size() < 4) {
                borrowedBook = book;
                book.isAvailable = false;
            }
        }
        return borrowedBook;
    }

    //metodo che cambia la disponibiltà di un titolo in vero(true)
    Book returnBook(String title) {
        Book returnedBook = null;
        for (Book book : listaLibri) {
            if (book.title.equals(title)) {
                returnedBook = book;
                book.isAvailable = true;
            }
        }
        return returnedBook;
    }

    //metodo che stampa in console se l'input cercato è presente come autore o come libro
    void searchBook(String input) {
        for (Book book : listaLibri) {
            if (book.title.equals(input)) {
                System.out.println("Il libro è disponibile!");
            }
        }
        for (Book book : listaLibri) {
            if (book.author.equals(input)) {
                System.out.println("Autore trovato");
                book.displayBookInfo();
            }
        }
    }
}
