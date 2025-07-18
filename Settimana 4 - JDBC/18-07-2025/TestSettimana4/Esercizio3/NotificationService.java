import java.util.ArrayList;

public class NotificationService implements Subject {
    private static NotificationService instance;
    private ArrayList<Observer> users = new ArrayList<>();
    private Notification notification = null;

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    private NotificationService() {
        // Private constructor to prevent instantiation
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    @Override
    public void registerObserver(Observer o) {
        users.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        users.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : users) {
            observer.update(message);
        }
    }
}

interface Observer {
    void update(String message);
}

interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers(String message);
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

// 1. Product: definisce l'interfaccia del prodotto
interface Notification {
    void operation();
}

// 2. SMS: implementa Product
class SMS implements Notification {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void operation() {
        System.out.println("Esecuzione di ConcreteNotificationA.operation()");
    }
}

// 3. Email: un altro prodotto concreto
class Email implements Notification {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void operation() {
        System.out.println("Esecuzione di Email.operation()");
    }
}

// 4. Creator: dichiara il Factory Method
abstract class Creator {
    // Factory Method: restituisce un Notification
    public abstract Notification factoryMethod();

    // Un metodo del creator che utilizza il prodotto
    public void anOperation() {
        Notification Notification = factoryMethod(); // creazione del prodotto
        Notification.operation(); // uso del prodotto
    }
}

// 5. SMSFactory: implementa factoryMethod per ConcreteNotificationA
class SMSFactory extends Creator {
    @Override
    public Notification factoryMethod() {
        return new SMS();
    }
}

// 6. EmailFactory: implementa factoryMethod per Email
class EmailFactory extends Creator {
    @Override
    public Notification factoryMethod() {
        return new Email();
    }
}
