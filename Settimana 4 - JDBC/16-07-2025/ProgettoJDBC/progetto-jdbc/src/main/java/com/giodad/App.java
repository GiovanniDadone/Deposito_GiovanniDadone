package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
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
        
    }
}
