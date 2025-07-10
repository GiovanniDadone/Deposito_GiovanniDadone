import java.util.Scanner;

public class EsercizioCondizioni1 {
    public static void main(String[] args) {
        // età?, biglietto valido?, accompagnato da adulto?, salta la fila?
        //premetto che avrei potuto farlo molto più elegantemente e sicuramente ci riproverò magari usando funzioni utilitarie
        //oppure/anche ternary operators, per ora uqesto funziona

        Scanner scannerStringa = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        System.out.println("Qual'è la tua ? (inserisci la tua età)");
        int età = scannerInt.nextInt();
        scannerInt.nextLine();
        if (età < 18) {  //controllo età
            System.out.println("Sei accompagnato da un adulto? (Rispondi si o no)");
            String accompagnato = scannerStringa.nextLine();

            if (accompagnato.toLowerCase().charAt(0) == 's') { //controllo accompagnato da un adulto
                System.out.println("Hai un biglietto valido? (Rispondi si o no)"); 
                String bigliettoValido = scannerStringa.nextLine();

                if (bigliettoValido.toLowerCase().charAt(0) == 's') { //controllo biglietto valido
                    System.out.println("Hai acquistato l'opzione salta la fila? (Rispondi si o no)"); 
                    String saltaFila = scannerStringa.nextLine();

                    if (saltaFila.toLowerCase().charAt(0) == 's') {  // controllo salta fila
                        System.out.println("Prego può entrare subito");
                    } else {
                        System.out.println("Aspetti il suo turno e poi entri grazie");
                    }

                } else {
                    System.out.println("Deve acquistare un biglietto valido per entrare, mi dispiace");
                    scannerInt.close();  //chiusura scanner giusto per togliere il warning da ide ma essendo che siamo nel main
                    scannerStringa.close();  //finisce il programma con return e le risorse vengono rilasciate in automatico
                    return;
                }

            } else {
                System.out.println("Mi dispiace ma devi essere accompagnato da un adulto");
                scannerInt.close();
                scannerStringa.close();
                return;
            }

        } else { // in questo else salto la richiesta di accompagnamento da un adulto in quanto
                 // sicuramente già adulto
            System.out.println("Hai un biglietto valido? (Rispondi si o no)"); 
            String bigliettoValido = scannerStringa.nextLine();

            if (bigliettoValido.toLowerCase().charAt(0) == 's') {  // controllo bilgietto valido
                System.out.println("Hai acquistato l'opzione salta la fila? (Rispondi si o no)"); 
                String saltaFila = scannerStringa.nextLine();

                if (saltaFila.toLowerCase().charAt(0) == 's') {   // controllo salta fila
                    System.out.println("Prego può entrare subito");
                } else {
                    System.out.println("Aspetti il suo turno e poi entri grazie");
                }

            } else {
                System.out.println("Deve acquistare un biglietto valido per entrare, mi dispiace");
                scannerInt.close();
                scannerStringa.close();
                return;
            }
        }
        scannerInt.close();
        scannerStringa.close();
    }
}
