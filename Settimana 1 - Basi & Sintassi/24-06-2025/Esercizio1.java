import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input carattere
        System.out.print("inserisci un carattere: ");
        char a = scanner.nextLine().charAt(0);
        System.out.println("Character: " + a);

        // Input intero
        System.out.print("Inserisci un numero intero: ");
        int num1 = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("numero intero: " + num1);

        // Input stringa
        System.out.print("Inserisci una parola: ");
        String string = scanner.nextLine();
        System.out.println("stringa: " + string);

        // Input short
        System.out.print("inserisci un numero (short): ");
        short myShort = scanner.nextShort();
        scanner.nextLine(); 
        System.out.println("numero short: " + myShort);

        // Input double
        System.out.print("inserisci un numero con la VIRGOLA: ");
        double myDoubleProva = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("numero double: " + myDoubleProva);

        // Input float
        System.out.print("inserisci un numero con la VIRGOLA: ");
        float myFloat = scanner.nextFloat();
        System.out.println("numro float: " + myFloat);

        // Cast automatico da int a double
        int myNum = 9;
        double myDouble = myNum;
        System.out.println("int originario: " + myNum);
        System.out.println("castato a double: " + myDouble);

        // Cast manuale da double a int
        double myDouble2 = 8.44;
        int myInt2 = (int) myDouble2; 
        System.out.println("Original double: " + myDouble2);
        System.out.println("castato a int: " + myInt2);

        scanner.close();
    }
}
