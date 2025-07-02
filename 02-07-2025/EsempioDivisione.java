import java.util.InputMismatchException;
import java.util.Scanner;

public class EsempioDivisione {
    public static int divisioneChecked(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception();
        }
        return a / b;
    }

    public static int divisioneUnchecked(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Il secondo operando non può essere zero");
        }
        return a / b;
    }

    public static int divione3(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            throw new RuntimeException("Il secondo operando non può essere zero", e);
        }
    }

    public static void main(String[] args) {

        // try {
        // divisioneChecked(3, 2);
        // try {
        // divisioneUnchecked(3, 0);
        // } catch (Exception e) {
        // e.printStackTrace();
        // String message = e.getMessage();
        // System.out.println(message);
        // }
        // System.out.println("ue ue");
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Inserire un numero");
            int numero = scanner.nextInt();
            int risultato = divisioneUnchecked(numero, 0);
            System.out.println(risultato);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Programma terminato");
    }
}
