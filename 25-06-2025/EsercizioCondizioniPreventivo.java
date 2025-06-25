import java.util.Scanner;

public class EsercizioCondizioniPreventivo {
    public static void main(String[] args) {
        // base per i calcoli
        int baseAssicurativa = 500;

        // maggiorazione eventuale della base aggiornata tramite metodo utilitario
        // statico che trovi in fondo al file
        int assicurazioneFinale = 0;

        // booleano per capire se l'utente è idoneo o meno aggiornato nei conditional
        // statements
        boolean idoneità = true;

        // creazione scanner
        Scanner scanner = new Scanner(System.in);

        // Domanda sull'età
        System.out.println("Quanti anni hai?");
        final Integer età = scanner.nextInt();
        scanner.nextLine();
        switch (età) {
            // Pattern matching per controllare gli input in switch statement (non volevo
            // usare gli if-else)
            case Integer age when age < 18 -> {
                System.out.println("Non sei idoneo per l'assicurazione");
                idoneità = false;
            }
            case Integer age when age >= 18 && age <= 25 -> {
                System.out.println("Maggiorazione 20%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, 20);
            }
            case Integer age when age > 25 && age <= 50 -> System.out.println("Nessuna Maggiorazione");
            case Integer age when age > 50 -> {
                System.out.println("Sconto del 10%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, -10);
            }
            default -> System.out.println("");
        }

        // domanda sull'esperienza alla guida
        System.out.println("Quanti anni di esperienza alla guida hai?");
        int esperienza = scanner.nextInt();
        scanner.nextLine();
        if (esperienza > 2) {
            System.out.println("Nessuna maggiorzione");
        } else {
            System.out.println("Maggiorazione del 30%");
            assicurazioneFinale = applicaMaggiorazione(baseAssicurativa, 30);
        }

        // dichiarazione del numero di incidenti
        System.out.println("Numero di incidenti negli ultimi 5 anni?");
        int incidenti = scanner.nextInt();
        scanner.nextLine();
        switch (incidenti) {
            case 0:
                System.out.println("Nessun aumento");
                break;
            case 1:
                System.out.println("Aumento del 15%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, 15);
                break;
            case 2, 3:
                System.out.println("Aumento del 30%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, 30);
                break;
            default:
                System.out.println("Non sei idoneo all'assicurazione");
                idoneità = false;
                break;
        }

        // scelta del pacchetto assicurativo
        System.out.println("Che pacchetto assicurativo vuoi? (Scegli il numero corrispondente)");
        System.out.println("""
                1. Base
                2. Intermedio
                3. Premium
                """);
        int pacchetto = scanner.nextInt();
        scanner.nextLine();
        switch (pacchetto) {
            case 1:
                System.out.println("Prezzo standard");
                break;
            case 2:
                System.out.println("Prezzo +20%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, 20);
                break;
            case 3:
                System.out.println("Prezzo +50%");
                assicurazioneFinale += applicaMaggiorazione(baseAssicurativa, 50);
                break;
            default:
                break;
        }

        // controllo idoneità finale
        if (idoneità) {
            System.out.println("Il costo della tua assicurazione è: " + (baseAssicurativa + assicurazioneFinale));
        } else {
            System.out.println("Non idoneità rilevata");
        }
        scanner.close();
    }

    // metodo di utilità per aumetare il prezzo
    public static int applicaMaggiorazione(int base, int magg) {
        return ((base / 100) * magg);
    }
}
