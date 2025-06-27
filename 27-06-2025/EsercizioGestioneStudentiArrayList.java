import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioGestioneStudentiArrayList {
    public static void main(String[] args) {
        ///inserimento di studenti con uscita da esso con la parola "fine"

        // apertura scanner per le stringhe
        Scanner scannerStringhe = new Scanner(System.in);

        // inizializzazione arraylist studenti
        ArrayList<String> studenti = new ArrayList<>();

        // boolean per gestire il while loop della richiesta di studenti
        boolean flag1 = true;

        // inizio while loop per la richiesta di input fino a che non si scrive "fine"
        while (flag1) {
            // richiesta di input nomi
            System.out.println("Inserisci il nome del nuovo studente. Scrivi \"fine\" per uscire");
            String nuovoStudente = scannerStringhe.nextLine();
            if (nuovoStudente.equalsIgnoreCase("fine")) {
                flag1 = false;
            } else {
                studenti.add(nuovoStudente);
            }

        }

        // stampa dei nomi in ordine alfabetico
        Collections.sort(studenti);

        System.out.println(studenti);

        // eliminazione eventuale di studenti

        // boolean per gestire il ciclo eliminazione
        boolean flag2 = true;

        //apertura scanner per accettare input numerici per eliminare gli studneti dalla lista in base all'indice
        Scanner scannerInt = new Scanner(System.in);

        while (flag2) {
            System.out.println("Vuoi eliminare degli studenti dalla lista? (s/n)");
            String scelta = scannerStringhe.nextLine();

            if (scelta.toLowerCase().charAt(0)=='s' || scelta.toLowerCase().charAt(0)=='n'){

                if (scelta.toLowerCase().charAt(0)=='s') {
                    //stampa di tutti gli studenti
                    for (int i = 0; i < studenti.size(); i++) {
                        System.out.println((i + 1) + ". " + studenti.get(i));
                    }

                    //richiesta del numero dello studnete da eliminare
                    System.out.println("Quale studente vuoi eliminare? Digita il numero corrispondente in lista");
                    System.out.println("numero di studenti: " + studenti.size());
                    int numeroStudenteEliminato = scannerInt.nextInt();

                    if (numeroStudenteEliminato <= studenti.size() && numeroStudenteEliminato > 0) {
                        String eliminato = studenti.remove(numeroStudenteEliminato-1);
                        System.out.println(eliminato + " eliminato dalla lista");  //stampa del nome eliminato 
                    } else {
                        System.out.println("Numero dello studente non in indice, scegliere un nunmero da 1 a " + studenti.size());
                    }
                } else {
                    System.out.println("Uscita dal programma");
                    flag2 = false; //uscita dal loop se si digita "n"
                }
            } else {
                System.out.println("Scelta non valida, riprova");
            }
        }
        scannerInt.close();
        scannerStringhe.close();

    }
}
