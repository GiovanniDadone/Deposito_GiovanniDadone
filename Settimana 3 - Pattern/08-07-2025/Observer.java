import java.util.ArrayList;
import java.util.List;

//interfaccia observer
public interface Observer {
    void update(String message);
}

// interfaccia subject
interface Subject {
    void registerObserver(Observer e);

    void removeObserver(Observer e);

    void notifyObserver();
}

// implementazione concreta di Subject
class ConcreteSubject implements Subject {

    // liste degli observer da registrare (compito del subject)
    private List<Observer> observers = new ArrayList<>();

    // state condiviso con gli observer, l'unico metodo che lo modifica notifica gli
    // observer dell'arrayList
    private String state;

    // il metodo che effettivamente cambia lo state e dunque notifica tutti gli
    // observer
    public void setState(String state) {
        this.state = state;
        notifyObserver();
    }


    //registrazione e rimozione degli observers
    @Override
    public void registerObserver(Observer e) {
        observers.add(e);
    }

    @Override
    public void removeObserver(Observer e) {
        observers.remove(e);
    }


    //aggiorna tutti gli observers
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

}


//implemetnazione concreta dell'observer
class ConcreteObserver implements Observer {

    //nome identificativo dell'observer
    private String name;

    //costruttore pubblico per permettere l'aggiunta all'arrayList del subject di nuovi observer 
    public ConcreteObserver(String name) {
        this.name = name;
    }


    //metodo update che semplicemnte printa l'avvenuto cambio id stato del Subject
    @Override
    public void update(String message) {
        System.out.println(name + "ha ricevuto aggiornamento: " + message);
    }

}