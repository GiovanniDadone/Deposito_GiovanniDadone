import java.util.ArrayList;

public class DatabaseUtenti {
    private static ArrayList<Utente> listaUtenti = new ArrayList<>();

    public static void aggiungiUtente(Utente utente) {
        // notifica di aggiunta da implementare
        listaUtenti.add(utente);
    }

    public static void rimuoviUtente(Utente utente) {
        listaUtenti.remove(utente);
    }

    public static boolean cercaUtente(Utente utente) {
        for (Utente utenteLocale : listaUtenti) {
            if (utenteLocale.getNome().equals(utente.getNome())) {
                return true;
            }
        }
        return false;
    }

}
