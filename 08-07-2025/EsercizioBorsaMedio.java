import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioBorsaMedio {
    public static void main(String[] args) {

        Scanner doubleScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        AgenziaBorsa agenzia = new AgenziaBorsa();

        agenzia.aggiungiInvestitore(new InvestitoreBancario("Paolo"));
        agenzia.aggiungiInvestitore(new InvestitorePrivato("Carlo"));

        int counter = 0;
        while (counter < 3) {
            System.out.println("Scegli il nome dell'azione");
            String nome = stringScanner.nextLine();
            System.out.println("Scegli il nuovo valore");
            double valore = doubleScanner.nextDouble();

            agenzia.aggiornaValoreAzione(nome, valore);

            counter++;
        }

        stringScanner.close();
        doubleScanner.close();
    }
}

interface Investitore {
    void notifica(String azione, double valore);
}

class AgenziaBorsa {
    private ArrayList<Investitore> listaInvestitore = new ArrayList<>();
    private double valore;
    private String azione;

    public void aggiungiInvestitore(Investitore investitore) {
        listaInvestitore.add(investitore);
    }

    public void rimuoviInvestitore(Investitore investitore) {
        listaInvestitore.remove(investitore);
    }

    public void aggiornaValoreAzione(String nomeAzione, double valoreAzione) {
        this.valore = valoreAzione;
        this.azione = nomeAzione;
        notificaInvestitori();
    }

    public void notificaInvestitori() {
        for (Investitore investitore : listaInvestitore) {
            investitore.notifica(azione, valore);
        }
    }
}

class InvestitorePrivato implements Investitore {

    private String nome;

    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("[Investitore Privato: " + getNome() + "] le azioni di " + azione
                + " hanno adesso un valore di: " + valore);
    }

    public String getNome() {
        return nome;
    }

}

class InvestitoreBancario implements Investitore {

    private String nome;

    public InvestitoreBancario(String nome) {
        this.nome = nome;
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("[Investitore Privato: " + getNome() + "] le azioni di " + azione
                + " hanno adesso un valore di: " + valore);

    }

    public String getNome() {
        return nome;
    }

}