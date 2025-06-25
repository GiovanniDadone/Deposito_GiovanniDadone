import java.util.Scanner;

public class ProvaWhile {
    public static void main(String[] args) {
        int count = 1;


        //esempio while loop
        while (count <= 5) {
            count++;
            System.out.println(count);
        }

        //esempio do-while

        Scanner scanner = new Scanner(System.in);

        int num;
        do {
            System.out.println("Inserisci un numero (0 per uscire)");
            num = scanner.nextInt();
            scanner.nextLine();

        } while (count != 0);

        System.out.println("Hai inserito 0, programma terminato");
        scanner.close();
    }
}