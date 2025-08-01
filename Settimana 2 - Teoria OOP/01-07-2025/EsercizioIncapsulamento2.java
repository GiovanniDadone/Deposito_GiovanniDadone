import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioIncapsulamento2 {
    public static void main(String[] args) {

        // apertura scanner per gestire gli input
        Scanner scannerStringhe = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        // creazione di oggetto CompagniaAerea per provare i metodi
        CompagniaAerea compagnia = new CompagniaAerea("Tappeti Volanti");

        // apertura ciclo principale tramite validazione del booleano inputValido,
        // quando cambia il ciclo non si ripete
        boolean inputValido = false;
        while (!inputValido) {

            // a ogni ciclo il print statement del menù si ripete
            displayMenu();

            // ricezione dell'input dell'utente, un numero intero
            int scelta = scannerInt.nextInt();

            // gestione dell'input utente
            switch (scelta) {
                case 1:
                    System.out.println("\n--- Aggiungi un nuovo pilota ---");
                    System.out.print("Nome pilota: ");
                    String nome = scannerStringhe.nextLine(); // immissione nome del nuovo pilota
                    System.out.print("Ore di volo: ");
                    int oreVolo = scannerInt.nextInt(); // immissione ore di volo del nuovo pilota
                    compagnia.aggiungiPilota(nome, oreVolo); // aggiunta alla lista dei piloti di CompagniaAerea
                    System.out.println("Pilota aggiunto con successo!");
                    break;

                case 2:
                    System.out.println("\n--- Aggiungi un nuovo aereo ---");
                    System.out.print("Modello aereo: ");
                    String modello = scannerStringhe.nextLine(); // immissione nome modello del nuovo aereo
                    System.out.print("Numero posti: ");
                    int posti = scannerInt.nextInt(); // immissione numero di posti del nuovo aereo
                    compagnia.aggiungiAereo(modello, posti); // aggiunta del nuovo aereo alla flotta di CompagniaAerea
                    System.out.println("Aereo aggiunto con successo!");
                    break;

                case 3:
                    compagnia.stampaDettagliCompagnia(); // stampa dei dettagli della compagnia
                    break;

                case 4:
                    System.out.println("Arrivederci!"); // uscita dal ciclo while
                    inputValido = true;
                    return;

                default:
                    System.out.println("Scelta non valida! Riprova."); // gestione delle scelte non presenti nello
                                                                       // blocco switch
            }

            System.out.println("\nPremi Invio per continuare..."); // immisione nulla per fare da buffer dei cicli
            scannerStringhe.nextLine();
        }

        scannerInt.close();
        scannerStringhe.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== MENU COMPAGNIA AEREA ===");
        System.out.println("1. Aggiungi un pilota");
        System.out.println("2. Aggiungi un aereo");
        System.out.println("3. Visualizza dettagli compagnia");
        System.out.println("4. Esci");
        System.out.print("Scelta: ");
    }
}

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;
    private static int counter = 0;

    public Aereo(String modello, int numeroPosti) {
        aumentaCounter();
        this.modello = modello;
        this.numeroPosti = numeroPosti;
        this.codice = "XX" + getCounter();
    }

    // sezione dei getter
    public String getModello() {
        return modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public String getCodice() {
        return codice;
    }

    public static int getCounter() {
        return counter;
    }

    // metodo a parte per aumentare il counter degli oggetti Aereo
    private static void aumentaCounter() {
        counter++;
    }

    // setter per ogni variabile ad eccezione di quello per il counter statico
    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Numero di posti negativo non possibile");
        }
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

}

class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    public Pilota(String nome, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = generaNumeroBrevetto();
        this.oreVolo = oreVolo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    // metodo generato con deepseek per la generazione casuale di un codice
    // identificativo del numero di brevetto del pilota, i caratteri generati sono
    // numeri generati con Math.random
    private String generaNumeroBrevetto() {
        // 65 è il codice ASCII per la lettera A maiuscola, si aggiunge poi un numero
        // randomico
        // tra 0 e 26, il risultato castato come char esita un carattere maiuscolo dalla
        // A alla Z
        return "" + (char) (65 + Math.random() * 26)
                + (char) (65 + Math.random() * 26)
                + (char) (65 + Math.random() * 26)
                + (int) (Math.random() * 10)
                + (int) (Math.random() * 10);
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        this.oreVolo = oreVolo;
    }

}

class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    // costruttore per inizializzare l'oggetto col nome personalizzato e le liste
    // vuote
    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    // metodo per aggiungere un aereo alla flotta
    public void aggiungiAereo(String modello, int numeroPosti) {
        this.flotta.add(new Aereo(modello, numeroPosti));
    }

    // metodo per aggiungerer un pilota alla lista dei piloti
    public void aggiungiPilota(String nome, int oreVolo) {
        this.piloti.add(new Pilota(nome, oreVolo));
    }

    // metodo per stampare tutte le informazioni di una singola compagnia aerea
    public void stampaDettagliCompagnia() {
        System.out.println("=== DETTAGLI COMPAGNIA AEREA ===");
        System.out.println("Nome: " + this.nome);
        System.out.println("\n** Flotta Aerei **");

        // stampa (se ci stanno) gli aerei della flotta
        if (flotta.isEmpty()) {
            System.out.println("Nessun aereo in flotta.");
        } else {
            for (Aereo aereo : flotta) {
                System.out.println("- " + aereo.getModello() +
                        " | Posti: " + aereo.getNumeroPosti() +
                        " | Codice: " + aereo.getCodice());
            }
        }

        // stampa (se ci stanno) i piloti della compagnia
        System.out.println("\n** Piloti **");
        if (piloti.isEmpty()) {
            System.out.println("Nessun pilota assunto.");
        } else {
            for (Pilota pilota : piloti) {
                System.out.println("- " + pilota.getNome() +
                        " | Brevetto: " + pilota.getNumeroBrevetto() +
                        " | Ore di volo: " + pilota.getOreVolo());
            }
        }

        // stampa bonus delle statistiche generali
        System.out.println("\n** Statistiche **");
        System.out.println("Totale aerei: " + flotta.size());
        System.out.println("Totale piloti: " + piloti.size());
        System.out.println("========================");
    }
}
