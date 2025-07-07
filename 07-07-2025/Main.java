public class Main {
    public static void main(String[] args) {

        // variabili di DatabaseManager
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();

        // simuliamo diverse connessioni
        db1.connect();
        db2.connect();
        db1.connect();
        db2.connect();
        db2.connect();

        // controllo che siano della stessa istanza
        if (db1 == db2) {
            System.out.println("Conferma: db1 e db2 sono la stessa istanza.");
        } else {
            System.out.println("Errore: le istanze non coincidono.");
        }

        // print delle connessioni attive
        System.out.println(db1.getCount());
        System.out.println(db2.getCount());

    }
}
