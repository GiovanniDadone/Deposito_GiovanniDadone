import java.util.Scanner;

public class EsercizioSistemaUtenti {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        MenuFacade menu = new MenuFacade();

        menu.loopMenu(intScanner, stringScanner);
    }
}
