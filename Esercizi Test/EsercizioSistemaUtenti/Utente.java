public class Utente implements Notificabile {
    private String nome;
    private String password;

    public Utente() {
    }

    public Utente(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utenti [nome=" + nome + ", password=" + password + "]";
    }

    @Override
    public void riceviNotifica() {
        System.out.println("Notifica da classe base, errore");
    }

}

interface Notificabile {
    void riceviNotifica();
}

class Admin extends Utente {
    protected Utente utente;
    private String tipoUtenza;

    public Admin(String nome, String password) {
        super(nome, password);
        setUtente(nome, password);
        this.tipoUtenza = "Normale";

    }

    public void setUtente(String nome, String password) {
        utente.setNome(nome);
        utente.setPassword(password);
    }

    @Override
    public void riceviNotifica() {
        System.out.println("Notifica ricevuta");
    }

    public String getTipoUtenza() {
        return tipoUtenza;
    }

}

class UtenteNormale extends Utente {
    protected Utente utente;
    private String tipoUtenza;

    public UtenteNormale(String nome, String password) {
        super(nome, password);
        setUtente(nome, password);
        this.tipoUtenza = "Normale";

    }

    public void setUtente(String nome, String password) {
        utente.setNome(nome);
        utente.setPassword(password);
    }

    @Override
    public void riceviNotifica() {
        System.out.println("Notifica ricevuta");
    }

    public String getTipoUtenza() {
        return tipoUtenza;
    }
}

abstract class FactoryUtente {
    private static FactoryUtente factory;

    public static void setFactory(FactoryUtente factory) {
        FactoryUtente.factory = factory;
    }

    public abstract Utente istanziaUtente(String nome, String password);

    public Utente creaUtente(String nome, String password) {

        Utente utente = factory.istanziaUtente(nome, password); // creazione del prodotto
        return utente;
    }
}

class FactoryUtenteNormale extends FactoryUtente {

    @Override
    public Utente istanziaUtente(String nome, String password) {
        return new UtenteNormale(nome, password);
    }
}

class FactoryAdmin extends FactoryUtente {

    @Override
    public Admin istanziaUtente(String nome, String password) {
        return new Admin(nome, password);
    }
}
