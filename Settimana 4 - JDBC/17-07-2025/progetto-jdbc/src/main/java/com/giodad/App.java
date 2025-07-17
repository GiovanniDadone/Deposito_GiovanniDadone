package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // carico le variabili di ambiente tramite Dotenv
        Dotenv dotenv = Dotenv.configure()
                .directory(
                        "C:\\Users\\argir\\Documents\\CodingGiovanni\\CorsoBackend\\ProgettoJDBC\\progetto-jdbc\\.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        // richiamo le chiavi segrete tramite dotenv.get()
        String url = dotenv.get("DATABASE_URL");
        String username = dotenv.get("DATABASE_USERNAME");
        String password = dotenv.get("DATABASE_PASSWORD");

        // creo una mappa di username e passwor per il login
        HashMap<String, String> map = new HashMap<>();

        // booleano che gestisce se l'utente è loggato o meno
        boolean loggedIn = false;

        // enuncia la connessione
        Connection connection = null;

        try {
            // apri la connessione
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Successfully connected");
            } else {
                System.out.println("Failed to connect");
            }

            // usare PreparedStatement per evitare SQL injection
            Statement stmt = connection.createStatement();

            // esercizio 10 film più noleggiati
            menu(stmt, map, loggedIn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getFilm(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT title FROM film LIMIT 5");

        while (rs.next()) {
            System.out.println(rs.getString("title"));
        }
    }

    // metodo per ritornare i 10 film più noleggiati
    public static void get10Film(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery(
                "select f.title, count(distinct r.rental_id) as count\n" +
                        "from film as f\n" +
                        "join inventory i on f.film_id = i.film_id\n" +
                        "join rental r on i.inventory_id = r.inventory_id\n" +
                        "group by f.title\n" +
                        "order by count asc\n" +
                        "limit 10;");
        System.out.println(rs.getMetaData().getColumnName(1).toUpperCase() + " | "
                + rs.getMetaData().getColumnName(2).toUpperCase());

        int rownCount = 1;
        while (rs.next()) {

            System.out.println(rownCount + ". " + rs.getString("title") + " | " + rs.getString("count"));
            rownCount++;
        }
    }

    public static void getActors(Statement statement) throws SQLException {
        // qui eseguo la query tramite l'uso dello statement, mi ritorna un Result con i
        // dati con cui ho interrogato il db tramite la query specificata
        ResultSet rs = statement.executeQuery("select * from actor"/* <-----inserire query */);

        // prendo i dati di Metadata del ResultSet e mi baso su quello per gestire i
        // ResultSet
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();

        // stampo il nome delle colonne richiamandolo con meta.getColumnName()
        System.out.println("=== TABELLA ACTOR ===");
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(meta.getColumnName(i));
            if (i < columnCount) {
                System.out.print(" | ");
            }
        }
        // linea separatoria
        System.out.println();

        // Stampa i dati
        int rowCount = 0;

        // ++IMPORTANTE++: rs.next() è un metodo che ritorna un valore booleano ed è
        // necessario per spostare il cursore
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                // prendo il valore della riga
                String value = rs.getString(i);
                // stampa il valore di della riga se non è nullo
                System.out.print(value != null ? value : "NULL");
                if (i < columnCount) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            // aumenta il rowCount
            rowCount++;

            // Limita a 10 righe per non intasare l'output
            if (rowCount >= 10) {
                System.out.println("... (mostrando solo le prime 10 righe)");
                break;
            }
        }
    }

    //metodo principale che accetta lo statement, la HashMap degli utenti e il booleano del login effettuato con successo o meno
    public static void menu(Statement statement, HashMap<String, String> map, boolean loggedIn) throws SQLException {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        boolean uscita = false;

        //loop principale per la gestione delle scelte nel menù
        while (!uscita) {
            displayMenu();

            if (!intScanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                intScanner.next(); // Consuma l'input errato
                continue;
            }

            int scelta = intScanner.nextInt();
            intScanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // Case 1 logic
                    handleLogin(stringScanner, map, loggedIn);
                    break;

                case 2:
                    // Case 2 logic
                    handleRegister(stringScanner, map);
                    break;

                case 3:
                    // Case 3 logic
                    if (loggedIn) {
                        get10Film(statement);
                    } else {
                        System.out.println("Solo gli utenti registrati possono vedere queste statistiche");
                    }
                    break;

                case 4:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
            System.out.println("===============================================");
            System.out.println();
        }
        intScanner.close();
        stringScanner.close();
    }

    //metodo per il display del menu
    public static void displayMenu() {
        System.out.println("==============Menu Film Rental=============");
        System.out.println("1. Login");
        System.out.println("2. Registrati");
        System.out.println("3. Mostra i 10 film più noleggiati");
        System.out.println("4. Exit");
        System.out.print("Scelta: ");
    }


    //metodo che controlla le credenziali inserite per gestire il boolean di loggedIn
    public static void handleLogin(Scanner stringScanner, HashMap<String, String> map, boolean loggedIn) {
        System.out.println("Inserisci il tuo username");
        String username = stringScanner.nextLine();
        System.out.println("Inserisci la tua password");
        String password = stringScanner.nextLine();
        if (map.containsKey(username) && map.containsValue(password)) {
            loggedIn = true;
            System.out.println("Sei stato loggato");
        } else {
            loggedIn = false;
            System.out.println("Credenziali errate");
        }
    }

    //metodo che registra un utente nella HashMap degli utenti registrati
    public static void handleRegister(Scanner stringScanner, HashMap<String, String> map) {
        System.out.println("Inserisci il tuo nuovo username");
        String username = stringScanner.nextLine();
        System.out.println("Inserisci la tua nuova password");
        String password = stringScanner.nextLine();
        map.put(username, password);
    }
}
