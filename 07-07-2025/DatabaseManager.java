public class DatabaseManager {
    private static DatabaseManager manager;
    private static int count = 0;


    private DatabaseManager() {}

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

    public int getCount() {
        return count;
    }
}
