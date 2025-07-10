import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioMissioneSpaziale {

    public static Scanner scannerString = new Scanner(System.in);
    public static Scanner scannerInt = new Scanner(System.in);
    public static StazioneSpaziale stazione = new StazioneSpaziale("ISS");
    private static Astronauta astronautaCorrente = null;

    public static void main(String[] args) {

        System.out.println("=== BENVENUTO NEL SISTEMA GESTIONE MISSIONE SPAZIALE ===");
        System.out.println("Stazione Spaziale: " + stazione.getNome());

        boolean continua = true;
        while (continua) {
            //il metodo ritorna false solo quando si seleziona l'opzione di uscita
            continua = mostraMenuPrincipale();
        }

        System.out.println("Arrivederci!");
        scannerInt.close();
        scannerString.close();
    }

    private static boolean mostraMenuPrincipale() {
        System.out.println("\n=== MENU PRINCIPALE ===");
        System.out.println("1. Creare un nuovo astronauta");
        System.out.println("2. Visualizzare i dati di un astronauta");
        System.out.println("3. Fare login");
        System.out.println("4. Uscire dal programma");
        System.out.print("Scegli un'opzione: ");

        int scelta = scannerInt.nextInt();

        switch (scelta) {
            case 1:
            //invocazione del metodo per creare un astronauta
                creaAstronauta();
                break;
            case 2:
            //visualizza i dati di un particolare astronauta
                visualizzaDatiAstronauta();
                break;
            case 3:
            //chiama la funzione di accesso come condizione dell'if per aprire o meno il menù del singolo astronauta
                if (effettuaLogin()) {
                    menuAstronauta();
                }
                break;
            case 4:
            //ritorna false, esce dal loop nel main e chiude il programma
                return false;
            default:
                System.out.println("Opzione non valida!");
        }
        return true;
    }

    private static void creaAstronauta() {
        System.out.print("Inserisci il nome: ");
        String nome = scannerString.nextLine();
        System.out.print("Inserisci l'email: ");
        String email = scannerString.nextLine();

        System.out.println("Che tipo di astronauta vuoi creare?");
        System.out.println("1. Scienziato");
        System.out.println("2. Ispettore");
        System.out.print("Scegli: ");

        int tipo = scannerInt.nextInt();

        Astronauta nuovoAstronauta;
        switch (tipo) {
            case 1:
                nuovoAstronauta = new Scienziato(nome, email);
                break;
            case 2:
                nuovoAstronauta = new Ispettore(nome, email);
                break;
            default:
                System.out.println("Tipo non valido!");
                return;
        }

        stazione.aggiungiAstronauta(nuovoAstronauta);
        System.out.println("Astronauta creato e aggiunto alla stazione con successo!");
    }

    private static void visualizzaDatiAstronauta() {
        if (stazione.getCiurma().isEmpty()) {
            System.out.println("Nessun astronauta presente nella stazione.");
            return;
        }

        System.out.println("\n=== ASTRONAUTI NELLA STAZIONE ===");
        for (int i = 0; i < stazione.getCiurma().size(); i++) {
            Astronauta a = stazione.getCiurma().get(i);
            System.out.println((i + 1) + ". " + a.getNome() + " (" + a.getEmail() + ") - " +
                    a.getClass().getSimpleName() + " - Ossigeno: " + a.getCreditoOssigeno());

            if (a instanceof Scienziato) {
                System.out.println("   Esperimenti eseguiti: " + ((Scienziato) a).getEsperimentiEseguiti());
            }
            if (a instanceof Ispettore) {
                System.out.println("   Valutazioni inserite: " + ((Ispettore) a).getValutazioniInserite());
            }
        }
    }

    private static boolean effettuaLogin() {
        System.out.print("Inserisci il nome: ");
        String nome = scannerString.nextLine();
        System.out.print("Inserisci l'email: ");
        String email = scannerString.nextLine();

        if (login(stazione, nome, email)) {
            // Trova l'astronauta corrispondente
            for (Astronauta a : stazione.getCiurma()) {
                if (a.getNome().equals(nome) && a.getEmail().equals(email)) {
                    astronautaCorrente = a;
                    break;
                }
            }
            System.out.println("Login effettuato con successo! Benvenuto " + astronautaCorrente.getNome());
            return true;
        } else {
            System.out.println("Credenziali non valide!");
            return false;
        }
    }

    private static void menuAstronauta() {
        boolean continua = true;
        while (continua) {
            System.out.println("\n=== MENU ASTRONAUTA - " + astronautaCorrente.getNome() + " ===");
            System.out.println("Credito Ossigeno: " + astronautaCorrente.getCreditoOssigeno());

            if (astronautaCorrente instanceof Scienziato) {
                System.out.println("1. Condurre esperimento");
                System.out.println("2. Rigenerare credito ossigeno");
                if (astronautaCorrente instanceof ScienziatoCapo) {
                    System.out.println("3. Stampare tutti gli esperimenti (Capo)");
                    System.out.println("4. Logout");
                } else {
                    System.out.println("3. Logout");
                }
            } else if (astronautaCorrente instanceof Ispettore) {
                System.out.println("1. Inserire valutazione");
                System.out.println("2. Rigenerare credito ossigeno");
                if (astronautaCorrente instanceof IspettoreEsperto) {
                    System.out.println("3. Stampare tutte le valutazioni (Esperto)");
                    System.out.println("4. Logout");
                } else {
                    System.out.println("3. Logout");
                }
            }

            System.out.print("Scegli un'opzione: ");
            int scelta = scannerInt.nextInt();

            continua = gestisciAzioneAstronauta(scelta);
        }
    }

    private static boolean gestisciAzioneAstronauta(int scelta) {
        if (astronautaCorrente instanceof Scienziato) {
            Scienziato scienziato = (Scienziato) astronautaCorrente;
            switch (scelta) {
                case 1:
                    conduciEsperimento(scienziato);
                    break;
                case 2:
                    astronautaCorrente.rigeneraCreditoOssigeno();
                    System.out.println("Credito ossigeno rigenerato a: " + astronautaCorrente.getCreditoOssigeno());
                    break;
                case 3:
                    if (astronautaCorrente instanceof ScienziatoCapo) {
                        ((ScienziatoCapo) astronautaCorrente).stampaEsperimenti(stazione);
                    } else {
                        return false; // Logout
                    }
                    break;
                case 4:
                    if (astronautaCorrente instanceof ScienziatoCapo) {
                        return false; // Logout
                    }
                    break;
                default:
                    System.out.println("Opzione non valida!");
            }
        } else if (astronautaCorrente instanceof Ispettore) {
            Ispettore ispettore = (Ispettore) astronautaCorrente;
            switch (scelta) {
                case 1:
                    inserisciValutazione(ispettore);
                    break;
                case 2:
                    astronautaCorrente.rigeneraCreditoOssigeno();
                    System.out.println("Credito ossigeno rigenerato a: " + astronautaCorrente.getCreditoOssigeno());
                    break;
                case 3:
                    if (astronautaCorrente instanceof IspettoreEsperto) {
                        ((IspettoreEsperto) astronautaCorrente).stampaValutazioniIspezioni(stazione);
                    } else {
                        return false; // Logout
                    }
                    break;
                case 4:
                    if (astronautaCorrente instanceof IspettoreEsperto) {
                        return false; // Logout
                    }
                    break;
                default:
                    System.out.println("Opzione non valida!");
            }
        }
        return true;
    }

    private static void conduciEsperimento(Scienziato scienziato) {
        System.out.print("Inserisci il nome dell'esperimento: ");
        String esperimento = scannerString.nextLine();
        stazione.aggiungiEsperimento(esperimento, scienziato);
        System.out.println("Esperimento '" + esperimento + "' aggiunto con successo!");
        System.out.println("Esperimenti totali eseguiti: " + scienziato.getEsperimentiEseguiti());

        // Controlla promozione
        Scienziato promosso = checkPromozione(scienziato);
        if (promosso instanceof ScienziatoCapo && !(scienziato instanceof ScienziatoCapo)) {
            System.out.println("CONGRATULAZIONI! Sei stato promosso a Scienziato Capo!");
            // Aggiorna l'astronauta corrente e nella stazione
            astronautaCorrente = promosso;
            stazione.sostituisciAstronauta(scienziato, promosso);
        }
    }

    private static void inserisciValutazione(Ispettore ispettore) {
        System.out.print("Inserisci la valutazione (1-10): ");
        int valutazione = scannerInt.nextInt();

        if (valutazione >= 1 && valutazione <= 10) {
            stazione.aggiungiValutazione(valutazione, ispettore);
            System.out.println("Valutazione " + valutazione + " inserita con successo!");
            System.out.println("Valutazioni totali inserite: " + ispettore.getValutazioniInserite());

            // Controlla promozione
            Ispettore promosso = checkPromozione(ispettore);
            if (promosso instanceof IspettoreEsperto && !(ispettore instanceof IspettoreEsperto)) {
                System.out.println("🎉 CONGRATULAZIONI! Sei stato promosso a Ispettore Esperto!");
                // Aggiorna l'astronauta corrente e nella stazione
                astronautaCorrente = promosso;
                stazione.sostituisciAstronauta(ispettore, promosso);
            }
        } else {
            System.out.println("Valutazione non valida! Inserisci un valore tra 1 e 10.");
        }
    }

    public static boolean login(StazioneSpaziale stazione, String nome, String email) {
        boolean validCredentials = false;
        for (Astronauta astronauta : stazione.getCiurma()) {
            if (astronauta.getNome().equals(nome) && astronauta.getEmail().equals(email)) {
                validCredentials = true;
            }
        }
        return validCredentials;
    }

    public static <T extends Scienziato> Scienziato checkPromozione(T scienziato) {
        if (scienziato.getEsperimentiEseguiti() >= 3) {
            ScienziatoCapo capo = new ScienziatoCapo(scienziato.getNome(), scienziato.getEmail());
            capo.setEsperimentiEseguiti(scienziato.getEsperimentiEseguiti());
            return capo;
        }
        return scienziato;
    }

    public static <T extends Ispettore> Ispettore checkPromozione(T ispettore) {
        if (ispettore.getValutazioniInserite() >= 3) {
            IspettoreEsperto esperto = new IspettoreEsperto(ispettore.getNome(), ispettore.getEmail());
            esperto.setValutazioniInserite(ispettore.getValutazioniInserite());
            return esperto;
        }
        return ispettore;
    }
}

