import java.util.ArrayList;

class Calcolatrice {

    // metodo con ritorno
    int somma(int a, int b) {
        return a + b;
    }

    // metodo senza ritorno
    void saluta() {
        System.out.println("Ue ue ciao!");
    }
}

class Auto {
    String marca;
    int anno;

    Auto(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }
    
}

public class ProvaClassi {

    public static void main(String[] args) {

        //parte della calcolatrice
        Calcolatrice calcolatrice = new Calcolatrice();

        calcolatrice.saluta();

        //immagazzina il risultato del metodo somma in una variabile e poi la stampa
        int risultato = calcolatrice.somma(5, 3);
        System.out.println("Il risutato è: " + risultato);

        //parte della classe auto
        ArrayList<Auto> autoList = new ArrayList<>();
        autoList.add(new Auto("Tesla", 2023));
        autoList.add(new Auto("Ford", 2020));

        //stampa lista auto
        for (Auto auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }

}
