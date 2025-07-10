import java.util.Scanner;

public class EsercizioFunzioni {

    static int faiFattoriale(int numero) {
        
        for (int i = numero; i > 1 ; i--) {
            System.out.println(numero + " x " + (i -1));
            numero = numero * (i-1);
            System.out.println(numero);
            System.out.println("--------------------------");
        }
        return numero;
    }

    static String faiFattoriale(String parola) {
        
        for (int i = 0; i < parola.length(); i++) {
            System.out.println("Carattere n°"+ (i+1) + " " +parola.charAt(i));
        }

        return "Nella String ci sono " + parola.length() + " caratteri";
    }
    public static void main(String[] args) {

        //apertura scanner per le stringhe
        Scanner scannerString = new Scanner(System.in);

        //registro dell'input
        String input = scannerString.nextLine();

        //controlla che l'input abbia almeno un carattere alfabetico
        if (input.matches(".*[a-zA-Z].*")) {
            System.out.println(faiFattoriale(input));     //usa il metodo string e ha almeno una lettera dell'alfabeto
        } else {
            int input2 = Integer.parseInt(input);
            System.out.println(faiFattoriale(input2));     //usa il metodo int in tutti gli latri casi
        }

        scannerString.close();
    }
}
