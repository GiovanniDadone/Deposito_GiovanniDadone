import java.util.Scanner;

public class GlobalScanner {
    private static Scanner numScanner = null;
    private static Scanner stringScanner = null;

    public static void InitScannerInputs() {
        numScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }

    public static int readIntInput() {
        return numScanner == null ? 0 : numScanner.nextInt();
    }

    public static String readStringInput() {
        return stringScanner == null ? "" : stringScanner.nextLine();
    }

    public static void CloseScannerInputs() {
        numScanner.close();
        stringScanner.close();
    }

    public static void clearIntBuffer() {
        numScanner.nextLine(); // Consuma l'input non valido rimasto nel buffer del main
    }

    public static void clearStringBuffer() {
        stringScanner.nextLine(); // Consuma l'input non valido rimasto nel buffer del main
    }
}