package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

            // 1. Recupera tutti i clienti il cui nome inizia per A
            ResultSet clientiA = stmt.executeQuery("select c.first_name as Nome\n" + //
                    "from customer as c\n" + //
                    "where c.first_name like 'A%';");

            String columnName1 = clientiA.getMetaData().getColumnName(1);
            System.out.println(columnName1.toUpperCase());

            System.out.println("-------------------------------------------------------------");

            while (clientiA.next()) {
                System.out.println(clientiA.getString("Nome"));
            }

            // 2. Contare quanti clienti sono registrati per città
            ResultSet clientiCittà = stmt.executeQuery("select ct.city, count(*) as count\n" + //
                    "from customer c\n" + //
                    "join address a on a.address_id = c.address_id\n" + //
                    "join city ct on ct.city_id = a.city_id\n" + //
                    "group by ct.city\n" + //
                    "order by count desc;");

            int columnCount = clientiCittà.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(clientiCittà.getMetaData().getColumnName(i).toUpperCase());
                if (i < columnCount) {
                    System.out.print(" | ");
                }
            }

            System.out.println("-------------------------------------------------------------");

            while (clientiCittà.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    // prendo il valore della riga
                    String value = clientiCittà.getString(i);
                    // stampa il valore di della riga se non è nullo
                    System.out.print(value != null ? value : "NULL");
                    if (i < columnCount) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            System.out.println("==========================================================================");

            // 3. Mostrare i 5 clienti più recenti
            ResultSet clientiVecchi = stmt.executeQuery("select *\n" + //
                    "from customer c\n" + //
                    "order by c.create_date desc\n" +
                    "limit 5;");
            int columnCount2 = clientiVecchi.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount2; i++) {
                System.out.print(clientiVecchi.getMetaData().getColumnName(i).toUpperCase());
                if (i < columnCount2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            System.out.println("-------------------------------------------------------------");

            while (clientiVecchi.next()) {
                for (int i = 1; i <= columnCount2; i++) {
                    // prendo il valore della riga
                    String value = clientiVecchi.getString(i);
                    // stampa il valore di della riga se non è nullo
                    System.out.print(value != null ? value : "NULL");
                    if (i < columnCount2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

            System.out.println("==========================================================================");

            // 4. Ordinare tutti i clienti dal più vecchio al più recente e visualizzarli
            // con nome e data

            ResultSet tutti = stmt.executeQuery("select *\n" +
                    "from customer c\n" +
                    "order by c.create_date desc;");
            int columnCount3 = tutti.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount3; i++) {
                System.out.print(tutti.getMetaData().getColumnName(i).toUpperCase());
                if (i < columnCount3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();

            System.out.println("-------------------------------------------------------------");

            while (tutti.next()) {
                for (int i = 1; i <= columnCount3; i++) {
                    // prendo il valore della riga
                    String value = tutti.getString(i);
                    // stampa il valore di della riga se non è nullo
                    System.out.print(value != null ? value : "NULL");
                    if (i < columnCount3) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}