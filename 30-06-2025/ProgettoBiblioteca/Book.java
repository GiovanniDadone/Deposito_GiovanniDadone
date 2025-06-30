public class Book {
    String title;
    String author;
    boolean isAvailable = true;

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
}