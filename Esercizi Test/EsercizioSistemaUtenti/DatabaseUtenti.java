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

    public static Utente cercaUtente(Utente utente) {
        for (Utente utenteLocale : listaUtenti) {
            if (utenteLocale.getNome().equals(utente.getNome())) {
                return utenteLocale;
            }
        }
        return null;
    }

    public static Utente cercaUtente(String nome, String password) {
        Utente utenteDaCercare = new Utente(nome, password);
        for (Utente utente : listaUtenti) {
            if (utente.getNome().equals(utenteDaCercare.getNome())) {
                return utente;
            }
        }
        return null;
    }

}
