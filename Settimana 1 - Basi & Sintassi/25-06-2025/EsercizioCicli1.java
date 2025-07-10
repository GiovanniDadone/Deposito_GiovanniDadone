import java.util.Scanner;

public class EsercizioCicli1 {
    public static void main(String[] args) {
        Scanner scannerStringhe = new Scanner(System.in);

        //stringa non inizializzata per la nuova password
        String password;

        System.out.println("Inserisci una nuova password");
        password = scannerStringhe.nextLine();  //password inizializzata col valore espresso dall'utente

        System.out.println("Vuoi accedere al sistema? (s/n)");
        char choice = scannerStringhe.nextLine().toLowerCase().charAt(0);  //concatenazione di metodi per essere sicuro esca un char


        //booleano che definisce il ciclo primario tentativo d'accesso/accesso annullato
        boolean flag1 = false;

        while (!flag1) {
            if (choice == 's') {


                int tentativi = 3;  //variabile int locale per definire gli accessi rimasti
                do {
                    System.out.println("Tentativi rimasti: " + tentativi);
                    System.out.println("Inserisci la password memorizzata");
                    String passwordInput = scannerStringhe.nextLine();
                    if (passwordInput.equals(password)) {
                        System.out.println("Accesso al sistema effettuato");
                        flag1 = true; //per uscire dal ciclo primario
                        break; //esce dal do-while loop
                    } else {
                        System.out.println("Password errata");
                        tentativi--;  //diminuzione dei tentativi rimasti
                    }
                } while (tentativi > 0);


                if (tentativi == 0) {
                    System.out.println("Tentativi terminati. Accesso bloccato");
                    flag1 = true;  //uscita dal ciclo primario
                }


            } else if (choice == 'n') {
                System.out.println("Accesso annullato");
                flag1 = true;  //scelta 'n' gestita uscendo dal loop


            } else {
                System.out.println("Comando on riconosciuto");  //il while loop del ciclo primario continua
            }
        }

    }
}
