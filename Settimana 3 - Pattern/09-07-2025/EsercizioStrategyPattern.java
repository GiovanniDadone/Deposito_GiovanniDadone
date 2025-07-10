import java.util.Scanner;

public class EsercizioStrategyPattern {
    public static void main(String[] args) {

        //apertura scanner per l'input dell'utente
        Scanner intScanner = new Scanner(System.in);

        //istanziazione di un oggetto calcolatore
        Calcolatore calcolatore = new Calcolatore();


        //scelta dei numeri da lavorare
        System.out.println("Scegli il primo numero");
        int a = intScanner.nextInt();

        System.out.println("Scegli il secondo numero");
        int b = intScanner.nextInt();

        //ciclo per chiedere che tipo di strategia adottare
        while (true) {
            System.out.println("Cosa vuoi fare coi due numeri?");
            System.out.println("1. Addizione");
            System.out.println("2. Moltiplicazione");
            int strategiaScelta = intScanner.nextInt();
            if (strategiaScelta == 1) {
                //setta la strategia a Addizione
                calcolatore.setStrategy(new Addizione());
                calcolatore.performTask(a, b);
                break;
            } else if (strategiaScelta == 2) {
                //setta la strategia a Moltiplicazione
                calcolatore.setStrategy(new Moltiplicazione());
                calcolatore.performTask(a, b);
                break;
            } else {
                System.out.println("Strategia scelta non valida");
            }
        }
        intScanner.close();

    }
}

// interfaccia Strategy
interface Operazione {
    void esegui(int a, int b);
}

// strategie concrete, una esegue addizione e l'atra moltiplicazione
class Addizione implements Operazione {
    @Override
    public void esegui(int a, int b) {
        System.out.println("Risultato addizione: " + (a + b));
    }
}

class Moltiplicazione implements Operazione {
    @Override
    public void esegui(int a, int b) {
        System.out.println("Risultato moltiplicazione: " + (a * b));
    }
}

// Context
class Calcolatore {
    private Operazione strategy;

    public void setStrategy(Operazione strategy) {
        this.strategy = strategy;
    }

    // performTask() eseguo o l'addizione dei parametri o li moltiplica fra di loro
    // a seconda della Strategy scelta
    public void performTask(int a, int b) {
        strategy.esegui(a, b);
    }
}