class Astronauta {
    private String nome;
    private String email;
    private int creditoOssigeno;
    private StazioneSpaziale stazione;

    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.creditoOssigeno = 100;
    }

    public void entraStazione(StazioneSpaziale stazione) {
        this.stazione = stazione;
    }

    public StazioneSpaziale getStazioneSpaziale() {
        return this.stazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreditoOssigeno() {
        return creditoOssigeno;
    }

    public void rigeneraCreditoOssigeno() {
        this.creditoOssigeno = (int) (Math.random() * 100);
    }

}

class Scienziato extends Astronauta {
    private int esperimentiEseguiti = 0;

    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    public int getEsperimentiEseguiti() {
        return esperimentiEseguiti;
    }

    public void aumentaCounterEsperimenti() {
        this.esperimentiEseguiti++;
    }

    public void setEsperimentiEseguiti(int esperimentiEseguiti) {
        this.esperimentiEseguiti = esperimentiEseguiti;
    }

}

class ScienziatoCapo extends Scienziato {

    public ScienziatoCapo(String nome, String email) {
        super(nome, email);
    }

    public void stampaEsperimenti(StazioneSpaziale stazione) {
        ArrayList<String> esperimenti = stazione.getEsperimenti();
        for (int i = 0; i < esperimenti.size(); i++) {
            System.out.println("Esperimento #" + i + ": " + esperimenti.get(i));
        }
    }

}

