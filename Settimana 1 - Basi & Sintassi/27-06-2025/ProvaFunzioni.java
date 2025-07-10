public class ProvaFunzioni {

    //funzione senza parametri
    static void saluta() {
        System.out.println("Ue ue ciao uagliò");
    }

    //funzione con parametri
    static int somma(int a, int b) {
        return a + b;
    }

    //overload dei metodi
    static void mostra(int numero) {
        System.out.println(numero);
    }

    static void mostra(String parola) {
        System.out.println(parola);
    }


    public static void main(String[] args) {
        saluta();  //chiamata della funzione senza parametri
        System.out.println(somma(10, 20));  //chiamata della funzione con parametri  Output: 30
        mostra(99);
        mostra("ueueue");
    }
}
