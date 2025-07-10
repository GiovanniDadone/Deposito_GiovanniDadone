import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EsercizioMedioFacade {
    public static void main(String[] args) {
        // istanziazione del subject ComputerFacade e degli scanner sia per String che
        // per numeri nteri
        ComputerFacade pc = new ComputerFacade();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        // monta i componenti del pc
        boolean uscita = false;

        // while loop principale per la scelta dei componenti
        while (!uscita) {
            System.out.println("======MENU COMPONENTI=====");
            System.out.println("Che component vuoi montare?");
            System.out.println("1. Bios");
            System.out.println("2. Hard Disk");
            System.out.println("3. Sistema Operativo");
            System.out.println("4. Display dei componenti");
            System.out.println("5. Exit");
            System.out.print("Scelta: ");

            int scelta = 0;

            // gestione dell'input in modo che debba essere un numero
            while (scelta == 0) {
                try {
                    scelta = intScanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Input invalido, inserisci un numero");
                    scelta = 0;
                }
            }

            // switch case per la gestione della scelta dell'utente
            switch (scelta) {
                case 1:
                    // Case 1 monta BIOS
                    pc.montaComponentePC(new Bios(new PC_Component()));
                    break;

                case 2:
                    // Case 2 monta Hard Disk
                    pc.montaComponentePC(new HardDisk(new PC_Component()));
                    break;

                case 3:
                    // Case 3 monta Sistema Operativo
                    pc.montaComponentePC(new SistemaOperativo(new PC_Component()));
                    break;
                case 4:
                pc.mostraComponenti();
                    break;
                case 5:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
            System.out.println("| | | | | | | | | | | | | | |");
        }

        // scelta binaria per uscire dal programma (termina ugualmente in entrambi i
        // casi ma il senso finale si raggiunge lo stesso, si potrebbe mettere un while
        // per gestire la risposta ma volevo tenerlo semplice)
        System.out.println("Vuoi accendere il pc? SI/no");
        String scelta = stringScanner.nextLine();
        if (scelta.equalsIgnoreCase("si")) {
            pc.accendiPC();
        } else if (scelta.equalsIgnoreCase("no")) {
            System.out.println("Andiamo a prendere un po' di sole...");
            // rimuove i componenti dalla lista e lo stampa a console
            pc.smontaPC();
        }
        stringScanner.close();
        intScanner.close();
    }
}

// USO PATTERN: Observer, Decorator, Facade

// classe che funge da Observer a cui viene wrappato un decoratore, avrei potuto
// implementare una interfaccia observer ma non ne vedo la necessità
class PC_Component {
    public static int counter = 0;

    // id per tenere traccia dei componenti
    private int id;

    public void azione() {
        System.out.println("Componente #" + getIdComponente() + " Montato");
        System.out.println("--------------------------------");
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public int getIdComponente() {
        return this.id;
    }

    public void display() {
        System.out.println("Componente #" + getIdComponente() +": "+ getClass().getSimpleName());
    }
}

// decoratore di pc_component: BIOS e observer del ComputerFacde, il subject
class Bios extends PC_Component {
    private PC_Component component;

    public Bios(PC_Component component) {
        // aumento il counter a ogni istanziazione di decoratori di PC_Component
        PC_Component.counter++;
        this.component = component;
        component.setId(PC_Component.counter);
    }

    // implemento il decorator pattern azionando l'azione base del PC_Component
    // wrappato + l'azione del decoratore, che è un subsistema
    public void azione() {
        this.component.azione();
        inizializza();
    }

    // questa è l'azione da decoratore in più
    public void inizializza() {
        System.out.println("BIOS inizializzato");
        System.out.println("==============================");
    }

}

// decoratore di pc_component: Hard Disk e observer del ComputerFacde, il
// subject
class HardDisk extends PC_Component {

    private PC_Component component;

    public HardDisk(PC_Component component) {
        // aumento il counter a ogni istanziazione di decoratori di PC_Component
        PC_Component.counter++;
        this.component = component;
        this.component.setId(PC_Component.counter);
    }

    // implemento il decorator pattern azionando l'azione base del PC_Component
    // wrappato + l'azione del decoratore, che è un subsistema
    public void azione() {
        this.component.azione();
        carica();
    }

    // questa è l'azione da decoratore in più
    public void carica() {
        System.out.println("Hard Disk caricato");
        System.out.println("==============================");
    }
}

// decoratore di pc_component: Sistema Operativo e observer del ComputerFacde,
// il subject
class SistemaOperativo extends PC_Component {
    private PC_Component component;

    public SistemaOperativo(PC_Component component) {
        // aumento il counter a ogni istanziazione di decoratori di PC_Component
        PC_Component.counter++;
        this.component = component;
        this.component.setId(PC_Component.counter);
    }

    // implemento il decorator pattern azionando l'azione base del PC_Component
    // wrappato + l'azione del decoratore, che è un subsistema
    public void azione() {
        this.component.azione();
        avvia();
    }

    // questa è l'azione da decoratore in più
    public void avvia() {
        System.out.println("Sistema Operativo avviato");
        System.out.println("==============================");
    }
}

// qui la classe ComputerFacade funge anche da subject per gli
// observer(PC_Component)
class ComputerFacade {
    // la lista dei componenti funge da istanza privata dei singoli componenti del
    private List<PC_Component> listaComponentiPC = new ArrayList<>();

    // metodi di registrazione/rimozione componenti
    public void montaComponentePC(PC_Component component) {
        listaComponentiPC.add(component);
    }

    public void smontaComponentePC(PC_Component component) {
        System.out.println(
                "Smontaggio componente #" + component.getIdComponente() + ": " + component.getClass().getSimpleName());
        listaComponentiPC.remove(component);
    }

    // ogni componente fa la sua azione base + quella specifica del decoratore
    // component.azione() funge qui sia da update() dell'observer pattern che da
    // facade per una routine di subsistemi
    public void accendiPC() {
        for (PC_Component component : listaComponentiPC) {
            component.azione();
        }
    }

    public void smontaPC() {
        System.out.println("Disassemblaggio dei componenti del PC");
        for (int i = 0; i < listaComponentiPC.size(); i++) {
            PC_Component componente = listaComponentiPC.get(i);
            smontaComponentePC(componente);
        }
    }

    public void mostraComponenti() {
        System.out.println("---------COMPONENTI---------");
        for (PC_Component component : listaComponentiPC) {
            component.display();
        }
    }
}