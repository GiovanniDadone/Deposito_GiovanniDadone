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

    //metodo per stampare su terminale le informazioni di un libro formattate 
    void displayBookInfo() {
        System.out.println("Titolo: " + title + "\n"
                + "Autore: " + author + "\n"
                + "Disponibile: " + disponibilità());
    }

    //metodo di utility per stampare in maniera intelligibile la disponibilità di un libro
    String disponibilità() {
        return (isAvailable) ? "Disponibile" : "Preso in pestito";
    }

}