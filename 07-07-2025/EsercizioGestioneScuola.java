import java.util.ArrayList;
import java.util.InputMismatchException;

public class EsercizioGestioneScuola {

    public static void main(String[] args) {
        GlobalScanner.InitScannerInputs();

        GestioneScuola scuola = new GestioneScuola();

        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("=========GESTIONE SCOLASTICA==========");
            System.out.println("Scegli cosa fare:");
            System.out.println("1. Aggiungi uno studente");
            System.out.println("2. Aggiungi un docente");
            System.out.println("3. Stampa i dati di ogni persona");
            System.out.println("Esci dal programma");

            try {
                int scelta = GlobalScanner.readIntInput();
                switch (scelta) {
                    case 1:
                        scuola.aggiungiStudente();
                        break;
                    case 2:
                        scuola.aggiungiDocente();
                        break;
                    case 3:
                        scuola.stampaInfo();
                        break;
                    case 4: // Exit
                        inputValido = true;
                        break;
                    default:
                        System.out.println("Scelta non valida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("******INPUT VUOTO O NON VALIDO, RITENTA******");
                GlobalScanner.clearIntBuffer();
                continue;
            }

        }

        GlobalScanner.CloseScannerInputs();
    }

}

abstract class Persona {
    private String nome;
    private int età;

    public Persona(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

    // getter e setter definiti nella classe astratta padre
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public abstract void descriviRuolo();
}

interface Registrabile {
    void registrazione();
}

class Studente extends Persona implements Registrabile {

    // variabile univoca della classe
    private String classeFrequentata;

    // costruttore con super per evitare duplicazione dello stesso codice
    public Studente(String nome, int età, String classeFrequentata) {
        super(nome, età);
        this.classeFrequentata = classeFrequentata;
    }

    // implementazione dei metodi sia della classe astratta che dell'interfaccia
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite modulo online");
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono studente della classe: " + getClasseFrequentata());
    }

    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    @Override
    public String toString() {
        return "Studente [Nome: " + getNome() + ", Età: "
                + getEtà() + "]";
    }

}

class Docente extends Persona implements Registrabile {

    // variabile univoca della classe
    private String materia;

    // costruttore con super per evitare duplicazione dello stesso codice
    public Docente(String nome, int età, String materia) {
        super(nome, età);
        this.materia = materia;
    }

    // implementazione dei metodi sia della classe astratta che dell'interfaccia
    @Override
    public void descriviRuolo() {
        System.out.println("Sono docente di: " + getMateria());

    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");

    }

    public String getMateria() {
        return materia;
    }

    @Override
    public String toString() {
        return "Docente [Nome: " + getNome() + ", Età: "
                + getEtà() + "]";
    }
}

class GestioneScuola {
    ArrayList<Persona> corpoScolastico = new ArrayList<>();

    public void stampaInfo() {
        System.out.println("========LISTA PERSONE========");
        for (Persona persona : corpoScolastico) {

            System.out.println(persona);
            // richiamo tramite il metodo del tipo Persona ma si attuarà per polimorfismo al
            // tipo di cui fa parte effettivamente l'oggetto
            persona.descriviRuolo();

            // casto la persona a registrabile (senza controllo di "instanceof Registrabile"
            // giusto perchè so che posso avere solo quel tipo di interfaccia, in un
            // programma vero avrei prima fatto i dovuti controlli)
            Registrabile registrabile = (Registrabile) persona;

            // ogni registrabile eseguirà sempre per polimorfismo il suo metodo
            // registrazione()
            registrabile.registrazione();

            // aggiunto dopo aver visto la correzione di Mirko (molto più corto e facile,
            // senza dover prima dichiarare un'altra variabile , casti direttamente)
            // vale sermpre il ragionamento in cui non sto usando instanceof Studente o
            // Docente
            ((Registrabile) persona).registrazione();

            System.out.println("=====================================");
        }
    }

    // richiesta degli input necessari per poi aggiungere una nuova sottoclasse di
    // Persona

    // richiesta per docente
    public void aggiungiDocente() {

        // aggiunto un ciclo while che innesta un try/catch, se gli input sono vuoti
        // lancia una exception e
        while (true) {
            try {
                System.out.println("Inserisci il nome: ");
                String nome = GlobalScanner.readStringInput();
                if (nome.isEmpty() || nome.isBlank()) {
                    throw new InputMismatchException();
                }
                System.out.println("Inserisci l'età: ");
                int età = GlobalScanner.readIntInput();
                System.out.println("Inserisci la materia insegnata:");
                String materia = GlobalScanner.readStringInput();
                if (materia.isEmpty() || materia.isBlank()) {
                    throw new InputMismatchException();
                }

                corpoScolastico.add(new Docente(nome, età, materia));
                break;
            } catch (InputMismatchException e) {
                System.out.println("******INPUT VUOTO O NON VALIDO, RITENTA******");
                continue;
            }
        }
    }

    // richiesta per studente
    public void aggiungiStudente() {
        while (true) {
            try {
                System.out.println("Inserisci il nome: ");
                String nome = GlobalScanner.readStringInput();
                if (nome.isEmpty() || nome.isBlank()) {
                    throw new InputMismatchException();
                }
                System.out.println("Inserisci l'età: ");
                int età = GlobalScanner.readIntInput();
                System.out.println("Inserisci la classe che frequenta:");
                String classe = GlobalScanner.readStringInput();
                if (classe.isEmpty() || classe.isBlank()) {
                    throw new InputMismatchException();
                }

                corpoScolastico.add(new Studente(nome, età, classe));
                break;
            } catch (InputMismatchException e) {
                System.out.println("******INPUT VUOTO O NON VALIDO, RITENTA******");
                continue;
            }
        }

    }
}