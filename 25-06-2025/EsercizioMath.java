import java.util.Scanner;

public class EsercizioMath {
    public static void main(String[] args) {
        // età (18-40)? miglior tempo sui 100 metri(<12 secondi )? peso? altezza? (BMI
        // <25)
        // verifica con condizioni logiche
        // usare almeno una funzione della classe Math
        // stampare "Ammesso alla gara" se le condizioni sono soddisfatte, altrimenti
        // "Non ammesso"

        // BMI = peso/Math.pow(altezza, 2)

        //apertura scanner per l'input dello user
        Scanner scanner = new Scanner(System.in);


        //check #1: età
        int età = scanner.nextInt();
        scanner.nextLine();
        if (età >= 18 && età <= 40) {
            System.out.println("Età verificata e valida");
        } else {
            System.out.println("Età non valida");
            System.out.println("Non ammesso alla gara");
            scanner.close();
            return;  //return per terminare immediatamente il programma laddove anche un solo dato non vada bene
        }

        //check #2: tempo dei 100 metri
        int tempo100Metri = scanner.nextInt();
        scanner.nextInt();
        if (tempo100Metri < 12) {
            System.out.println("Tempo 100 metri valido");
        } else {
            System.out.println("Tempo 100 metri non valido");
            System.out.println("Non ammesso alla gara");
            scanner.close();
            return;
        }


        //check #3 parametri fisici di peso e altezza
        System.out.println("Qual è la tua altezza (in metri)?");
        int altezza = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual è il tuo peso (in Kg)?");
        int peso = scanner.nextInt();
        scanner.nextLine();

        double bmi = peso / Math.pow(altezza, 2);
        System.out.println("BMI: " + bmi);

        if (bmi < 25) {
            System.out.println("BMI valido");
        } else {
            System.out.println("BMI non valido");
            System.out.println("Non ammesso alla gara");
            scanner.close();
            return;
        }

        System.out.println("Ammesso alla gara");
        scanner.close();

    }
}
