public class EsercizioPolimorfismo {
    public static void main(String[] args) {
        Person p1 = new Person("Anselmo");
        Person p2 = new Pirata("Barbarogna");

        p1.saluta();
        p2.saluta();
    }
}

class Person {
    private String nome;

    public Person(String nome) {
        this.nome = nome;
    }

    public void saluta() {
        System.out.println("Ue jamm' bell' uagliò sono " + this.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Pirata extends Person {
    public Pirata(String nome) {
        super(nome);
    }

    public void saluta() {
        System.out.println("Sono il pirata " + this.getNome() + " piccirì");
    }
}
