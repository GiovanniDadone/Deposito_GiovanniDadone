import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;

        SmartHome home = new SmartHome(null, null, null);

        do {
            System.out.println("Scegli 3 dispositivi che vuoi aggiungere?");
            System.out.println("1. Luci");
            System.out.println("2. Sensore");
            System.out.println("3. Allarme");
            System.out.print("Scelta: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input non valido! Inserisci un numero.");
                scanner.next(); // Consuma l'input errato
                continue;
            }

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    // Case 1 logic
                    home.addDevice(new LuciFlos());
                    counter++;
                    break;

                case 2:
                    // Case 2 logic
                    home.addDevice(new SensoreCisco());
                    counter++;
                    break;

                case 3:
                    // Case 3 logic
                    home.addDevice(new AllarmeBosch());
                    counter++;
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
        } while (counter < 3);

        System.out.println("Esci di casa? Si/no");
        String scelta = scanner.nextLine();
        if (scelta.equalsIgnoreCase("si")) {
            home.uscitaDiCasa();
        }

        System.out.println("Rientri a casa? Si/no");
        String scelta2 = scanner.nextLine();
        if (scelta2.equalsIgnoreCase("si")) {
            home.uscitaDiCasa();
        }

        scanner.close();
    }
}

// interfaccia dei dispositivi di casa
interface Dispositivo {
    void setOnOff(boolean state);
}

// classe per la gestione delle routine dei dispositivi
class SmartHome {
    private ArrayList<Dispositivo> dispositivi = new ArrayList<>();

    // implemetnazione del pattern adapter: costruttore pubbliico di dispositivi di
    // diverse marche che oltre ad essere observer fungono da Adaptee, la classe
    // SmartHome è l'adpater
    public SmartHome(Dispositivo device1, Dispositivo device2, Dispositivo device3) {
        addDevice(device1);
        addDevice(device2);
        addDevice(device3);
    }

    // parte del pattern Observer (addDevice/removeDevice/arrivoACasa/uscitaDiCasa)
    public void addDevice(Dispositivo dispositivo) {
        dispositivi.add(dispositivo);
    }

    public void removeDevice(Dispositivo dispositivo) {
        dispositivi.remove(dispositivo);
    }

    public void arrivoACasa() {
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo instanceof SensoreCisco) {
                dispositivo.setOnOff(false);
            }
            if (dispositivo instanceof AllarmeBosch) {
                dispositivo.setOnOff(false);
            }
            if (dispositivo instanceof LuciFlos) {
                dispositivo.setOnOff(true);
            }
        }
    }

    public void uscitaDiCasa() {
        for (Dispositivo dispositivo : dispositivi) {
            if (dispositivo instanceof SensoreCisco) {
                dispositivo.setOnOff(true);
            }
            if (dispositivo instanceof AllarmeBosch) {
                dispositivo.setOnOff(true);
            }
            if (dispositivo instanceof LuciFlos) {
                dispositivo.setOnOff(false);
            }
        }
    }
}

class SensoreCisco implements Dispositivo {
    private boolean onOff = false;

    @Override
    public void setOnOff(boolean state) {
        onOff = state;
        System.out.println((onOff) ? "Il sensore Cisco è attivo" : "Il sensore Cisco non è attivo");
    }

}

class AllarmeBosch implements Dispositivo {
    private boolean onOff = false;

    @Override
    public void setOnOff(boolean state) {
        onOff = state;
        System.out.println((onOff) ? "L'allarme Bosch è attivo" : "L'allarme Bosch non è attivo");
    }

}

class LuciFlos implements Dispositivo {
    private boolean onOff = false;

    @Override
    public void setOnOff(boolean state) {
        onOff = state;
        System.out.println((onOff) ? "Le luci Flos sono attive" : "Le luci Flos non sono attive");
    }

}
