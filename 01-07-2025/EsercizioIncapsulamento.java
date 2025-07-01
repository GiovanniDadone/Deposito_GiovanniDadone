import java.util.ArrayList;
import java.util.List;

public class EsercizioIncapsulamento {
    public static void main(String[] args) {

        // istanziamento di un nuovo oggetto studente
        Studente studente = new Studente("Carla", 8);

        // di norma non si potrebbe printare un oggeto perchè ti ritorna
        // NomeDellaClasse@(numeri che rappresentano l'indirizzo in memoria in cui è
        // stipato l'oggetto) ma tanto ho fatto l'override di toString quindi daje
        System.out.println(studente);

        //prova del cambio di voto per testare il metodo setVoto se fa o meno la validazione
        studente.setVoto(9);
        studente.setVoto(12);


        //inzializzazione e popolamento di un arrayList di elementi di tipo Studente 
        ArrayList<Studente> listaStudenti = new ArrayList<>();
        listaStudenti.add(studente);
        listaStudenti.add(new Studente("Massimo", 7));

        //uso del metodo ricercaStudentePerNome per ritornare lo studente ricercato e referenziarlo con una variabile
        Studente studenteTrovato = ricercaStudentePerNome(listaStudenti, "massimo");

        //printa dello studente tramite reference 
        System.out.println(studenteTrovato);

    }

    // metodo che ritorna lo studente per nome da una lista passati come argomenti
    // del metodo, se non esiste ritorna un placeholder per evitare un
    // NullPointerException
    public static Studente ricercaStudentePerNome(List<Studente> lista, String nome) {
        for (Studente studente : lista) {
            if (studente.getNome().equalsIgnoreCase(nome)) {
                System.out.println(studente);
                return studente;

            }
        }
        return new Studente("Nessuno", 0);
    }
}

class Studente {
    private String nome;
    private int voto;
    private int id;
    private static int numeroStudenti = 1;

    // costruttore che inizializza l'id di ogni oggetto Studente a partire dalla
    // variabile static numeroStudenti e poi aumenta qusto counter
    public Studente(String nome, int voto) {
        this.nome = nome;
        this.voto = voto;
        this.id = getNumeroStudenti();
        aumentoStudenti();
    }

    // metodi getter e setter pubblici
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    // setter con validazione del voto affinchè sia solo all'interno di un certo
    // range
    public void setVoto(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.voto = voto;
        } else {
            System.out.println("Voto fuori dal range, non valido");
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroStudenti() {
        return numeroStudenti;
    }

    // metodo statico e privato per aumenatare i lnumero degli studenti a ogni istanziamento
    // di oggetto
    private static void aumentoStudenti() {
        numeroStudenti++;
    }

    // metodo toString sovrascritto per stampare le informazioni di uno studente
    @Override
    public String toString() {
        return "Studente [nome=" + nome + ", voto=" + voto + ", id=" + id + "]";
    }

}
