import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHamburgeria {
    public static void main(String[] args) {
        Hamburgeria loZozzoneDeNoartri = new Hamburgeria();

        Scanner scannerInt = new Scanner(System.in);

        int sceltaMenù = 0;
        while (sceltaMenù != 2) {
            displayMenuPrincipale();
            sceltaMenù = scannerInt.nextInt();
            loZozzoneDeNoartri.ordinaHamburger(scannerInt);
        }

        loZozzoneDeNoartri.stampaScontrino();
    }

    public static void displayMenuPrincipale() {
        System.out.println("""
                1. Ordina hamburger
                2. Esci
                """);
    }
}

class Hamburgeria {
    private ArrayList<Hamburger> listaOrdini = new ArrayList<>();

    public ArrayList<Hamburger> getListaOrdini() {
        return listaOrdini;
    }

    public void stampaScontrino() {
        for (Hamburger hamburger : listaOrdini) {
            System.out.println("Tipo di Hamburger: " + hamburger.getNome());
        }
    }

    public boolean ordinaHamburger(Scanner scannerInt) {
        boolean ordineConcluso = false;
        while (!ordineConcluso) {
            displayBurgerMenu();
            int scelta = 0;
            Hamburger panino = null;
            while (scelta != 4) {
                scelta = scannerInt.nextInt();
                panino = aggiungiPanino(scelta);
            }
            aggiungiOrdine(panino);
            if (panino == null) {
                ordineConcluso = true;
            }
        }
        return ordineConcluso;

    }

    private void aggiungiOrdine(Hamburger panino) {
        if (panino != null) {
            listaOrdini.add(panino);
            System.out.println("Panino aggiunto");
        }
    }

    private void displayBurgerMenu() {
        System.out.print("""
                Che panino vuoi ordinare?
                1. Cheeseburger
                2. Veg Burger
                3. Double Bacon burger
                Inserisci il numero corrispondente: """);
    }

    public Hamburger aggiungiPanino(int scelta) {
        Hamburger panino = null;
        switch (scelta) {
            case 1:
                panino = new Cheeseburger("Cheeseburger");
                break;
            case 2:
                panino = new Vegburger("Veggie Burger");
                break;
            case 3:
                panino = new DoubleBacon("Double Bacon Burger");
                break;
            case 4:
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
        return panino;
    }
}

class Hamburger {
    private String nome;

    public Hamburger(String nome) {
        this.nome = nome;
    }

    public void prepara() {
        System.out.println("Metodo di Hamburger, c'è qualcquadra che non cosa");
    }

    public String getNome() {
        return nome;
    }

}

class Cheeseburger extends Hamburger {

    public Cheeseburger(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {

        System.out.println("Pane, carne, formaggio, ketchup");
    }

}

class Vegburger extends Hamburger {

    public Vegburger(String nome) {
        super(nome);
    }

    @Override
    public void prepara() {
        System.out.println("Pane, doppia carne, cheddar, maionese");
    }

}

class DoubleBacon extends Hamburger {

    public DoubleBacon(String nome) {
        super(nome);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void prepara() {
        // TODO Auto-generated method stub
        super.prepara();
    }

}
