package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.configure()
                .directory(
                        "project-crud\\.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String url = dotenv.get("DB_URL");
        String usr = dotenv.get("DB_USERNAME");
        String pswd = dotenv.get("DB_PASSWORD");
        Connection conn = DriverManager.getConnection(url, usr, pswd);
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Connessione riuscita");
            } else {
                System.out.println("Errore nella connessione");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo per richiamare il create query in SQL tramite SQL
    public static void createCliente(String nome, String email, String address, String city) {
        String sql = "INSERT INTO clienti (nome, email, address, city) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, address);
            stmt.setString(4, city);
            stmt.executeUpdate();

            System.out.println("Cliente inserito con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readClienti() {
        String sql = "SELECT * FROM clienti";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Nome: " + rs.getString("nome") +
                                ", Cognome: " + rs.getString("cognome") +
                                ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCliente(int id, String nuovoNome, String nuovaEmail) {
        String sql = "UPDATE clienti SET nome = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuovoNome);
            stmt.setString(2, nuovaEmail);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " record modificati.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCliente(int id) {
        String sql = "DELETE FROM clienti WHERE id = ?";

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " record eliminati.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo che controlla le credenziali inserite per gestire il boolean di
    // loggedIn
    public static boolean handleLogin(Scanner stringScanner, HashMap<String, String> map, boolean loggedIn) {
        System.out.println("Inserisci il tuo username");
        String username = stringScanner.nextLine();
        System.out.println("Inserisci la tua password");
        String password = stringScanner.nextLine();
        if (map.containsKey(username) && map.containsValue(password)) {
            loggedIn = true;
            System.out.println("Sei stato loggato");
        } else {
            System.out.println("Credenziali errate");
        }
        return loggedIn;
    }

    // metodo che registra un utente nella HashMap degli utenti registrati
    public static void handleRegister(Scanner stringScanner, HashMap<String, String> map) {
        System.out.println("Inserisci il tuo nuovo username");
        String username = stringScanner.nextLine();
        System.out.println("Inserisci la tua nuova password");
        String password = stringScanner.nextLine();
        map.put(username, password);
    }

    public static int handleIntInput(Scanner intScanner) {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = intScanner.nextInt();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            intScanner.nextLine(); // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }

    public static String handleStringInput(Scanner stringScanner) {
        String scelta = "Vuoto";
        while (scelta.equalsIgnoreCase("Vuoto")) {
            try {
                scelta = stringScanner.nextLine();
                break;
            } catch (NoSuchElementException e) {
                // messaggio di errore e reset del ciclo con scelta = 0
                System.out.println("Non puoi inserire una stringa vuota");
                scelta = "Vuoto";
            }
        }
        return scelta;
    }

}