import java.util.InputMismatchException;
import java.util.Scanner;

public class EsercizioStrategy2 {
    public static void main(String[] args) {
        // apertura scanner per l'input dell'utente
        Scanner intScanner = new Scanner(System.in);

        // ciclo per chiedere che tipo di strategia adottare
        while (true) {
            System.out.println("Con che metodo di pagamento vuoi procedere?");
            System.out.println("1. Carta di Credito");
            System.out.println("2. PayPal");
            int strategiaScelta = intScanner.nextInt();

            // istanzia il PagamentoContext con la strategia sc
            PagamentoContext context = PagamentoContext.getInstance(strategiaScelta);
            // scelta dell'importo condizionale alla presenza o meno di una strategia

            if (PagamentoContext.getStrategy() != null) {
                int importo = 0;
                System.out.println("Quant'è l'importo?");

                // try/catch per gestire che l'importo sia effettivamente un numero
                try {
                    // ricezione dell'input dall'utente
                    importo = intScanner.nextInt();
                    // esecuzione del pagamento
                    context.performTask(importo);
                } catch (InputMismatchException e) {
                    // porta direttamente alla richiesta di ricominciare o meno
                    System.out.println("Non è un numero,riprova");
                }

            } else {

                // se la strategia scelta non è valida, ricomincia il ciclo passando dal check
                // per ricominciare
                System.out.println("Metodo di pagamento non scelto, riprovare");
            }

            // check condizoinale per ricominciare il loop o uscirne
            System.out.println("Vuoi ricominciare? 1.si 2.no");
            int uscita = intScanner.nextInt();
            if (uscita == 2) {
                break;
            }
        }

        // chiusura degli scanner
        intScanner.close();
    }
}

// sistema di pagamento
// interfaccia Strategy/MetodoDiPagamento
interface MetodoDiPagamento {
    void eseguiPagamento(double importo);
}

// classe base astratta del Decorator Patern alla quale le due strategie si
// implementano come decoratori in tutto e per tutto
abstract class PagamentoAstratto implements MetodoDiPagamento {
    @Override
    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento eseguito || Importo: " + importo + "€");
    }

}

// strategie concrete dei metodi di pagamento
class CartaDiCredito extends PagamentoAstratto {
    @Override
    // l'importo è passato direttamente dal main
    public void eseguiPagamento(double importo) {
        // richiamo del metodo super della classe astratta
        super.eseguiPagamento(importo);
        System.out.println("Metodo di Pagamento: Carta di Credito");
    }
}

class PayPal extends PagamentoAstratto {
    @Override
    // l'importo è passato direttamente dal main
    public void eseguiPagamento(double importo) {
        // richiamo del metodo super della classe astratta
        super.eseguiPagamento(importo);
        System.out.println("Metodo di Pagamento: PayPal");
    }
}

// PagamentoContext: simula lo stabilirsi di una connessione di pagamento sicura
class PagamentoContext {
    private static PagamentoContext context;
    private static PagamentoAstratto strategy;

    // metodo statico privato che setta la strategia da usare, utilizzat solo nel
    // metodo getInstance()
    private static void setStrategy(PagamentoAstratto strategy) {
        PagamentoContext.strategy = strategy;
    }

    public static PagamentoAstratto getStrategy() {
        return strategy;
    }

    // metodo getInstance singleton che esita strategie differenti a seconda del
    // parametro int passato
    public static PagamentoContext getInstance(int strategia) {
        if (context == null) {
            context = new PagamentoContext();
        }
        if (strategia == 1) {
            setStrategy(new CartaDiCredito());
        } else if (strategia == 2) {
            setStrategy(new PayPal());
        } else {
            System.out.println("Strategia non settata, riprovare");
        }
        return context;
    }

    // performTask() come da programma non si cura di quale sia la strategia
    // implementata, semplicemente esegue la task della strategia
    public void performTask(double importo) {
        // se l'importo è minore di zero non performa la task
        if (importo < 0) {
            System.out.println("Importo non valido, deve essere maggiore di zero");
            return;
        }
        strategy.eseguiPagamento(importo);
    }
}