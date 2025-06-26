import java.util.Scanner;

public class EsercizioForLoop {
    public static void main(String[] args) {
        // apertura scanner per chiedere l'input
        Scanner scanner = new Scanner(System.in);

        // flag che definisce la ripetizione del ciclo primario
        boolean flag2 = true;

        // inizio ciclo primario
        while (flag2) {
            System.out.println("Inserisci il tuo nome");
            String nome = scanner.nextLine(); // richiesta input del nome dello user

            System.out.println("Quanti voti vuoi inserire?");
            int numeriVoti = scanner.nextInt(); // richiesta numero di voti per lo user
            scanner.nextLine();

            if (numeriVoti <= 0) {
                System.out.println("Devi inserire un numero di voti maggiore di zero");
                continue;
            }

            // inizializzazione array definito in grandezza dal numero di voti
            int[] voti = new int[numeriVoti];

            // inizializzazione array che definisce il voto testuale da dare al voto
            // corrispondente nell'int array
            String[] votiTestuali = new String[numeriVoti];

            // determina se l'input è valido o meno, se non è valido richiede di inserirlo
            boolean inputValido = true;

            // for loop che si ripete per un numero di volte uguale al numero di voti
            for (int i = 0; i < numeriVoti; i++) {
                System.out.println("Per il voto n°" + (i + 1) + " di " + nome +
                        " qual è il voto da inserire? (deve essere fra 0 e 30)");
                voti[i] = scanner.nextInt(); // inserimento dei valori all'interno dell'array di numeri interi
                scanner.nextLine();

                if (voti[i] < 18 || voti[i] > 30) {
                    System.out.println("Voto non valido");
                    // input non valido quindi rompe il for loop e ritorna a richiederli TUTTi da
                    // capo
                    // ritorna alla richiesta del nome
                    inputValido = false;
                    break;
                }

                // aggiunta nell'array "votiTestuali" in base al voto scelto
                if (voti[i] >= 18 && voti[i] < 24) {
                    votiTestuali[i] = "Sufficiente";
                } else if (voti[i] >= 24 && voti[i] < 30) {
                    votiTestuali[i] = "Buono";
                } else if (voti[i] == 30) {
                    votiTestuali[i] = "Perfetto";
                }
            }

            if (!inputValido) {
                System.out.println("Inserimento voti annullato a causa di voto non valido");
                continue;
            }

            // totale del valore dei voti su cui basarsi per la media che viene definito nel
            // for loop successivo
            int totaleValoreVoti = 0;

            //numero dei voti validi inseiriti dallo user
            int votiValidi = 0;

            for (int i = 0; i < voti.length; i++) {
                if (voti[i] >= 18) {
                    // stampa solo i voti validi 
                    System.out.println("Voto valido n°: " + (i + 1) + " di " + nome + " = " + votiTestuali[i]);
                    totaleValoreVoti += voti[i];
                    votiValidi++;
                }
            }

            if (votiValidi > 0) {
                //definizione della media dei voti validi
                System.out.println("Media voti validi: " + (totaleValoreVoti / votiValidi));
            } else {
                System.out.println("Nessun voto valido inserito");
            }

            // ultimo while per decidere se ricominciare
            // flag per l'ultimo ciclo per ricomicniare il loop principale o uscire dal
            // programma
            boolean flag3 = true;
            while (flag3) {
                System.out.println("Vuoi ricominciare? (y/n)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    flag2 = false; // queste esce dal programma
                    flag3 = false;// questo esce dal loop corrente
                } else if (choice.equalsIgnoreCase("y")) {
                    flag3 = false;
                } else {
                    System.out.println("Scelta non valida riprova");
                }
            }
        }
        scanner.close();
    }
}