import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioStrategy2 {
    public static void main(String[] args) {
        // apertura scanner per l'input dell'utente
        Scanner intScanner = new Scanner(System.in);

        // lista dell'ordine di canne da pesca
        ArrayList<Prodotto> ordine = new ArrayList<>();

        ControllorePrezzi control = new ControlloreConcreto();
        control.registraProdotto(new CannaConMulinello());
        control.registraProdotto(new CannaDaSuperfice());
        control.registraProdotto(new CannaDaConEsca());

        // ciclo per la richiesta di prodotti
        while (true) {
            System.out.println("Che prodotto vuoi comprare?");
            System.out.println("1. Canna da pesca con mulinello");
            System.out.println("2. Canna da pesca da superficie");
            System.out.println("3. Canna da pesca con esca");
            int cannaScelta = intScanner.nextInt();
            switch (cannaScelta) {
                case 1:
                    ordine.add(new CannaConMulinello());
                    break;
                case 2:
                    ordine.add(new CannaDaSuperfice());
                    break;
                case 3:
                    ordine.add(new CannaDaConEsca());
                    break;
                default:
                    break;
            }
            System.out.println("Vuoi completare l'ordine e proseguire col pagamento? 1. si/ 2. no");
            int uscitaOrdine = intScanner.nextInt();
            if (uscitaOrdine == 1) {
                break;
            }
            control.setTotale();
        }

        // ciclo per chiedere che tipo di strategia adottare
        while (true) {
            System.out.println("Con che metodo di pagamento vuoi procedere?");
            System.out.println("1. Carta di Credito");
            System.out.println("2. PayPal");
            int strategiaScelta = intScanner.nextInt();

            // istanzia il PagamentoContext con la strategia sc
            ConnessionePagamento context = ConnessionePagamento.getInstance(strategiaScelta);
            // scelta dell'importo condizionale alla presenza o meno di una strategia

            if (ConnessionePagamento.getStrategy() != null) {
                // esecuzione del pagamento
                context.performTask(control.getTotale());
            } else {
                // se la strategia scelta non è valida, ricomincia il ciclo passando dal check
                // per ricominciare
                System.out.println("Metodo di pagamento non scelto, riprovare");
            }

            // check condizoinale per ricominciare il loop o uscirne
            System.out.println("Vuoi comprare un alrto prodotto? 1.si 2.no");
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
class ConnessionePagamento {
    private static ConnessionePagamento context;
    private static PagamentoAstratto strategy;

    // metodo statico privato che setta la strategia da usare, utilizzat solo nel
    // metodo getInstance()
    private static void setStrategy(PagamentoAstratto strategy) {
        ConnessionePagamento.strategy = strategy;
    }

    public static PagamentoAstratto getStrategy() {
        return strategy;
    }

    // metodo getInstance singleton che esita strategie differenti a seconda del
    // parametro int passato
    public static ConnessionePagamento getInstance(int strategia) {
        if (context == null) {
            context = new ConnessionePagamento();
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

interface Prodotto {
    void update(int prezzo);
}

interface ControllorePrezzi {
    void registraProdotto(Prodotto o);

    void rimuoviProdotto(Prodotto o);

    void notificaCambioPrezzi();

    void setTotale();

    int getTotale();
}

class ControlloreConcreto implements ControllorePrezzi {
    private List<Prodotto> observers = new ArrayList<>();
    private int prezzo;
    private int totale;

    public void setState(int prezzo) {
        this.prezzo = prezzo;
        notificaCambioPrezzi();
    }

    @Override
    public void registraProdotto(Prodotto o) {
        observers.add(o);
    }

    @Override
    public void rimuoviProdotto(Prodotto o) {
        observers.remove(o);
    }

    @Override
    public void notificaCambioPrezzi() {
        for (Prodotto observer : observers) {
            observer.update(prezzo);
        }
    }

    public int getTotale() {
        return totale;
    }

    public void setTotale() {
        int totale = 0;
        for (Prodotto prodotto : observers) {
            totale += ((CannaDaPesca) prodotto).getPrezzoProdotto();
        }
        this.totale = totale;
    }

}

abstract class CannaDaPesca implements Prodotto {
    private String name;
    private int prezzoProdotto;

    public CannaDaPesca(String name) {
        this.name = name;
    }

    @Override
    public void update(int prezzo) {
        setPrezzo(prezzo);
        System.out.println(name + " : cambio di prezzo = " + prezzoProdotto);
    }

    public void setPrezzo(int prezzo) {
        this.prezzoProdotto = prezzo;
    }

    public String getName() {
        return name;
    }

    public int getPrezzoProdotto() {
        return prezzoProdotto;
    }

}

class CannaConMulinello extends CannaDaPesca {

    public CannaConMulinello() {
        super("Canna con mulinello");
        maggiorazione();
    }

    public void maggiorazione() {
        setPrezzo(this.getPrezzoProdotto() + 12);
    }

    @Override
    public void update(int prezzo) {
        super.update(prezzo);
        System.out.println("Prezzo aggiornato per: " + getName());
    }

}

class CannaDaSuperfice extends CannaDaPesca {

    public CannaDaSuperfice() {
        super("Canna da superficie");
        maggiorazione();
    }

    public void maggiorazione() {
        setPrezzo(this.getPrezzoProdotto() + 12);
    }

    @Override
    public void update(int prezzo) {
        super.update(prezzo);
        System.out.println("Prezzo aggiornato per: " + getName());
    }

}

class CannaDaConEsca extends CannaDaPesca {

    public CannaDaConEsca() {
        super("Canna con esca");
        maggiorazione();
    }

    public void maggiorazione() {
        setPrezzo(this.getPrezzoProdotto() + 12);
    }

    @Override
    public void update(int prezzo) {
        super.update(prezzo);
        System.out.println("Prezzo aggiornato per: " + getName());
    }

}