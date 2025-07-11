import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void displayMenu() {
        System.out.println("======Login/Registrazione=====");
        System.out.println("1. Login");
        System.out.println("2. Registrazione");
        System.out.println("3. Uscita");
    }

    public void loopMenu(Scanner intScanner, Scanner stringScanner) {
        boolean uscita = false;

        while (!uscita) {
            displayMenu();

            int scelta = ottieniInput(intScanner);

            switch (scelta) {
                case 1:
                    // Login
                    System.out.println("Inserisci nome nuovo utente");
                    String nomeLogin = stringScanner.nextLine();
                    System.out.println("Inserisci la password");
                    String passwordLogin = stringScanner.nextLine();
                    break;

                case 2:
                    // Registrazione
                    System.out.println("Inserisci nome nuovo utente");
                    String nomeRegistrazione = stringScanner.nextLine();
                    if (checkUnicity(nomeRegistrazione)) {
                        System.out.println("Inserisci la password");
                        String passwordRegistrazione = stringScanner.nextLine();
                        DatabaseUtenti.aggiungiUtente(new Utente(nomeRegistrazione, passwordRegistrazione));
                    } else {
                        System.out.println("Utente già registrato");
                    }
                    break;

                case 3:
                    // Uscita
                    uscita = true;
                    System.out.println("Uscita...");
                    break;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    // metodo che gestisce l'input dell'utente
    public static int ottieniInput(Scanner intScanner) {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = intScanner.nextInt();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            intScanner.nextLine(); // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }

    public boolean checkUnicity(String nome) {
        Utente temporaneo = new Utente(nome, nome);
        if (DatabaseUtenti.cercaUtente(temporaneo)) {
            return false;
        }
        return true;
    }

}
