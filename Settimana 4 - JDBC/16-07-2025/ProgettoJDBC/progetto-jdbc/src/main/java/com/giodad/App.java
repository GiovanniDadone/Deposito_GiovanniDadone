package com.giodad;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/giovannidb";
    private static final String USERNAME = "giovanni";
    private static final String PASSWORD = "B@RGHa86$b";

    // metodo per ottenere una connessione
    public static Connection getConnection() throws SQLException {
        try {
            // carica il driver --DA RIVEDERE--
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Creazione della connesione, SI CHIAMA CONNETTORE
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connessione a MySQL riuscita!");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL non trovato: " + e.getMessage());
            throw new SQLException("Driver non disponibile", e);
        } catch (SQLException e) {
            System.err.println("Errore nella connessione: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        String DB_DRIVER = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/giovannidb";
        String USERNAME = "giovanni";
        String PASSWORD = "B@RGHa86$b";

        // enuncia la connessione
        Connection connection = null;

        try {
            // Registra il Driver (solo se non caricato con Maven)
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(connection != null) {
                System.out.println("Successfully connected");
            } else {
                System.out.println("Failed to connect");
            }

            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery(""/*<-----inserire query */);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
