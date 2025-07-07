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

        // controllo che siano della stessa istanza tramite Id
        if (db1.getId() == db2.getId()) {
            System.out.println("Conferma: db1 e db2 sono la stessa istanza.");
        } else {
            System.out.println("Errore: le istanze non coincidono.");
        }

        System.out.println("ID uguali: " + db2.getId());

        //se chiudo uno dei due, automaticamente dovrebbero chiudersi entrambi
        db1.close();

        //nel richiamare nuovamente getInstance() dovrei notare un incremento di Id in ambedue le variabili db1 e db2
        DatabaseManager.getInstance();
        System.out.println(db1.getId());
        System.out.println(db2.getId());

        // print delle connessioni attive
        System.out.println(db1.getCount());
        System.out.println(db2.getCount());

    }
}
