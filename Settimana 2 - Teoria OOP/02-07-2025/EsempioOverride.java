class Studente {
    private String nome;
    private int età;

    public Studente(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

    @Override
    public String toString() {
        return "Studente [nome: " + nome + ", età: " + età + "]";
    }

}

public class EsempioOverride {
    public static void main(String[] args) {
        Studente studente = new Studente("Ignazio", 21);
        System.out.println(studente);
    }
}
