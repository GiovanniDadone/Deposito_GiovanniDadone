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
    void borrowBook(String title) {
        for (Book book : listaLibri) {
            if (book.title.equals(title)) {
                book.isAvailable = false;
            }
        }
    }
}
