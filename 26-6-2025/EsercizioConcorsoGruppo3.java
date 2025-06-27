import java.util.Scanner;

public class EsercizioConcorsoGruppo3 {
    public static void main(String[] args) {

        //apertura scanner per gli input nnumerici
        Scanner scannerInt = new Scanner(System.in);

        //array per immagazzinare i voti delle foto
        int[] votiFoto = new int[5];

        //ciclo for per gestire gli input 
        for (int i = 0; i < votiFoto.length; i++) {
            boolean inputValido = false;

            //ciclo do while per la validazione dell'input in modo che non sia negativo e minore o uguale a 10
            do {
                System.out.println("Quale voto vuoi dare alla foto n°" + (i + 1));
                votiFoto[i] = scannerInt.nextInt();
                scannerInt.nextLine();

                if (votiFoto[i] > 0 && votiFoto[i] <= 10) {
                    inputValido = true;  //condizione per uscire dal loop do-while
                } else {
                    System.out.println("input non valido");
                }
            } while (!inputValido);
        }

        //variabile counter per contare le foto premiate
        int fotoPremiate = 0;

        //for loop per stampare in console le foto premiate come da condizione
        for (int i = 0; i < votiFoto.length; i++) {
            if (votiFoto[i] >= 8 && votiFoto[i] % 2 == 0) {
                System.out.println("Foto premiata n°" + (i + 1) + ": voto: " + votiFoto[i]);
                fotoPremiate++;  //aumento counter
                System.out.println("Numero foto premiate: " + fotoPremiate);
            }
        }

        //conteggio foto valide
        int concorsoValido = 0;
        for (int i = 0; i < votiFoto.length; i++) {
            if (votiFoto[i] >= 6) {
                concorsoValido++;
            }
        }

        //stampa della validità del concorso
        if (concorsoValido >= 1) {
            System.out.println("Concorso valido");
        } else {
            System.out.println("Concorso annullato");
        }

        scannerInt.close();

    }
}