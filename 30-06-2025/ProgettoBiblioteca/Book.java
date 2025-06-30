public class Book {
    String title;
    String author;
    boolean isAvailable = true;
    User borrowingUser;
    int daysBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBookInfo() {
        System.out.println("Titolo: " + title + "\n"
                + "Autore: " + author + "\n"
                + "Disponibile: " + disponibilità());
    }

    String disponibilità() {
        return (isAvailable) ? "Disponibile" : "Non disponibile";
    }

    void registerBorrowingUser(User user) {
        this.borrowingUser = user;
    }

    void registerBorrowingDate() {

    }
}