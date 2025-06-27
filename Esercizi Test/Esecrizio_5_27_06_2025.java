import java.util.Scanner;

public class Esecrizio_5_27_06_2025 {
    public static void main(String[] args) {
        //apertura scanner per i numeri interi
        Scanner scannerInt = new Scanner(System.in);


        //inserimento dell'età del candidato
        int età = scannerInt.nextInt();

        //inserimento dei numeri di anni di esperienza
        int anniEsperienza = scannerInt.nextInt();


        //inserimento numero di certificazioni ottenute
        int numeroCertifiazioni = scannerInt.nextInt();

        //booleano per definire la eventuale idoneità del candidato
        boolean idoneità;  //di base false 

        //controllo idoneità
        if (età > 18 && anniEsperienza >= 2 ) {
            idoneità = true;
        } else if ((età >16 && età <=18) && numeroCertifiazioni > 0) {
            idoneità = true;
        } else {
            idoneità = false;
        }

        //stampa radice quadrata numero totale di anni
        System.out.println("Numero anni totali: " + Math.sqrt(età + anniEsperienza));

        //stampa dell'idoneità risultante del candidato
        if (idoneità) {
            System.out.println("Idoneo al corso");
        } else {
            System.out.println("Non idoneo al corso");
        }

        //chiusura scanner per buona pratica non dovendolo più riutilizzare
        scannerInt.close();
    }
}
