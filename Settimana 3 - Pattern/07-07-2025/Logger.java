// Definizione della classe Logger come singleton

import java.time.LocalDateTime;

public class Logger {
    // Istanza privata statica della classe Logger
    private static Logger instance;

    // Costruttore privato per impedire l'istanziazione diretta
    private Logger() {
        System.out.println("Logger creato privatamente");
    }

    // Metodo pubblico statico per ottenere l'unica istanza di Logger
    public static Logger getInstance() {
        // Se l'istanza non esiste, viene creata
        if (instance == null) {
            instance = new Logger();
        }
        // Restituisce l'istanza esistente
        return instance;
    }

    // Metodo per stampare un messaggio di log
    public void scriviMessaggio(String msg) {
        System.out.println("[LOG] " + LocalDateTime.now() + " " + msg);
    }
}
