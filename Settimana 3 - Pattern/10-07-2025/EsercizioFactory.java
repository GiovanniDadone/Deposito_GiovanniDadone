import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioFactory {
    public static void main(String[] args) {
        // apertura scanner per numeri interi
        Scanner intScanner = new Scanner(System.in);

        // apertura facde per il menu
        VeicoloFacade facade = new VeicoloFacade();

        // ciclo principale che applica le logiche del facade
        boolean uscita = false;
        while (!uscita) {
            System.out.println("Scegli il tipo di veicolo da avviare");
            System.out.println("1. Auto");
            System.out.println("2. Moto");
            System.out.println("3. Camion");
            System.out.println("4. Exit");

            int scelta = 0;
            // mini ciclo che gestisce la scelta e i suoi errori
            while (scelta == 0) {
                System.out.print("Scelta: ");
                // gestione try catch in caso ci sia un inputMismatch
                try {
                    scelta = intScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Non è un numero");
                    intScanner.nextLine();  //consuma il \n a fine input da non intero (eventuale)
                    scelta = 0; //scelta rimessa a = per non uscire dal ciclo principale
                }

                switch (scelta) {

                    case 1:
                        // Case 1 logic
                        facade.avvia("auto");
                        break;

                    case 2:
                        // Case 2 logic
                        facade.avvia("moto");
                        break;

                    case 3:
                        // Case 3 logic
                        facade.avvia("camion");
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

// interfaccia base come aggreatore di tipo
interface IVeicolo {
    void avvia();

    // ho cambiato il tipo di ritorno così potevo usarlo all'interno del metodo
    // avvia()
    String mostraTipo();
}

// implementazione IVeicolo in Auto
class Auto implements IVeicolo {

    @Override
    public void avvia() {

        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("--------Avvio: " + mostraTipo().toLowerCase() + "-------------");
    }

    @Override
    public String mostraTipo() {
        return "Auto";
    }

}

// implementazione IVeicolo in Moto
class Moto implements IVeicolo {

    @Override
    public void avvia() {
        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("--------Avvio: " + mostraTipo().toLowerCase() + "-------------");
    }

    @Override
    public String mostraTipo() {
        return "Moto";
    }

}

// implementazione IVeicolo in Camion
class Camion implements IVeicolo {

    @Override
    public void avvia() {
        System.out.println("========ACCENSIONE: " + mostraTipo().toUpperCase() + "========");
        System.out.println("--------Avvio: " + mostraTipo().toLowerCase() + "-------------");
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

class VeicoloFacade {
    public void avvia(String tipo) {
        IVeicolo veicolo = VeicoloFactory.creaVeicolo(tipo);
        veicolo.avvia();
    }
}