class Ispettore extends Astronauta {
    private int valutazioniInserite = 0;

    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    public int getValutazioniInserite() {
        return valutazioniInserite;
    }

    public void aumentaCounterValutazioni() {
        this.valutazioniInserite++;
    }

    public void setValutazioniInserite(int valutazioniInserite) {
        this.valutazioniInserite = valutazioniInserite;
    }

}

class IspettoreEsperto extends Ispettore {

    public IspettoreEsperto(String nome, String email) {
        super(nome, email);
    }

    public void stampaValutazioniIspezioni(StazioneSpaziale stazione) {
        ArrayList<Integer> valutazioni = stazione.getValutazioni();
        for (int i = 0; i < valutazioni.size(); i++) {
            System.out.println("Esperimento #" + i + ": " + valutazioni.get(i));
        }
    }

}

class StazioneSpaziale {
    private String nome;
    private ArrayList<String> esperimenti = new ArrayList<>();
    private ArrayList<Integer> valutazioni = new ArrayList<>();
    private ArrayList<Astronauta> ciurma = new ArrayList<>();

    public StazioneSpaziale(String nome) {
        this.nome = nome;
    }

    public void aggiungiEsperimento(String esperimento, Scienziato scienziato) {
        scienziato.aumentaCounterEsperimenti();
        esperimenti.add(esperimento);
    }

    public void aggiungiValutazione(int valutazione, Ispettore ispettore) {
        ispettore.aumentaCounterValutazioni();
        valutazioni.add(valutazione);
    }

    public ArrayList<String> getEsperimenti() {
        return esperimenti;
    }

    public ArrayList<Integer> getValutazioni() {
        return valutazioni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEsperimenti(ArrayList<String> esperimenti) {
        this.esperimenti = esperimenti;
    }

    public void setValutazioni(ArrayList<Integer> valutazioni) {
        this.valutazioni = valutazioni;
    }

    public ArrayList<Astronauta> getCiurma() {
        return ciurma;
    }

    public void sostituisciAstronauta(Astronauta vecchio, Astronauta nuovo) {
        int index = ciurma.indexOf(vecchio);
        if (index != -1) {
            ciurma.set(index, nuovo);
        } 
    }

    public void aggiungiAstronauta(Astronauta astronauta) {
        astronauta.entraStazione(this);
        ciurma.add(astronauta);
    }
}
