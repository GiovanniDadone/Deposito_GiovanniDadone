import java.util.Scanner;

public class EsercizioForLoop1 {
    public static void main(String[] args) {
        // apertura scanner per chiedere il numero dei voti
        Scanner scannerInt = new Scanner(System.in);

        // apertura scanner per la richiesta del nome
        Scanner scannerString = new Scanner(System.in);

        // booleano per definire il ciclo primario
        boolean flag = true;

        // booleano per definire il ciclo extra
        boolean flag2 = true;

        while (flag2) {
            System.out.println("Inserisci il tuo nome");
            String nome = scannerString.nextLine();

            // richiesta all'utente di quanti voti vuoi inserire
            System.out.println("Quanti voti vuoi inserire?");
            int numeriVoti = scannerInt.nextInt();
            scannerInt.nextLine();

            // inizializzazione array definito in grandezza dal numero di voti
            int[] voti = new int[numeriVoti];

            // inizializzazione array che definisce il voto testuale da dare al voto
            // corrispondente nell'int array
            String[] votiTestuali = new String[numeriVoti];

            // ciclo primario
            while (flag) {

                // controllo che il numero di voti sia maggiore di zero
                if (numeriVoti > 0) {

                    // for loop che si ripete per un numero di volte uguale al numero di voti
                    for (int i = 1; i <= numeriVoti; i++) {
                        System.out.println(
                                "Per il voto n°" + i + " di " + nome
                                        + " qual è il voto da inserire? (deve essere fra 0 e 30)");

                        // richiesta di input di un numero da parte dell'utente
                        voti[i - 1] = scannerInt.nextInt();
                        scannerInt.nextLine();

                        // check per capire quale voto dare
                        if (voti[i - 1] < 18 && voti[i - 1] > 30) {
                            System.out.println("Voto non valido");
                            votiTestuali[i - 1] = "Non valido";
                        } else if (voti[i - 1] >= 18 && voti[i - 1] < 24) {
                            votiTestuali[i - 1] = "Sufficiente";
                        } else if (voti[i - 1] >= 24 && voti[i - 1] < 30) {
                            votiTestuali[i - 1] = "Buono";
                        } else if (voti[i - 1] == 30) {
                            votiTestuali[i - 1] = "Perfetto";
                        } else {
                            votiTestuali[i - 1] = "Non valido";
                        }

                    }

                    // flag aggiornata per uscire da questo ciclo
                    flag = false;
                } else {
                    System.out.println("Devi inserire un numero di voti maggiore di zero"); // input non valido e
                                                                                            // ripetizone del ciclo
                }

                // totale del valore dei voti su cui basarsi per la media che viene definito nel
                // for loop successivo
                int totaleValoreVoti = 0;

                // stampa solo i voti validi e defnizione della media dei voti validi
                for (int i = 0; i < votiTestuali.length; i++) {
                    if (!votiTestuali[i].equals("Non valido")) {
                        System.out.println("Voto valido n°: " + (i + 1) + " di " + nome + " = " + votiTestuali[i]);
                        totaleValoreVoti += voti[i];
                    }
                }

                // Stampa la media dei voti
                System.out.println("Media voti validi: " + totaleValoreVoti / voti.length);
            }

            // ultimo while per decidere se ricominciare
            // flag per l'ultimo ciclo per ricomicniare il loop principale o uscire dal programma
            boolean flag3 = true;

            while (flag3) {
                System.out.println("Vuoi ricominciare? (y/n)");
                String choice = scannerString.nextLine();
                if (choice.toLowerCase().charAt(0) == 'n') {
                    flag3 = false;  //questo esce dal loop corrente
                    flag2 = false;  //queste esce dal programma
                    voti = null;
                    votiTestuali = null;
                } else if (choice.toLowerCase().charAt(0) == 'y') {
                    System.out.println("Ricominciamo!!");
                    flag = true; //riattiviamo la flag per ricominciare il loop principale
                    flag3 = false;
                } else {
                    System.out.println("Scelta non valida riprova");
                }
            }
        }

        scannerInt.close();
        scannerString.close();
    }
}
