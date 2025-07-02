import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioEreditarietà {
    public static void main(String[] args) {

        // inizializzazione arrayList di Animali
        ArrayList<Animale> zoo = new ArrayList<>();

        // apertura scanner per gli input del menu
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStringhe = new Scanner(System.in);

        // solito menu gestito tramite ciclo while
        boolean inputValido = false;
        while (!inputValido) {
            // Logica del menu
            System.out.println("""
                    1. Inserisci un nuovo animale nello zoo
                    2. Mostra una lista degli animali dello zoo
                    3. Esci dal programma
                    """);
            int scelta = scannerInt.nextInt();

            switch (scelta) {
                case 1:
                    System.out.println("Vuoi aggiungere un animale o un gatto?");

                    // creo una referenza di tipo animale vuota
                    Animale nuovo = null;

                    // richiesta per capire che tipo di animale si vuole scegliere di aggiungere
                    System.out.println("1. Cane   /  2. Gatto");
                    int choice = scannerInt.nextInt();

                    // richiesta nome
                    System.out.println("Inserisci il nome del nuovo Animale");
                    String nome = scannerStringhe.nextLine();

                    // richiesta anni
                    System.out.println("Inserisci gli anni del nuovo animale");
                    int anni = scannerInt.nextInt();

                    // instanziazione della variabile Animale nuovo tramite metodi utilitari statici
                    // creati sotto il main
                    if (choice == 1) {
                        nuovo = creaCane(nome, anni);
                    } else if (choice == 2) {
                        nuovo = creaGatto(nome, anni);
                    } else {
                        System.out.println("Scelta non riconosciuta");
                    }

                    // aggiunta llo zoo
                    zoo.add(nuovo);

                    break;

                case 2:

                    // stampa in console molto semplice di ogni animale
                    for (Animale animale : zoo) {
                        System.out.println("Tipo di Animale: " + animale.getClass().getSimpleName() + ", Nome: "
                                + animale.getNome() + ", Anni: " + animale.getEtà());
                    }
                    break;

                case 3: // Exit
                    inputValido = true;
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }

        }
        scannerInt.close();
        scannerStringhe.close();
    }


    //servizi utilitari per la creazione di oggetti entrambi figli della classe Animale
    public static Gatto creaGatto(String nome, int anni) {
        return new Gatto(nome, anni);
    }

    public static Cane creaCane(String nome, int anni) {
        return new Cane(nome, anni);
    }
}


//classe animale con variabili private e getter e setter pubblici
class Animale {
    private String nome;
    private int età;

    public Animale(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

    public void faiVerso() {
        System.out.println("*verso generico non identificato*");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

}


//classe Cane  con costruttore super
class Cane extends Animale {

    public Cane(String nome, int età) {
        super(nome, età);
    }

    public void faiVerso() {
        System.out.println("Bau bau");
    }

}


//classe gatto con costruttore che sfrutta il super
class Gatto extends Animale {

    public Gatto(String nome, int età) {
        super(nome, età);
    }

    public void faiVerso() {
        System.out.println("Miao miao");
    }
}
