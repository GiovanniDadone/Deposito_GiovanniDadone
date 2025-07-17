package com.giodad.controller;

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

public class DbUtils {
    // metodo per richiamare il create query tramite PreparedStatement, crea una
    // connessione ogni volta che viene chiamato
    public static void createCliente(String url, String user, String password, String nome, String email,
            String address, String city) {
        // stringa sql da PreparedStatement che inserisce il nuovo cliente coi dati
        // passati a ogni
        String sql = "INSERT INTO clienti (nome, email, address, city) VALUES (?, ?, ?, ?)";

        // apro la connessione e il PreparedStatement con un try-with-resources
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // setto i parametri con cui verrà inserito il nuovo cliente nel db
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, address);
            stmt.setString(4, city);

            // eseguo il prepared statement e salvo il numero delle righe influenzate
            // dall'esecuzione
            int affectedRows = stmt.executeUpdate();

            // printo quale id è stato generato con questa esecuzione
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int nuovoId = generatedKeys.getInt(1);
                    System.out.println("ID generato: " + nuovoId);
                }
            }

            System.out.println("Cliente inserito con successo!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo che printa tutti i clienti
    public static void readClienti(String url, String user, String password) {
        String sql = "SELECT * FROM clienti";

        // apro la connessione e il PreparedStatement con un try-with-resources
        try (Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop che printa tutti i dati di ogni singola riga nella tabella selezionata
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id_cliente") +
                                ", Nome: " + rs.getString("nome") +
                                ", Email: " + rs.getString("email") +
                                ", Address: " + rs.getString("address") +
                                ", City: " + rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo per aggiornare il nome e l'email di un cliente a partire dal suo id
    public static void updateCliente(String url, String user, String password, int id, String nuovoNome,
            String nuovaEmail) {
        String sql = "UPDATE clienti SET nome = ?, email = ? WHERE id_cliente = ?";

        // apro la connessione e il PreparedStatement con un try-with-resources
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // setto i parametri della query con cui gestire l'update
            stmt.setString(1, nuovoNome);
            stmt.setString(2, nuovaEmail);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " record modificati.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo per eliminare un cliente a partire dal suo Id
    public static void deleteCliente(String url, String user, String password, int id) {
        String sql = "DELETE FROM clienti WHERE id_cliente = ?";

        // apro la connessione e il PreparedStatement con un try-with-resources
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // eliminazione tramite il set dell'id
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            System.out.println(rowsAffected + " record eliminati.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // metodo che registra un utente nella HashMap degli utenti registrati
    public static void handleRegister(Scanner stringScanner, HashMap<String, String> map) {
        System.out.println("Inserisci il tuo nuovo username");
        String username = stringScanner.nextLine();
        System.out.println("Inserisci la tua nuova password");
        String password = stringScanner.nextLine();
        map.put(username, password);
    }

    // metodo che lavora l'input di numeri in modo che siano validi sempre
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

    // gestione dell'input tramite controllo di sicurezza che in presenza di un ";"
    // e droppa ogni carattere dopo, ";" compreso
    public static String handleStringInput(Scanner stringScanner) {
        String scelta;
        do {
            try {
                scelta = stringScanner.nextLine();

                // Rimuove punto e virgola e tutto ciò che segue
                int semicolonIndex = scelta.indexOf(';');

                // controllo che l'indice del semicolon sia un numero valido per il char array
                if (semicolonIndex != -1) {
                    scelta = scelta.substring(0, semicolonIndex);
                }

                scelta = scelta.trim();

                if (scelta.isEmpty()) {
                    System.out.println("Non puoi inserire una stringa vuota");
                }

            } catch (NoSuchElementException e) {
                System.out.println("Non puoi inserire una stringa vuota");
                scelta = "";
            }
        } while (scelta.isEmpty());

        return scelta;
    }
}
