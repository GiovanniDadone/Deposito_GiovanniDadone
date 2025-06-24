public class OperatoriAssegnazione {
    public static void main(String[] args) {

        int x = 10;

        x += 5;
        System.out.println(x); // risultato 15

        x -= 4;
        System.out.println(x); // risultato 11

        x *= 2;
        System.out.println(x); // risultato 22

        x /= 2;
        System.out.println(x); // risultato 11

        x %= 2;
        System.out.println(x); // resto 1

        x = 11;

        // print di controllo dei singoli
        System.out.println(x > 5);

        System.out.println(x < 5);

        System.out.println(x >= 11);

        System.out.println(x <= 11);

        System.out.println(x == 5);

        System.out.println(x != 5);

        // operatori logici
        System.out.println(x > 10 && x < 12);  //risultato true

        System.out.println(x >= 11 || x > 999);   //risultato true
        
        System.out.println(!(x>12));    //risultato true

    }
}
