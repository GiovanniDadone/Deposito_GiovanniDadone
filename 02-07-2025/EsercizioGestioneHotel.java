import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioGestioneHotel {
    public static void main(String[] args) {
        Hotel radisson = new Hotel("Radisson");

        Scanner stringScanner = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerFloat = new Scanner(System.in);

        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("""
                    Che cosa vuoi fare?
                    1. Aggiungi camera
                    2. Mostra tutte le camere
                    3. Esci dal programma
                    """);
            int scelta = scannerInt.nextInt();
            
            switch (scelta) {
                case 1:
                System.out.println("Inserisci il numero della camera");
                int numeroCamera = scannerInt.nextInt();
                System.out.println("Che prezzo ha la nuova camera");
                float prezzoCamera = scannerFloat.nextFloat();
                System.out.println("Sarà una suite (maggiorazione del prezzo di 200$)? si/no");
                String choice = stringScanner.nextLine();
                radisson.addRoom(numeroCamera, prezzoCamera, choice);
                break;
                
                case 2:
                    // Case 2 logic
                    for (Room camera : args) {
                        
                    }
                    break;
                
                case 3: // Exit
                    inputValido = true;
                    // Optional return
                    break;
                
                default:
                    System.out.println("Scelta non valida!");
            }
            
        }
    }

    public static void contaCamere(ArrayList<Room> listaCamere) {
        int counter = 0;
        for (Room room : listaCamere) {
            counter++;
        }
        System.out.println("Numero di camere: " + counter);
    }
}

class Room {
    private int roomNumber;
    private float price;

    public Room(int roomNumber, float price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public void dettagli() {
        System.out.println("Numero camera: " + roomNumber + ", Prezzo camera: " + price + "$/per notte");
    }

    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            this.dettagli();
        } else {
            System.out.println("Numero camera: " + roomNumber);
        }
    }

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
        setExtraServices(extraServices);;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.setPrice(getPrice() + 200f);
        this.extraServices = extraServices;
    }

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

    public void addRoom(int number, float price, String extra) {
        Room cameraNuova;
        if (extra.equalsIgnoreCase("si")) {
            cameraNuova = new Suite(number, price, extra);

        } else {
            cameraNuova = new Room(number, price);
            
        }
        camere.add(cameraNuova);
        System.out.println("Camera aggiunta: ");
        cameraNuova.dettagli();
    }

    @Override
    public String toString() {
        return "Hotel [nome=" + nome + ", camere=" + camere + "]";
    }

    

}
