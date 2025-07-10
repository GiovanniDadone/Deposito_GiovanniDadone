import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioMedioFacade {
    public static void main(String[] args) {
        ComputerFacade pc = new ComputerFacade();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);

        // monta i componenti del pc
        boolean uscita = false;

        while (!uscita) {
            System.out.println("======MENU COMPONENTI=====");
            System.out.println("Che component vuoi montare?");
            System.out.println("1. Bios");
            System.out.println("2. Hard Disk");
            System.out.println("3. Sistema Operativo");
            System.out.println("4. Exit");
            System.out.print("Scelta: ");

            if (!intScanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                continue;
            }

            int scelta = intScanner.nextInt();

            switch (scelta) {
                case 1:
                    // Case 1 logic
                    pc.montaComponentePC(new Bios(new PC_Component()));
                    break;

                case 2:
                    // Case 2 logic
                    pc.montaComponentePC(new HardDisk(new PC_Component()));
                    break;

                case 3:
                    // Case 3 logic
                    pc.montaComponentePC(new SistemaOperativo(new PC_Component()));
                    break;

                case 4:
                    uscita = true;
                    System.out.println("Uscita...");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
            System.out.println("| | | | | | | | | | | | | | ");
        }

        // scelta binaria
        System.out.println("Vuoi accendere il pc? SI/no");
        String scelta = stringScanner.nextLine();
        if (scelta.equalsIgnoreCase("si")) {
            pc.accendiPC();
        } else if (scelta.equalsIgnoreCase("no")) {
            System.out.println("Andiamo a prendere un po' di sole...");
        }
        stringScanner.close();
    }
}

class PC_Component {
    public static int counter = 0;
    private int id;

    public PC_Component() {
        counter++;
    }

    public static void stabilizzaCounter() {
        counter--;
    }

    public void azione() {
        System.out.println("Componente Montato");
        System.out.println("----------------------");
    }

    public int getIdComponente() {
        return id;
    }

}

class Bios extends PC_Component {
    private PC_Component component;

    public Bios(PC_Component component) {
        this.component = component;
        PC_Component.stabilizzaCounter();
        System.out.println("Counter: " + PC_Component.counter);
    }

    public void setComponent(PC_Component newComponent) {
        this.component = newComponent;
    }

    public void azione() {
        this.component.azione();
        inizializza();
    }

    public void inizializza() {
        System.out.println("BIOS inizializzato");
        System.out.println("====================");
    }
}

class HardDisk extends PC_Component {

    private PC_Component component;

    public HardDisk(PC_Component component) {
        this.component = component;
        PC_Component.stabilizzaCounter();
        System.out.println("Counter: " + PC_Component.counter);

    }

    public void setComponent(PC_Component newComponent) {
        this.component = newComponent;
    }

    public void azione() {
        this.component.azione();
        carica();
    }

    public void carica() {
        System.out.println("Hard Disk caricato");
    }
}

class SistemaOperativo extends PC_Component {
    private PC_Component component;

    public SistemaOperativo(PC_Component component) {
        this.component = component;
        PC_Component.stabilizzaCounter();
        System.out.println("Counter: " + PC_Component.counter);

    }

    public void setComponent(PC_Component newComponent) {
        this.component = newComponent;
    }

    public void azione() {
        this.component.azione();
        avvia();
    }

    public void avvia() {
        System.out.println("Sistema Operativo avviato");
    }
}

class ComputerFacade {
    private List<PC_Component> listaComponentiPC = new ArrayList<>();

    public void montaComponentePC(PC_Component component) {
        listaComponentiPC.add(component);
    }

    public void smontaComponentePC(PC_Component component) {
        listaComponentiPC.remove(component);
    }

    public void accendiPC() {
        for (PC_Component component : listaComponentiPC) {
            component.azione();
        }
    }
}