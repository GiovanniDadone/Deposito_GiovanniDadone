import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        NotificationService service = NotificationService.getInstance();

        SMSFactory factory = new SMSFactory();
        EmailFactory factory2 = new EmailFactory();

        boolean uscita = false;

        while (!uscita) {
            System.out.println("Menu Notfiche");
            System.out.println("1. Aggiungi Utente");
            System.out.println("2. Notifica Utenti tramite SMS");
            System.out.println("3. Notifica Utenti tramite Email");
            System.out.println("4. Exit");
            System.out.print("Scelta: ");

            if (!intScanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                intScanner.next(); // Consuma l'input errato
                continue;
            }

            int scelta = intScanner.nextInt();
            intScanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // Case 1 logic
                    System.out.println("Inserisci nome utente");
                    String nome = stringScanner.nextLine();
                    service.registerObserver(new User(nome));
                    break;

                case 2:
                    // Case 2 logic
                    service.setNotification(factory.factoryMethod());
                    service.notifyObservers("SMS ricevuto");
                    break;

                case 3:
                    // Case 3 logic
                    service.setNotification(factory2.factoryMethod());
                    service.notifyObservers("Email ricevuta");
                    break;

                case 4:
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
}
