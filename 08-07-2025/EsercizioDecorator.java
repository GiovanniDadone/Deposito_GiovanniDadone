import java.util.Scanner;

public class EsercizioDecorator {
    public static void main(String[] args) {
        Messaggio msg = new MessaggioBase();
        Messaggio decoratore = new DecoratoreMaiuscolo(msg);
        Messaggio decoratoreMinuscolo = new DecoratoreMinuscolo(msg);

        System.out.println("Inserisci un tetso per vederlo ristampato e poi messo tutto in maiuscolo e in minuscolo");
        Scanner stringScanner = new Scanner(System.in);
        String testo = stringScanner.nextLine();

        System.out.println(msg.getContenuto(testo));
        System.out.println(decoratore.getContenuto(testo));
        System.out.println(decoratoreMinuscolo.getContenuto(testo));

        stringScanner.close();
    }
}

// interfaccia Messaggio che fa da archetipo di Component
interface Messaggio {
    // ho aggiunto un parametro in modo che possa stampare quello che manda come
    // input lo user
    String getContenuto(String testo);
}

// implementazione concreta dell'interfaccia component Messaggio
class MessaggioBase implements Messaggio {
    // override del metodo getContenuto
    @Override
    public String getContenuto(String testo) {
        return "Messaggio base: " + testo;
    }
}

// in questa classe astratta ho evitato di implementare un getContenuto() comune
// in quanto voglio esitarlo in due tipi, uno minuscolo e uno maiuscolo
abstract class DecoratoreCase implements Messaggio {
    protected Messaggio messaggioBase;

    public DecoratoreCase(Messaggio messaggioBase) {
        this.messaggioBase = messaggioBase;
    }
}

// Decoratore concreto maiuscolo
class DecoratoreMaiuscolo extends DecoratoreCase {

    // costruttore che richiama quello della classe padre
    public DecoratoreMaiuscolo(Messaggio messaggioBase) {
        super(messaggioBase);
    }

    @Override
    public String getContenuto(String testo) {
        // prende il metodo del proprio component messaggio e lo restitutisce in
        // maiuscolo
        return messaggioBase.getContenuto(testo).toUpperCase() + " MA IN MAIUSCOLO";
    }
}

// decoratore concreto minuscolo
class DecoratoreMinuscolo extends DecoratoreCase {

    // costruttore che richiama quello della classe padre
    public DecoratoreMinuscolo(Messaggio messaggioBase) {
        super(messaggioBase);
    }

    @Override
    public String getContenuto(String testo) {
        // prende il metodo del proprio component messaggio e lo restitutisce in
        // minuscolo
        return messaggioBase.getContenuto(testo).toLowerCase() + " ma in minuscolo";
    }

}
