import java.util.Scanner;

public class Esercizio2Test_04_07_2025 {

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        // simulazione del login
        System.out.println("Inserisci nome account");
        String nome = stringScanner.nextLine();

        // oggetto ContoBancario con saldo = 0 e numero di conto autogenerato
        ContoBancario conto = new ContoBancario(nome);
        boolean inputValido = false;

        System.out.println();
        while (!inputValido) {
            // Display menu logic
            System.out.println("Vuoi prelevare o depositare?\n1.Prelevare\n2.Depositare\n3.uscire ");
            int scelta = scannerInt.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Quanto vuoi prelevare? (importo positivo)");
                    int prelievo = scannerInt.nextInt();
                    conto.preleva(prelievo);
                    break;
                case 2:
                    System.out.println("Quanto vuoi depositare? (importo positivo)");
                    int deposito = scannerInt.nextInt();
                    conto.deposita(deposito);
                    break;
                case 3:
                    inputValido = true;
                    System.out.println("Uscita");
                    break;
                default:
                    break;
            }

        }
        scannerInt.close();
        stringScanner.close();
    }

}

class ContoBancario {
    private static int counter = 0;
    private int numeroConto;
    private int saldo;
    private String titolare;

    public ContoBancario(String titolare) {
        this.numeroConto = counter++;
        this.saldo = 0;
        this.titolare = titolare;
    }

    public int getNumeroConto() {
        return numeroConto;
    }

    public int getSaldo() {
        return saldo;
    }

    public String getTitolare() {
        return titolare;
    }

    public void deposita(double importo) {

        //conrtollo deposito effettivamente positivo
        if (importo > 0) {
            System.out.println("Hai depositato: " + importo);
        } else {
            System.out.println("Non puoi depositare un importo neagtivo");
        }
    }

    public void preleva(double importo) {


        //conrtollo prelievo positovo e minore del saldo attuale
        if (importo > 0 && importo < getSaldo()) {
            System.out.println("Hai prelevato: " + importo);
        } else {
            System.out.println("Importo negativo o saldo insufficiente");
        }
    }

}
