package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

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

            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
