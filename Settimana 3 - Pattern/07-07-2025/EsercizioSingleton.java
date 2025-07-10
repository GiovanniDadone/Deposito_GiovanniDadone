public class EsercizioSingleton {
    public static void main(String[] args) {

        // stampa di due messaggi differenti
        Logger.getInstance().scriviMessaggio("Vai! Colpo di formazione combinato: Esplosione dei Campi Flegrei!");
        Logger.getInstance().scriviMessaggio("Cuore del Gigante, Fermalo!");

        // dimostrazione come l'instanza sia sempre riferita al medesimo oggetto, questa
        // cosa si protrebbe confermare coi contatori ma il fatto che il messaggio di
        // stampa che ho messo nel costruttore viene richiamato solo una volta dimostra
        // che ci sta una sola istanza attiva della classe
        System.out.println("Controlliamo se sono lo stesso oggetto");
        System.out.println(Logger.getInstance().equals(Logger.getInstance()) + " con equals()");
        System.out.println((Logger.getInstance() == Logger.getInstance()) + "con il double equals \"==\"");
        // in entrambi i casi stampa true quindi sono lo stesso oggetto chiamato in due
        // momenti diversi
    }
}
