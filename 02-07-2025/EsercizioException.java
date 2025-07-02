import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioException {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Procedere con la divisione? 1=Si, 2=No ");
                int scelta = readIntWithRange("Inserire 1 per Si o 2 per No", 1, 2);
                
                if (scelta == 2) {
                    break;
                }

                // Acquisizione dividendo
                System.out.println("Inserisci il dividendo (numero positivo): ");
                int dividendo = readInt("Inserire un numero intero valido");
                
                try {
                    Controller.checkPositive(dividendo);
                } catch (NumeroNegativoException e) {
                    handleException(e);
                    continue;
                }

                // Acquisizione divisore
                System.out.println("Inserisci il divisore (numero positivo diverso da zero): ");
                int divisore = readInt("Inserire un numero intero valido");
                
                try {
                    Controller.checkPositive(divisore);
                    Controller.checkNotZero(divisore);
                } catch (NumeroNegativoException | NumeroZeroException e) {
                    handleException(e);
                    continue;
                }

                // Esecuzione divisione
                double risultato = (double) dividendo / divisore;
                System.out.println("Risultato della divisione: " + risultato);

            } catch (Exception e) {
                System.out.println("Errore imprevisto: " + e.getMessage());
                e.printStackTrace();
            }
        }
        
        System.out.println("Programma terminato.");
        scanner.close();
    }

    /**
     * Legge un intero da input con messaggio di errore personalizzato
     */
    private static int readInt(String errorMessage) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print(errorMessage + ": ");
                scanner.next(); // Pulisce il buffer
            }
        }
    }

    /**
     * Legge un intero da input con controllo del range
     */
    private static int readIntWithRange(String errorMessage, int min, int max) {
        while (true) {
            int input = readInt(errorMessage);
            if (input >= min && input <= max) {
                return input;
            }
            System.out.print("Valore non valido. " + errorMessage + ": ");
        }
    }

    /**
     * Gestione standardizzata delle eccezioni
     */
    private static void handleException(Exception e) {
        e.printStackTrace();
        System.out.println("Errore: " + e.getMessage());
    }    
}

class Controller {

        // Metodo per verificare se un numero è positivo
        public static void checkPositive(int numero) throws NumeroNegativoException {
            if (numero < 0) {
                throw new NumeroNegativoException(
                        "Il numero " + numero + " è negativo. Sono ammessi solo valori positivi.", null);
            }
        }

        // Metodo per verificare se un numero è diverso da zero
        public static void checkNotZero(int numero) {
            if (numero == 0) {
                throw new NumeroZeroException(
                        "Il numero non può essere zero. Sono ammessi tutti i valori tranne zero.",
                        null);
            }
        }
    }

class NumeroNegativoException extends Exception {

    // Costruttore con due parametri: String e Throwable
    public NumeroNegativoException(String message, Throwable cause) {
        super(message, cause);
    }
}

class NumeroZeroException extends RuntimeException {

    // Costruttore con due parametri: String e Throwable
    public NumeroZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
