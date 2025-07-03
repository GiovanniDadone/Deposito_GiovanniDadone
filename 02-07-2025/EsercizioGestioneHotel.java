import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioGestioneHotel {
    public static void main(String[] args) {

        // inizializzazione oggetto Hotel
        Hotel radisson = new Hotel("Radisson");

        // apertura scanner per ogni tipo primitivo
        Scanner stringScanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerFloat = new Scanner(System.in);

        // inizio ciclo del menù principale
        boolean inputValido = false;
        while (!inputValido) {

            // print del menu
            System.out.println("""
                    Che cosa vuoi fare?
                    1. Aggiungi camera
                    2. Mostra tutte le camere
                    3. Stampa il numero totale di camere
                    4. Esci dal programma
                    """);

            // raccolta dell'input dello user
            int scelta = scannerInt.nextInt();

            switch (scelta) {
                case 1:

                    // raccolta variabili per inizializzare la camera da aggiungere
                    System.out.println("Inserisci il numero della camera");
                    int numeroCamera = scannerInt.nextInt();
                    System.out.println("Che prezzo ha la nuova camera");
                    float prezzoCamera = scannerFloat.nextFloat();
                    System.out.println("Sarà una suite (maggiorazione del prezzo di 50$)? si/no");
                    String choice = stringScanner.nextLine();
                    String extra = "";
                    if (choice.equalsIgnoreCase("si")) {
                        System.out.println("Definisci i servizi extra");
                        extra = stringScanner.nextLine();
                    }

                    radisson.addRoom(numeroCamera, prezzoCamera, choice, extra);
                    break;

                case 2:
                    // stampa di tutti i dettagli di tutte le camere (con e senza prezzo)
                    System.out.println("Con i dettagli del prezzo? si/no");
                    // gestione logica del della scelta su cosa stampare con il metodo
                    // dettagli(boolean)
                    boolean choice2 = (stringScanner.nextLine().equalsIgnoreCase("si")) ? true : false;
                    for (Room camera : radisson.getCamere()) {
                        camera.dettagli(choice2);
                    }
                    break;

                case 3:
                    // stampa del numero di camere tramite metodo statico
                    contaCamere(radisson.getCamere());
                    break;

                case 4:
                    // Exit
                    inputValido = true;
                    System.out.println("Uscita dal programma");
                    break;

                default:
                    System.out.println("Scelta non valida!");
            }
            System.out.println("==================================");
        }

        scannerFloat.close();
        scannerInt.close();
        stringScanner.close();
    }

    // metodo statico che conta il numero di camere nell'arrayList di camere e lo
    // printa
    public static void contaCamere(ArrayList<Room> listaCamere) {
        System.out.println("Numero di camere: " + listaCamere.size());
    }
}

class Room {
    private int roomNumber;
    private float price;

    public Room(int roomNumber, float price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    // metodo che stampa i dettagli di una camera a partire dalle sue variabili + il
    // nome della classe
    public void dettagli() {
        System.out.println("Tipo camera: " + this.getClass().getSimpleName() + ", Numero camera: " + roomNumber
                + ", Prezzo camera: " + price + "$/per notte");
    }

    // metodo overloadato di dettagli() che implicitamente usa il metodo non
    // overloadato a seonda del valore del boolean passato come parametro
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            this.dettagli();
        } else {
            System.out.println("Tipo camera: " + this.getClass().getSimpleName() + ", Numero camera: " + roomNumber);
        }
        System.out.println("----------------------------");
    }

    // getter e setter d'ordinanza
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}

class Suite extends Room {
    private String extraServices;

    // costruttore che richiama il costruttore di Room per registrare i parametri
    // che le due classi condividono
    public Suite(int roomNumber, float price, String extraServices) {
        super(roomNumber, price);
        // uso il setter per inizializzare l'oggetto in modo da aumentarne il costo
        // automaticamente
        setExtraServices(extraServices);
        ;
    }

    public String getExtraServices() {
        return extraServices;
    }

    // setter che aumenta il costo della camera
    public void setExtraServices(String extraServices) {
        this.setPrice(getPrice() + 50f);
        this.extraServices = extraServices;
    }

    // custom setter da chiamare per definire gli extra dopo la creazione di Suite
    // per evitare di aggiungere sempre un costo aggiuntivo con l'altro setter
    public void definisciExtra(String extra) {
        this.extraServices = extra;
    }

    // metodo dettagli() overridato dalla classe padre che usa comunque il metodo
    // padre per stampare i dettagli della camera
    public void dettagli() {
        super.dettagli();
        System.out.println("Servizi extra: " + extraServices);
    }

}

class Hotel {
    private String nome;
    private ArrayList<Room> camere;

    public Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    // metodo che aggiunge una Room all'arrayList dell'oggetto Hotel, passando gli
    // argomenti del metodo come parametri dei costruttori richiamati e la String
    // extra permette di aggiungere una String inizializzata al costruttore di Suite
    public void addRoom(int number, float price, String choice, String extra) {
        Room cameraNuova;
        Suite suiteNuova;
        if (choice.equalsIgnoreCase("si")) {
            suiteNuova = new Suite(number, price, extra);
            camere.add(suiteNuova);
            System.out.println("Camera aggiunta: ");
            suiteNuova.dettagli();
        } else {
            cameraNuova = new Room(number, price);
            camere.add(cameraNuova);
            System.out.println("Camera aggiunta: ");
            cameraNuova.dettagli();
        }

    }

    @Override
    public String toString() {
        return "Hotel [nome=" + nome + ", camere=" + camere + "]";
    }

    // getter e setter d'ordinanza
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Room> getCamere() {
        return camere;
    }

    public void setCamere(ArrayList<Room> camere) {
        this.camere = camere;
    }

}
