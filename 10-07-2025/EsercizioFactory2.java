import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioFactory2 {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);

        while (true) {
            // mostra il menù
            MenuFacade.displayMenu();

            // solito blocco per gestire l'input dell'utente correttamente, un while loop
            // che si ripete finchè la scelta è uguale a 0
            int scelta = 0;
            while (scelta == 0) {
                scelta = MenuFacade.ottieniInput(intScanner);
            }
            // sceglie la forma e la disgna in console
            MenuFacade.sceltaForma(scelta);
            // se la scelta è 3 si esce da programma come mostrato sul menu menù, altrimenti
            // si resetta sullo zero
            if (scelta == 3) {
                break;
            } else {
                scelta = 0;
            }
            // spaziatura d'ordinanza
            System.out.println();

        }
        // chiusura scanner per buona pratica
        intScanner.close();
    }
}

// IShape: definisce l'interfaccia delle forme
interface IShape {
    void disegna();
}

// Circle: implementa il disegno di un cerchio
class Circle implements IShape {
    @Override
    public void disegna() {
        System.out.println("    ***    ");
        System.out.println("  *     *  ");
        System.out.println(" *       * ");
        System.out.println(" *       * ");
        System.out.println("  *     *  ");
        System.out.println("    ***    ");
    }
}

// 3. Square: implementa il disegno di un quadrato
class Square implements IShape {
    @Override
    public void disegna() {
        System.out.println("********");
        System.out.println("*      *");
        System.out.println("*      *");
        System.out.println("*      *");
        System.out.println("*      *");
        System.out.println("********");
    }
}

// ShapeCreator: dichiara il Factory Method creaForma()
abstract class ShapeCreator {
    // creaForma(): restituisce una forma IShape
    public abstract IShape creaForma();

    // Un metodo del creator che utilizza le funzioni delle forme
    public void disegna() {
        IShape product = creaForma(); // creazione della formaa
        product.disegna(); // uso del metodo disegna() della forma
    }
}

// implementa disegna forma
class CircleFactory extends ShapeCreator {
    @Override
    public Circle creaForma() {
        return new Circle();
    }
}

// implementa disegnaFroma()
class SquareFactory extends ShapeCreator {
    @Override
    public Square creaForma() {
        return new Square();
    }
}

// facade Menu + strategy con direttamente il subject
class MenuFacade {
    // istanza privata e statica della strategia scelta, che può essere o il
    // CircleFactory o lo SquareFactory
    private static ShapeCreator creator;

    // semplice display delle scelte
    public static void displayMenu() {
        System.out.println("=========MENU DELLE FORME===========");
        System.out.println("Che forma vuoi disegnare?");
        System.out.println("1. Cerchio");
        System.out.println("2. Quadrato");
        System.out.println("3. Uscita");
        System.out.print("Scelta: ");
    }

    // metodo statico con uno switch case setta la strategia usata a seconda della
    // scelta
    // dell'utente
    public static void sceltaForma(int scelta) {
        switch (scelta) {
            case 1:
                setStrategy(new CircleFactory());
                creator.disegna(); // Usa Circle Factory
                break;
            case 2:
                setStrategy(new SquareFactory());
                creator.disegna(); // Usa Square Factory
                break;
            case 3:
                System.out.println("Uscita...");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

    // semplice metodo statico privato da richiamare internamente(beccati
    // l'incapsulamento e l'astrazione)
    private static void setStrategy(ShapeCreator newCreator) {
        creator = newCreator;
    }

    // metodo che gestisce l'input dell'utente
    public static int ottieniInput(Scanner intScanner) {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = intScanner.nextInt();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            intScanner.nextLine(); // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }
}