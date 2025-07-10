import java.util.Scanner;

public class ProvaForLoop {
    public static void main(String[] args) {
        //apertura scanner per prendere l'input dell'utente dalla console
        Scanner scanner = new Scanner(System.in);

        //richiesta di input da parte dell'utente tramite scanner di un int
        System.out.println("Inserisci un numero per stamparne la tabellina corrispondente");
        int numero = scanner.nextInt();
        scanner.nextLine();

        //loop di 10 cicli hardcodati per stampare la tabellina corrispondente
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + numero * i);
        }
        scanner.close();
    }
}