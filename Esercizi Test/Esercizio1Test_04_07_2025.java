public class Esercizio1Test_04_07_2025 {
    public static void main(String[] args) {
        //creazione auto e moto
        Veicolo auto = new Auto("Fiat", "Fiesta", 2015, 5);
        Veicolo moto = new Moto("Yamaha", "HeeHee", 2018, "velcrato");

        //stampa delle info
        System.out.println(auto);
        System.out.println(moto);
    }
}

class Veicolo {
    private String marca;
    private String modello;
    private int anno;

    public Veicolo(String marca, String modello, int anno) {
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "Tipo di veicolo = " + getClass().getSimpleName() + " [marca=" + marca + ", modello=" + modello
                + ", anno=" + anno + "]";
    }

}

class Auto extends Veicolo {

    private int numeroPorte;

    public Auto(String marca, String modello, int anno, int numeroPorte) {
        super(marca, modello, anno);
        this.numeroPorte = numeroPorte;
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }

    @Override
    public String toString() {
        return "Tipo di veicolo = " + getClass().getSimpleName() + " [marca=" + getMarca() + ", modello=" + getModello()
                + ", anno=" + getAnno() + ",  numeroPorte=" + numeroPorte + "]";
    }

}

class Moto extends Veicolo {
    private String tipoManubrio;

    public Moto(String marca, String modello, int anno, String tipoManubrio) {
        super(marca, modello, anno);
        this.tipoManubrio = tipoManubrio;
    }

    public String getTipoManubrio() {
        return tipoManubrio;
    }

    public void setTipoManubrio(String tipoManubrio) {
        this.tipoManubrio = tipoManubrio;
    }

    @Override
    public String toString() {
        return "Tipo di veicolo = " + getClass().getSimpleName() + " [marca=" + getMarca() + ", modello=" + getModello()
                + ", anno=" + getAnno() + ",  Tipo di manubrio=" + tipoManubrio + "]";
    }
}
