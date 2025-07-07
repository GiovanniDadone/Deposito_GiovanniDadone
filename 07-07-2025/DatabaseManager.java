public class DatabaseManager {
    private static DatabaseManager manager;
    private static int count = 0;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (manager == null) {
            return new DatabaseManager();
        }
        return manager;
    }

    private void connect() {
        count++;
        System.out.println("Connessione stabilita. Connessioni attive: " + getCount());

    }

    private int getCount() {
        return count;
    }

    public static void main(String[] args) {

        // simuliamo diverse connessioni
        DatabaseManager.getInstance().connect();
        DatabaseManager.getInstance().connect();
        DatabaseManager.getInstance().connect();
        DatabaseManager.getInstance().connect();

        // se l'oggetto utilizzato è sempre lo stesso, richiamando getCount due volte di
        // consecutiva da due chiamate di getInstance() differenti dovrebbe darci lo
        // stesso numero
        // di connesioni
        System.out.println(DatabaseManager.getInstance().getCount());
        System.out.println(DatabaseManager.getInstance().getCount());

    }
}
