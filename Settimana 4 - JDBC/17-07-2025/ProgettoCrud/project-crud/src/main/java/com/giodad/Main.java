package com.giodad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.giodad.controller.DbUtils;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    public static void main(String[] args) {
        // carico le variabili d'ambiente tramite Dotenv
        Dotenv dotenv = Dotenv.configure()
                .directory(
                        "project-crud\\.env")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
        // salvo le variabili caricate in String a parte
        String url = dotenv.get("DB_URL");
        String usr = dotenv.get("DB_USERNAME");
        String pswd = dotenv.get("DB_PASSWORD");

        // creo la referenze della connessione(vuota per aumentarne lo scope)
        Connection conn = null;
        try {
            // apro la connessione per confermare il collegamento al db
            conn = DriverManager.getConnection(url, usr, pswd);
            if (conn != null) {
                System.out.println("Connessione riuscita");
            } else {
                System.out.println("Errore nella connessione");
            }

            // metodo statico del main che richiama tutto il menu
            menuFacade(url, usr, pswd);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ultimo try-catch giusto per chiudere la connessione inizialmente aperta per
            // il messaggio di healthcheck
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // metodo che aziona tutto il menu principale
    public static void menuFacade(String url, String user, String password) {
        //apertura degli scanner
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);
        boolean uscita = false;

        while (!uscita) {
            //metodo per mostrare il menu
            displayMenu();

            int scelta = DbUtils.handleIntInput(intScanner);

            switch (scelta) {
                case 1:
                    // chiedi tutti i dati necessari per la crezione di un nuovo utente
                    System.out.println("Inserisci il nome del nuovo cliente");
                    String nomeNuovoCliente = DbUtils.handleStringInput(stringScanner);

                    System.out.println("Inserisci l'email del nuovo cliente");
                    String emailNuovoCliente = DbUtils.handleStringInput(stringScanner);

                    System.out.println("Inserisci l'indirizzo del nuovo cliente");
                    String addressNuovoCliente = DbUtils.handleStringInput(stringScanner);

                    System.out.println("Inserisci la città del nuovo cliente");
                    String cityNuovoCliente = DbUtils.handleStringInput(stringScanner);
                    DbUtils.createCliente(url, user, password,
                            nomeNuovoCliente,
                            emailNuovoCliente,
                            addressNuovoCliente,
                            cityNuovoCliente);
                    break;

                case 2:
                    // chiama il metodo statico per printare tutti i clienti
                    DbUtils.readClienti(url, user, password);
                    break;

                case 3:
                    // metodo di UPDATE dove chiede l'id che si vuole aggiornare e i nuovi valori di nome e email
                    System.out.println("Inserisci l'id dell'utente da aggiornare cliente");
                    int idDaAggiornare = DbUtils.handleIntInput(intScanner);

                    System.out.println("Inserisci il nome aggiornato");
                    String nomeAggiornato = DbUtils.handleStringInput(stringScanner);

                    System.out.println("Inserisci l'email aggiornata");
                    String emailAggiornata = DbUtils.handleStringInput(stringScanner);
                    DbUtils.updateCliente(url, user, password,
                            idDaAggiornare,
                            nomeAggiornato,
                            emailAggiornata);
                    break;

                case 4:
                    // Metodo per il DELETE tramite richiesta di id
                    System.out.println("Inserisci l'id del cliente da eliminare");
                    int idDaEliminare = DbUtils.handleIntInput(intScanner);
                    DbUtils.deleteCliente(url, user, password, idDaEliminare);
                    break;

                case 5:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        }
        intScanner.close();
        stringScanner.close();
    }

    // metodo che printa in console il menu
    public static void displayMenu() {
        System.out.println("Menu Title");
        System.out.println("1. Inserisci nuovo cliente");
        System.out.println("2. Lista di tutti i clienti");
        System.out.println("3. Aggiorna i dati di un cliente");
        System.out.println("4. Elimina un cliente dal numero del suo id");
        System.out.println("5. Exit");
        System.out.print("Scelta: ");
    }

}