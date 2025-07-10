public class DatabaseManager {
    private static DatabaseManager manager;
    private static int count = 0;
    private static int id = 0;

    private DatabaseManager() {
        id++;
    }

    public static DatabaseManager getInstance() {
        if (manager == null) {
            manager = new DatabaseManager();
        }
        return manager;
    }

    public void connect() {
        count++;
        System.out.println("Connessione stabilita. Connessioni attive: " + getCount());
    }

    public void close() {
        manager = null;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
