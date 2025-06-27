import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio_10_27_06_2025 {
    public static void main(String[] args) {
        // apertura scanner per le stringhe
        Scanner scannerStringhe = new Scanner(System.in);

        // inizializzazione arraylist per la lista della spesa
        ArrayList<String> listaSpesa = new ArrayList<>();

        // boolean per gestire il while loop della richiesta di nuovi prodotti
        boolean flag1 = true;

        // inizio while loop per la richiesta di input fino a che non si scrive "fine"
        while (flag1) {
            // richiesta di input nome del prodotto
            System.out.println("Inserisci il nome del nuovo prodotto. Scrivi \"fine\" per uscire");
            String nuovoProdotto = scannerStringhe.nextLine();
            if (nuovoProdotto.equalsIgnoreCase("fine")) {
                flag1 = false;
            } else {
                listaSpesa.add(nuovoProdotto);
            }

        }

        //stampa dei prodotti, uno per riga
        for (int i = 0; i < listaSpesa.size(); i++) {
            System.out.println("Lista della spesa: ");
            System.out.println((i+1) + ". " + listaSpesa.get(i));
        }

        //stampa numero totale dei prodotti
        System.out.println("Numero totale dei prodotti: " + listaSpesa.size());

        //stampa condizionale se "pane" E "latte" sono presenti nella lista
        if (listaSpesa.contains("pane") && listaSpesa.contains("latte")) {
            System.out.println("Hai pensato alla colazione!");
        }


        //chiusura scanner
        scannerStringhe.close();
    }
}
