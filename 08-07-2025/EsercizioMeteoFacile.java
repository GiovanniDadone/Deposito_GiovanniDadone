import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioMeteoFacile {
    public static void main(String[] args) {

        Scanner floatScanner = new Scanner(System.in);

        StazioneMeteo meteo = new StazioneMeteo();

        meteo.aggiungiDisplay(new DisplayConsole("Machintosh"));
        meteo.aggiungiDisplay(new DisplayMobile("Huawei"));

        int counter = 0;
        while (counter < 3) {
            System.out.println("Scegli una nuova temperatura da inserire");
            float scelta = floatScanner.nextFloat();
            meteo.setTemperature(scelta);
            counter++;
        }

    }

}

interface Display {
    void aggiorna(float temperatura);
}

class StazioneMeteo {
    private ArrayList<Display> listaDisplay = new ArrayList<>();
    private float temperatura;

    public void aggiungiDisplay(Display d) {
        listaDisplay.add(d);
    }

    public void rimuoviDisplay(Display d) {
        listaDisplay.remove(d);
    }

    public void setTemperature(float t) {
        this.temperatura = t;
        notificaDisplay();

    }

    public void notificaDisplay() {
        for (Display display : listaDisplay) {
            display.aggiorna(temperatura);
        }
    }

}

class DisplayConsole implements Display {

    private String modelloConsole;

    public DisplayConsole(String modelloConsole) {
        this.modelloConsole = modelloConsole;
    }

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("[Console = " + getModelloConsole() + "]: Nuova temperatura: " + temperatura + "°");
    }

    public String getModelloConsole() {
        return modelloConsole;
    }

}

class DisplayMobile implements Display {

    private String modelloMobile;

    public DisplayMobile(String modelloMobile) {
        this.modelloMobile = modelloMobile;
    }

    @Override
    public void aggiorna(float temperatura) {
        System.out.println("[Mobile = " + getModelloMobile() + "]: Nuova temperatura: " + temperatura + "°");
    }

    public String getModelloMobile() {
        return modelloMobile;
    }

}