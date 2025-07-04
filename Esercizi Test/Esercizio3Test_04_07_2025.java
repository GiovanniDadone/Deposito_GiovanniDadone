public class Esercizio3Test_04_07_2025 {

    public static void main(String[] args) {
        Cadetto cuoco = new CadettoCuoco("Gianni", "orientale");
        Cadetto dottore = new CadettoDottore("Paolo", "odontoiatria");
        Cadetto aviatore = new CadettoAviatore("Susanna", "F-24");

        cuoco.faiAzioneSpeciale();
        dottore.faiAzioneSpeciale();
        aviatore.faiAzioneSpeciale();
    }
}

abstract class Cadetto {
    private static int numeroMatricola;
    private String nome;

    public Cadetto(String nome) {
        numeroMatricola++;
        this.nome = nome;
    }

    public void stampaGeneralità() {
        System.out.println("Tipo di cadetto: " + getClass().getSimpleName() + ", Nome: " + getNome()
                + "Numero di matricola: " + getNumeroMatricola());
    }

    public int getNumeroMatricola() {
        return numeroMatricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    abstract void faiAzioneSpeciale();

}

class CadettoCuoco extends Cadetto {

    private String tipoDiCucina;

    public CadettoCuoco(String nome, String tipoDiCucina) {
        super(nome);
        this.tipoDiCucina = tipoDiCucina;
    }

    @Override
    void faiAzioneSpeciale() {
        System.out.println("Sto cucinando!");
    }

    public String getTipoDiCucina() {
        return tipoDiCucina;
    }

}

class CadettoDottore extends Cadetto {

    private String specializzazione;

    public CadettoDottore(String nome, String specializzazione) {
        super(nome);
        this.specializzazione = specializzazione;

    }

    @Override
    void faiAzioneSpeciale() {
        System.out.println("Sto curando le persone!");
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

}

class CadettoAviatore extends Cadetto {

    private String veivolo;
    
    public CadettoAviatore(String nome, String veivolo) {
        super(nome);
        this.veivolo = veivolo;
    }

    public String getVeivolo() {
        return veivolo;
    }

    @Override
    void faiAzioneSpeciale() {
        System.out.println("Sto pilotando il mio " + veivolo);
    }
    
}
