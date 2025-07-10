public class ProvaSuper {
    public static void main(String[] args) {
        System.out.println("Prova da implementare");
    }
}

class Persona {
    private String nome;
    private int età;

    public Persona(String nome, int età) {
        this.nome = nome;
        this.età = età;
    }

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

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", età=" + età + "]";
    }

}

class Studente extends Persona {
    private String classe;

    public Studente(String nome, int età, String classe) {
        // uso di super per riprender il costruttore della classe padre
        super(nome, età);
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Studente [ Nome: " + super.getNome() + ", Età: " + super.getEtà() + ", Classe=" + classe + "]";
    }

    public String getClasse() {
        return classe;
    }

}

class Professore extends Persona {
    private String materia;

    public Professore(String nome, int età, String materia) {
        super(nome, età);
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Studente [ Nome: " + super.getNome() + ", Età: " + super.getEtà() + ", Materia=" + materia + "]";
    }

    public String getMateria() {
        return materia;
    }
}
