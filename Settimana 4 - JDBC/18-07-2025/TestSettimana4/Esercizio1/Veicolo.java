
public abstract class Veicolo {
    private String marca;
    private String modello;
    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
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

    public abstract void dettagli();
}

class Auto extends Veicolo {

    public Auto(String marca, String modello) {
        super(marca, modello);
    }

    @Override
    public void dettagli() {
        System.out.println(" Auto: [marca=" + getMarca() + ", modello=" + getModello() + "]");
    }

    

}

class Moto extends Veicolo {

    public Moto(String marca, String modello) {
        super(marca, modello);
    }

    @Override
    public void dettagli() {
        System.out.println(" Moto: [marca=" + getMarca() + ", modello=" + getModello() + "]");
    }

}
