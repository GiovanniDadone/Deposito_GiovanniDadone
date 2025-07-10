public class EsercizioAdapter {
    // Client

    public static void main(String[] args) {
        PresaAmericana adaptee = new PresaAmericana();
        PresaEuropea adapter = new AdattatoreUSAtoEU();
        ((AdattatoreUSAtoEU) adapter).setAdaptee(adaptee);
        DispositivoEuropeo dispositivo = new DispositivoEuropeo(adapter);
        dispositivo.accendiDisopsitivo();
    }
}

// dispositivo di prova se l'elettricità arriva o meno
class DispositivoEuropeo {
    // presa europea che usa il metodo giveElectricity()
    private PresaEuropea presa;

    public DispositivoEuropeo(PresaEuropea presa) {
        this.presa = presa;
    }

    // metodo con risultato binario, o stampa che si accende o che non si accende a
    // seconda del ritorno di giveElecricity()
    public void accendiDisopsitivo() {
        boolean elettricità = presa.giveElectricity();
        if (elettricità) {
            System.out.println("Il dispositivo si è acceso");
        } else {
            System.out.println("Il dispositivo non si accende");
        }
    }
}

// interfaccia Target della presa europea
interface PresaEuropea {
    boolean giveElectricity();
}

// Adaptee
class PresaAmericana {
    void provideElectricity() {
        System.out.print("Elettricità da parte di Presa americana ");
    }
}

// Adapter
class AdattatoreUSAtoEU implements PresaEuropea {
    private PresaAmericana adaptee;

    public void setAdaptee(PresaAmericana presaUSA) {
        this.adaptee = presaUSA;
    }

    // metodo che ritorna vero o falso a seconda della presenza o meno di un adapter
    // da americano a europeo funzionante
    public boolean giveElectricity() {
        if (adaptee != null) {
            System.out.println("Adattatore da Presa Americana a Presa Europea collegato");
            adaptee.provideElectricity();
            System.out.print("--------> Elettricità passata alla Presa Europea");
            System.out.println();
            return true;
        } else {
            System.out.println("Presa americana mancante o difettosa");
        }
        return false;
    }
}