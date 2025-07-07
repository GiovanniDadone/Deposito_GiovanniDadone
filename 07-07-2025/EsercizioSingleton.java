public class EsercizioSingleton {
    public static void main(String[] args) {
        Logger.getInstance().scriviMessaggio("Vai! Colpo di formazione combinato: Esplosione dei Campi Flegrei!");
        Logger.getInstance().scriviMessaggio("Cuore del Gigante, Fermalo!");
        System.out.println("Controlliamo se sono lo stesso oggetto");
        System.out.println(Logger.getInstance().equals(Logger.getInstance()) + " con equals()");
        System.out.println((Logger.getInstance()==Logger.getInstance()) + "con il double equals \"==\"");
        //in entrambi i casi stampa true quindi sono lo stesso oggetto chiamato in due momenti diversi
    }
}
