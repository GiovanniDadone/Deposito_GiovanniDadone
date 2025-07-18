import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        boolean uscita = false;

        ArrayList<Veicolo> veicoli = new ArrayList<>();

        while (!uscita) {
            System.out.println("Gesitone Officina");
            System.out.println("1. Stampa tutti i veicoli");
            System.out.println("2. Aggiungi Auto");
            System.out.println("3. Aggiungi Moto");
            System.out.println("0. Exit");
            System.out.print("Scelta: ");

            if (!intScanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                intScanner.next(); // Consuma l'input errato
                continue;
            }

            int scelta = intScanner.nextInt();
            intScanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // Case 1 logic
                    stampaDettagli(veicoli);
                    break;
                case 2:
                    // Case 1 logic
                    System.out.println("Scegli il nome della marca auto");
                    String marcaAuto = stringScanner.nextLine();
                    System.out.println("Scegli il nome del modello auto");
                    String modelloAuto = stringScanner.nextLine();
                    addAuto(veicoli, marcaAuto, modelloAuto);
                    break;
                case 3:
                    // Case 1 logic
                    System.out.println("Scegli il nome della marca moto");
                    String marcaMoto = stringScanner.nextLine();

                    System.out.println("Scegli il nome del modello moto");
                    String modelloMoto = stringScanner.nextLine();

                    addMoto(veicoli, marcaMoto, modelloMoto);
                    break;

                case 0:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
        intScanner.close();
        stringScanner.close();
    }

    public static void addMoto(ArrayList<Veicolo> veicoli, String marca, String modello) {
        veicoli.add(new Moto(marca, modello));
    }

    public static void addAuto(ArrayList<Veicolo> veicoli, String marca, String modello) {
        veicoli.add(new Auto(marca, modello));
    }

    public static void stampaDettagli(ArrayList<Veicolo> veicoli) {
        for (Veicolo veicolo : veicoli) {
            veicolo.dettagli();
        }
    }
}