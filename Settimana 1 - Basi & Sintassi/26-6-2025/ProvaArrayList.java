import java.util.ArrayList;
import java.util.Collections;

public class ProvaArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> numeri = new ArrayList<>();
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

        ArrayList<String> nomi = new ArrayList<>();
        nomi.add("Alice");
        nomi.add("Bob");
        nomi.add("Carlo");

        System.out.println("Primo nome" + nomi.get(0));

        for (Integer integer : numeri) {
            System.out.println(integer);
        }

        ArrayList<Integer> numeri2 = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            numeri2.add((int) (Math.random()*100) +1); 
        }

        //stampa lista randomica
        System.out.println(numeri2);

        //ordina in ordine crescente
        Collections.sort(numeri2);

        //stampa della lista ordinata
        System.out.println("Lista ordinata " + numeri2);
    }
}
