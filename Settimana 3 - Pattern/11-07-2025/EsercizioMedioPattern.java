import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EsercizioMedioPattern {

}

// niente singleton niente observer

// facade+adapter+strategy

interface UserManagement {
    void createuser(String name, int age);

    void deleteUser(String name, int age);

    String findUser(String name, int age);
}

class LegacyUserManagement {
    private List<User> utenti = new ArrayList<>();

    public void addUser(User utente) {
        utenti.add(utente);
    }

    public void removeUser(User utente) {
        utenti.remove(utente);
    }

    public boolean searchUser(User utente) {
        for (User user : utenti) {
            if (user.getName().equals(utente.getName()) && user.getAge() == utente.getAge()) {
                System.out.println("====UTENTE TROVATO====");
                System.out.println(user);
                return true;
            }
        }
        return false;
    }

    public List<User> getUtenti() {
        return utenti;
    }

}

// classe adapter che chiede i valori singoli piuttosto che un oggetto di tipo
// utente da passare come parametro dei metodi di adattamento
class UserManagementAdapter implements UserManagement {

    private LegacyUserManagement legacy = new LegacyUserManagement();
    private StrategiaRicerca strategia = new StrategiaRicerca();

    public UserManagementAdapter(LegacyUserManagement legacy) {
        this.legacy = legacy;
    }

    @Override
    public void createuser(String name, int age) {
        User utenteDaAggiungere = new User(name, age);
        legacy.addUser(utenteDaAggiungere);
    }

    @Override
    public void deleteUser(String name, int age) {
        User utenteDaRimuovere = new User(name, age);
        boolean trovato = legacy.searchUser(utenteDaRimuovere);
        if (trovato) {
            legacy.removeUser(utenteDaRimuovere);
        } else {
            System.out.println("Utente da eliminare non trovato");
        }
    }

    @Override
    public String findUser(String name, int age) {
        User utenteDaCercare = new User(name, age);
        boolean trovato = legacy.searchUser(utenteDaCercare);
        String risultato = trovato ? "Utente trovato: " + utenteDaCercare.toString() : "Utente non trovato";
        return risultato;
    }

    public void executeStrategy() {

    }

}

interface StrategiaRicerca {
}

class StrategiaRicercaNome implements StrategiaRicerca {
    public void findUserBy(String name) {
        List<User> listaLegacy = legacy.getUtenti();
        for (User utente : listaLegacy) {
            if (utente.getName().equals(name)) {
                System.out.println(utente);
            }
        }
    }
}

class StrategiaRicercaEtà implements StrategiaRicerca {
    public void findUserBy(int age) {
        List<User> listaLegacy = legacy.getUtenti();
        for (User utente : listaLegacy) {
            if (utente.getAge() == age) {
                System.out.println(utente);
            }
        }
    }
}

// user class predefinita per avere qualcosa di effettivo da cercare
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}

// Facade Pattern Example

// 1. SubsystemA
class SubsystemA {
    public void operationA() {
        System.out.println("Operazione A eseguita.");
    }
}

// 2. SubsystemB
class SubsystemB {
    public void operationB() {
        System.out.println("Operazione B eseguita.");
    }
}

// 3. SubsystemC
class SubsystemC {
    public void operationC() {
        System.out.println("Operazione C eseguita.");
    }
}

// 4. Facade
class Facade {
    private LegacyUserManagement legacyManagement = new LegacyUserManagement();
    private UserManagementAdapter newManagement = new UserManagementAdapter(legacyManagement);

    public void displayMenuUtenti() {
        System.out.println("========MENU GESTIONE UTENTI=========");
        System.out.println("Scegli una opzione:");
        System.out.println("1. Crea nuovo utente");
        System.out.println("2. Elimina utente");
        System.out.println("3. Cerca un utente");
        System.out.print("Scelta: ");
    }

    // metodo che gestisce l'input dell'utente
    public int ottieniInputInt(Scanner intScanner) {
        int scelta;
        // blocco try/catch per gestire l'input errato di qualcosa che non sia un numero
        // intero
        try {
            scelta = intScanner.nextInt();
        } catch (InputMismatchException e) {
            // messaggio di errore e reset del ciclo con scelta = 0
            System.out.println("Non è un numero riprova");
            intScanner.nextLine(); // libera il buffer consumando il new line "\n"
            scelta = 0;
        }

        return scelta;
    }

    public void sceltaOpzioni(Scanner stringScanner, Scanner intScanner, int scelta) {
        switch (scelta) {
            case 1:
                System.out.print("Inserisci nome del nuovo utente:");
                String nuovoNome = stringScanner.nextLine();
                System.out.println("Inserisci età del nuovo utente");
                int nuovaEtà = ottieniInputInt(intScanner);
                newManagement.createuser(nuovoNome, nuovaEtà);
                break;
            case 2:
                System.out.print("Inserisci nome utente da eliminare:");
                String utenteDaEliminare = stringScanner.nextLine();
                System.out.println("Inserisci età utente da eliminare");
                int etàEliminato = ottieniInputInt(intScanner);
                newManagement.deleteUser(utenteDaEliminare, etàEliminato);
                break;
            case 3:
                System.out.println("Vuoi cercare per nome o per età? 1. nome/ 2. età");
                int scelta2 = ottieniInputInt(intScanner);
                if (scelta2 == 1) {
                    System.out.print("Inserisci il nome dell'utente da cercare:");
                    String nomeRicerca = stringScanner.nextLine();
                } else if (scelta2 == 2) {
                    System.out.println("Inserisci l'età dell'utente da cercare");
                    int etàRicerca = ottieniInputInt(intScanner);
                } else {
                    System.out.println("Scelta invalida");
                }

                System.out.println("Uscita...");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }
    }

}