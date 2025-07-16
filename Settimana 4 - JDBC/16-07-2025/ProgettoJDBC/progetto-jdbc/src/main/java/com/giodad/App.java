package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/sakila";
        String USERNAME = "giovanni";
        String PASSWORD = "";

        // enuncia la connessione
        Connection connection = null;

        try {
            // Registra il Driver (solo se non caricato con Maven)
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Successfully connected");
            } else {
                System.out.println("Failed to connect");
            }

            // usare PreparedStatement per evitare SQL injection
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from actor"/* <-----inserire query */);

            ResultSetMetaData meta = set.getMetaData();
            int columnCount = meta.getColumnCount();
            
            System.out.println("=== TABELLA ACTOR ===");
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(meta.getColumnName(i));
                if (i < columnCount) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            // Stampa i dati
            int rowCount = 0;
            while (set.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = set.getString(i);
                    System.out.print(value != null ? value : "NULL");
                    if (i < columnCount) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                rowCount++;
                
                // Limita a 10 righe per non intasare l'output
                if (rowCount >= 10) {
                    System.out.println("... (mostrando solo le prime 10 righe)");
                    break;
                }
            }

            // while (set.next()) {
            // System.out.println();
            // System.out.print(set.getString(1) + " | ");
            // System.out.print(set.getString(2) + " | ");
            // System.out.print(set.getString(3) + " | ");
            // System.out.print(set.getString(4) + " | ");
            // System.out.print(set.getString(6) + " | ");
            // System.out.print(set.getString(7) + " | ");
            // System.out.print(set.getString(8) + " | ");
            // System.out.print(set.getString(9) + " | ");
            // System.out.print(set.getString(10) + " | ");
            // System.out.print(set.getString(11) + " | ");
            // System.out.print(set.getString(12) + " | ");
            // System.out.print(set.getString(13) + " | ");
            // System.out.print(set.getString(14) + " | ");
            // System.out.print(set.getString(15) + " | \n");
            // }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
