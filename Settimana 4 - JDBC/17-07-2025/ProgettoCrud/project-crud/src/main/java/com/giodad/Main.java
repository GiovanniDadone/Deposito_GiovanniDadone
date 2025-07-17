package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .directory(
                        "C:\\Users\\argir\\Documents\\GitHub\\Deposito_GiovanniDadone\\Settimana 4 - JDBC\\17-07-2025\\ProgettoCustomer\\progetto-customer\\.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        String url = dotenv.get("DB_URL");
        String usr = dotenv.get("DB_USERNAME");
        String pswd = dotenv.get("DB_PASSWORD");

        try {
            Connection conn = DriverManager.getConnection(url, usr, pswd);
            if (conn != null) {
                System.out.println("Connessione riuscita");
            } else {
                System.out.println("Errore nella connessione");
            }

            Statement stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}