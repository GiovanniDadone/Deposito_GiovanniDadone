import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // istanziazione facade
        MenuFacade menu = new MenuFacade();

        // uso del metodo facade
        menu.avviaMenu(scanner);

        // chiusura risorse per buona pratica
        scanner.close();
    }
}

// pattern di faccia che nasconde la logica di asseganzione del metodo di
// pagamento al main
class MenuFacade {
    public void avviaMenu(Scanner scanner) {
        SistemaDiPagamento sistema = null;
        ;
        CreatorePagamento creatore;

        System.out.println("Come vuoi pagare?");
        System.out.println("1. Carta");
        System.out.println("2. PayPal");
        System.out.println("3. Crypto");
        System.out.println("4. Exit");
        System.out.print("Scelta: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Input non valido! Inserisci un numero.");
            scanner.next(); // Consuma l'input errato
        }

        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        switch (scelta) {
            case 1:
                // Caso carta di credito
                creatore = new CreatoreCarta();
                sistema = creatore.istanziaPagamento();
                break;

            case 2:
                // Caso PayPal
                creatore = new CreatorePayPal();
                sistema = creatore.istanziaPagamento();
                break;

            case 3:
                // Caso di uso delle crypto
                creatore = new CreatoreCrypto();
                sistema = creatore.istanziaPagamento();
                break;
            default:
                System.out.println("Scelta non valida!");
        }
        sistema.pagamento();
    }
}

// SistemaDiPagamento: definisce l'interfaccia base
interface SistemaDiPagamento {
    void pagamento();
}

// Carta: implementa SistemaDiPagamento
class Carta implements SistemaDiPagamento {
    @Override
    public void pagamento() {
        System.out.println("$$$---Pagamento con carta avvenuto!");
    }
}

// PayPal: implementa SistemaDiPagamento
class PayPal implements SistemaDiPagamento {
    @Override
    public void pagamento() {
        System.out.println("$$$$----Pagamento avvenuto tramite PayPal");
    }
}

// Crypto: implementa SistemaDiPagamento
class Crypto implements SistemaDiPagamento {
    @Override
    public void pagamento() {
        System.out.println("$$$$----Pagamento avvenuto mediante criptovalute");
    }
}

// CreatorePagamento: dichiara il Factory Method
abstract class CreatorePagamento {
    // Factory Method: restituisce un SistemaDiPagamento
    public abstract SistemaDiPagamento istanziaPagamento();
}

// CreatoreCarta: implementa factoryMethod per Carta
class CreatoreCarta extends CreatorePagamento {
    @Override
    public SistemaDiPagamento istanziaPagamento() {
        return new Carta();
    }
}

// CreatorePayPal: implementa factoryMethod per PayPal
class CreatorePayPal extends CreatorePagamento {
    @Override
    public SistemaDiPagamento istanziaPagamento() {
        return new PayPal();
    }
}

// CreatoreCrypto: implementa factoryMethod per criptovalute
class CreatoreCrypto extends CreatorePagamento {
    @Override
    public SistemaDiPagamento istanziaPagamento() {
        return new Crypto();
    }
}
