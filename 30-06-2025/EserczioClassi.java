import java.util.ArrayList;
import java.util.Scanner;

public class EserczioClassi {
    static class BankAccount {
        String username;
        String password;
        boolean isLoggedIn = false;
        double balance;

        public BankAccount(String username, String password) {
            this.username = username;
            this.password = password;

            //inizializzazione del saldo iniziale in un certo range usando Math.random()
            int max = 1500;
            int min = 500;
            this.balance = (int) (Math.random() * (max - min + 1)) + min;
        }

        //metodo che cambia la variabile isLoggedIn e far capire quale account è loggato
        boolean login(String username, String password) {
            if (this.username.equals(username) && this.password.equals(password)) {
                isLoggedIn = true;
                System.out.println("Credenziali di login corrette");
            }
            return this.isLoggedIn;
        }

        //metodo che gestisce il deposito
        void deposit(double amount) {
            this.balance += amount;
            System.out.println("Hai depositato: " + amount + "$\nSaldo attuale: " + this.balance);
        }

        //metodo che gestisce il prelievo con invalidamento dei prelievi con saldo negativo
        void withdraw(double amount) {

            boolean inputValido = false;
            while (!inputValido) {
                if (amount > balance) {
                    System.out.println("Saldo al negativo, non è possibile ritirare così tanto");
                } else {
                    balance -= amount;
                    System.out.println("Hai ritirato: " + amount + "$");
                    System.out.println("Saldo attuale: " + this.balance);
                    inputValido = true;
                }
            }

        }

        //metodo per fare vedere il saldo
        void displayBalance() {
            System.out.println("The current balance is: " + this.balance);
        }
    }

    public static void main(String[] args) {

        //inizializzazione degli oggetti BankAccount
        ArrayList<BankAccount> accountList = new ArrayList<>();
        accountList.add(new BankAccount("Josh", "pass123"));
        accountList.add(new BankAccount("Alberto", "pass123"));
        accountList.add(new BankAccount("Piero", "pass123"));
        accountList.add(new BankAccount("Giovanni", "pass123"));

        Scanner scannerStringhe = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        boolean inputValido = false;


        //loop per l'inserimento delle credenziali, finchè non sono corrette le richiede senza poter andare avanti
        while (!inputValido) {
            System.out.println("Inserisci le credenziali:\nUsername: ");
            String username = scannerStringhe.nextLine();
            System.out.println("Password");
            String password = scannerStringhe.nextLine();

            for (BankAccount bankAccount : accountList) {
                boolean accesso = bankAccount.login(username, password);

                //operazione valida solo per l'account che risulta loggato, totalmente ignorato per gli altri
                if (accesso) {
                    inputValido = true;

                    boolean inputValido2 = false;

                    //secodno loop per la gestione del singolo account
                    while (!inputValido2) {
                        System.out.println("""
                                Che operazione desideri fare?
                                1. Deposita
                                2. Ritira
                                3. Mostra saldo del conto
                                4. Esci""");
                        int scelta = scannerInt.nextInt();
                        switch (scelta) {
                            case 1:
                                System.out.println("Quanto vuoi depositare?");
                                double deposito = scannerInt.nextDouble();
                                bankAccount.deposit(deposito);
                                break;
                            case 2:
                                System.out.println("Quanto vuoi prelevare?");
                                double prelievo = scannerInt.nextDouble();
                                bankAccount.withdraw(prelievo);
                                break;
                            case 3:
                                bankAccount.displayBalance();

                                break;
                            case 4:
                                inputValido2 = true;
                            default:
                                System.out.println("Scelta, non valida riprova");
                                break;
                        }
                    }

                } else {
                    System.out.println("Credenziali errate, ritenta");
                }
            }
        }

        scannerInt.close();
        scannerStringhe.close();

    }
}
