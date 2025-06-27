import java.util.Random;
import java.util.Scanner;

public class EsercizioArray {
    public static void main(String[] args) {
        // apertura dello scanner per raccogliere input di tipo stringa
        Scanner stringScanner = new Scanner(System.in);

        // apertura dello scanner per raccogliere input di tipo numero intero
        Scanner intScanner = new Scanner(System.in);

        // boolean che gestisce il do while sucessivo sul numero totale di dolci da
        // inserire
        boolean numeroValido = false;

        // variabile int che serve a inizializzare gli array successivi
        int numeroTipiDolci;

        // do while loop che si ripete all'infinito finchè non metti un numero positivo
        do {
            System.out.println("Quanti differenti tipi di dolci vuoi ordinari");
            numeroTipiDolci = intScanner.nextInt(); // ricezione input dall'utente
            intScanner.nextLine();

            if (numeroTipiDolci < 0) {
                System.out.println("Numero non valido riprova");
                numeroValido = false;
            } else {
                numeroValido = true; // cambio valore del boolean ed esce dal loop al prossimo check
            }

        } while (!numeroValido);

        // inizializzazione di due array: nomi dei dolci e quantità da ordinare
        String[] tipiDiDolci = new String[numeroTipiDolci];
        int[] quantitàDiDolci = new int[numeroTipiDolci];

        // variabile che racchiude il numero totale di dolci ordinati
        int dolciTotali = 0;

        // for loop principale che raccoglie e valida gli input
        for (int i = 0; i < tipiDiDolci.length; i++) {
            System.out.println("Inserisci il nome del dolce che vuoi ordinare"); // si potrebbe aggiungere un check in
                                                                                 // modo che le stringhe non siano vuote
                                                                                 // ma vabbè
            tipiDiDolci[i] = stringScanner.nextLine();

            //booleano per validazione input numerico per le quantità ordinate, no numeri negativi
            boolean inputValido = true;

            //come prima un do while che prima accetta gli input e poi controlla se sono validi, altrimente si ripete
            do {
                System.out.println("Quanti dolci di questo tipo vuoi ordinare?");
                quantitàDiDolci[i] = intScanner.nextInt();
                intScanner.nextLine();
                if (quantitàDiDolci[i] < 0) {
                    System.out.println("Non puoi inserire una quantità negativa");
                    inputValido = false;
                    quantitàDiDolci[i] = 0;
                } else {
                    System.out.println("Inserito!");
                    inputValido = true;
                }
            } while (!inputValido);

            //aggiunta progressiva degli input validati nelle quantità totali di dolci
            dolciTotali += quantitàDiDolci[i];
        }

        //inizializzazione array della stessa lunghezza degli altri 2
        int[] costiRandomici = new int[tipiDiDolci.length];
        int costoTotale = 0;

        //generazione randomica dei costi e incapsulazione degli stessi nell'array costiRandomici
        for (int i = 0; i < costiRandomici.length; i++) {
            Random random = new Random();
            costiRandomici[i] = random.nextInt(11);
            costoTotale += costiRandomici[i];
        }

        //stampa lista ordini
        for (int i = 0; i < tipiDiDolci.length; i++) {
            System.out.println("Dolce n°" + (i + 1) + " : " + tipiDiDolci[i] + ", quantità: x" + quantitàDiDolci[i]
                    + ", costo: " + costiRandomici[i]);
        }

        //stampa dei totali
        System.out.println("Numero totale di dolci ordinati: " + dolciTotali + ", costo totale: " + costoTotale);

        intScanner.close();
        stringScanner.close();
    }
}
