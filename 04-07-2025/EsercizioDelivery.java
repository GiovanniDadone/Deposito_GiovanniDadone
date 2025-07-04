import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioDelivery {
    public static Scanner stringScanner = new Scanner(System.in);
    public static Scanner intScanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsegnaManager azienda = new ConsegnaManager();

        boolean inputValido = false;
        while (!inputValido) {
            displayMenu();
            // Display menu logic
            int scelta = intScanner.nextInt();

            switch (scelta) {
                case 1:
                    azienda.aggiungiVeicolo(stringScanner);
                    // Case 1 logic
                    break;

                case 2:
                    azienda.statoOrdine(intScanner, stringScanner);
                    // Case 2 logic
                    break;

                case 3: // Exit
                    inputValido = true;
                    // Optional return
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }

            // Pause logic
        }
    }

    public static void displayMenu() {
        System.out.println("""
                1. Aggiungi un veicolo
                2. Informazioni mobilità
                    """);
    }

}

abstract class VeicoloConsegna {
    private String targa;
    private float caricoMassimo;

    public VeicoloConsegna(float caricoMassimo) {
        this.caricoMassimo = caricoMassimo;
        generaTarga();
    }

    abstract void consegnaPacco(String destinazione);

    // stampa le generelità del veicolo
    public void stampaInfo() {
        System.out.println("Targa veicolo: " + getTarga() + "\nCarico Massimo del veicolo: " + getCaricoMassimo());
    }

    // getter e setter d'ordinanza
    public String getTarga() {
        return targa;
    }

    // generatore casuale di targa (ripreso dall'esercizio della compagnia aerea)
    public void generaTarga() {
        this.targa = "" + (char) (65 + Math.random() * 26)
                + (char) (65 + Math.random() * 26)
                + (char) (65 + Math.random() * 26)
                + (int) (Math.random() * 10)
                + (int) (Math.random() * 10);
        ;
    }

    public float getCaricoMassimo() {
        return caricoMassimo;
    }

    public void setCaricoMassimo(float caricoMassimo) {
        this.caricoMassimo = caricoMassimo;
    };
}

interface Tracciabile {
    void tracciaConsegna(String codiceTracking); // deve simulare il tracciamento del pacco
}

class Furgone extends VeicoloConsegna implements Tracciabile {

    public Furgone(float caricoMassimo) {
        super(caricoMassimo);
    }

    @Override
    void consegnaPacco(String destinazione) {
        System.out.println("Un FURGONE con targa " + getTarga() + "consegnerà il pacco in questa in questa città: "
                + destinazione);
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Il pacco " + codiceTracking + " è in arrivo");
    }

}

class Drone extends VeicoloConsegna implements Tracciabile {

    public Drone(float caricoMassimo) {
        super(caricoMassimo);
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Il pacco " + codiceTracking + " è in arrivo");

    }

    @Override
    void consegnaPacco(String destinazione) {
        System.out.println(
                "Un DRONE con codice" + getTarga() + " consegnerà il pacco in questa in questa città: " + destinazione);

    }

}

class ConsegnaManager {
    ArrayList<VeicoloConsegna> listaVeicoli = new ArrayList<>();

    public void aggiungiVeicolo(Scanner stringScanner) {
        VeicoloConsegna nuovoVeicolo = null;
        System.out.println("Che tipo di veicolo vuoi aggiungere?" + "\n"
                + "1. Furgone\n2.Drone");
        String tipo = stringScanner.nextLine();
        if (tipo.equalsIgnoreCase("furgone")) {
            nuovoVeicolo = new Furgone(3000f);
            nuovoVeicolo.stampaInfo();
        } else if (tipo.equalsIgnoreCase("drone")) {
            nuovoVeicolo = new Drone(380f);
            nuovoVeicolo.stampaInfo();
        } else {
            System.out.println("Opzione non riconosciuta");
        }
    }

    public void statoOrdine(Scanner intScanner, Scanner stringScanner) {
        System.out.println("""
                Scegli cosa vuoi sapere dell'ordine:
                1. Dati dei veicoli
                2. Stato spedizione
                3. Ritorna al menù principale
                """);
        int scelta = intScanner.nextInt();
        while (true) {
            if (scelta == 1) {
                System.out.println("Scegli il veicolo di cui conoscere i dati");
                for (int i = 0; i < listaVeicoli.size(); i++) {
                    System.out.print(i + 1 + " " + listaVeicoli.get(i).getClass().getSimpleName());
                }
                int scelta2 = intScanner.nextInt();
                listaVeicoli.get(scelta2).stampaInfo();
            } else if (scelta == 3) {
                break;
            } else if (scelta == 2) {
                System.out.println("Scegli la destinazione decisa: ");
                String destinazione = stringScanner.nextLine();
                System.out.println("Scegli la spedizione da tracciare");
                for (int i = 0; i < listaVeicoli.size(); i++) {
                    System.out.print(i + 1 + " " + listaVeicoli.get(i).getClass().getSimpleName());
                }
                int scelta2 = intScanner.nextInt();
                listaVeicoli.get(scelta2).consegnaPacco(destinazione);
            } else {
                System.out.println("Operazione non riconosciuta");
            }

        }
    }

}
