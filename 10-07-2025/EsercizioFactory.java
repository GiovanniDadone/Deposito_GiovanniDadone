import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioFactory {
    public static void main(String[] args) {
        Scanner intScanner = new Scanner(System.in);
        boolean uscita = false;
        IVeicolo veicolo = null;

        while (!uscita) {
            System.out.println("Scegli il tipo di veicolo da avviare");
            System.out.println("1. Auto");
            System.out.println("2. Moto");
            System.out.println("3. Camion");
            System.out.println("4. Exit");

            int scelta = 0;
            while (scelta == 0) {
                System.out.print("Scelta: ");
                try {
                    scelta = intScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Non è un numero");
                    intScanner.nextLine();
                    scelta = 0;
                }

                switch (scelta) {
                    case 1:
                        // Case 1 logic
                        veicolo = VeicoloFactory.creaVeicolo("auto");
                        veicolo.avvia();
                        break;

                    case 2:
                        // Case 2 logic
                        veicolo = VeicoloFactory.creaVeicolo("moto");
                        veicolo.avvia();
                        break;

                    case 3:
                        // Case 3 logic
                        veicolo = VeicoloFactory.creaVeicolo("camion");
                        veicolo.avvia();
                        break;

                    case 4:
                        uscita = true;
                        System.out.println("Uscita...");
                        break;

                    default:
                        System.out.println("Scelta non valida!");
                }
                System.out.println("----------------------------------");
            }

        }
        intScanner.close();
    }
}

//interfaccia base come aggreatore di tipo
interface IVeicolo {
    void avvia();

    //ho cambiato il tipo di ritorno così potevo usarlo all'interno del metodo avvia()
    String mostraTipo();
}

//implementazione IVeicolo in Auto
class Auto implements IVeicolo {

    @Override
    public void avvia() {

        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("Avvio dell'auto");
    }

    @Override
    public String mostraTipo() {
        return "Auto";
    }

}

//implementazione IVeicolo in Moto
class Moto implements IVeicolo {

    @Override
    public void avvia() {
        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("Avvio della moto");
    }

    @Override
    public String mostraTipo() {
        return "Moto";
    }

}

//implementazione IVeicolo in Camion
class Camion implements IVeicolo {

    @Override
    public void avvia() {
        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("Avvio del camion");
    }

    @Override
    public String mostraTipo() {
        return "Camion";
    }

}

// classe Creator che al richiamo del metodo creaVeicolo istanzia un oggetto
// differente a seconda della String passata come parametro
class VeicoloFactory {
    public static IVeicolo creaVeicolo(String tipo) {
        IVeicolo veicoloScelto = null;
        switch (tipo.toLowerCase()) {
            case "auto":
                veicoloScelto = new Auto();
                break;
            case "moto":
                veicoloScelto = new Moto();
                break;
            case "camion":
                veicoloScelto = new Camion();
                break;
            default:
                System.out.println("Scelta non valida");
        }
        return veicoloScelto;
    }
}