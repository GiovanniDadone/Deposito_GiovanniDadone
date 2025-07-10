import java.util.Arrays;

public class StringProva {
    public static void main(String[] args) {

        String txt = "Giancasellatore vai casa sei ubriaco";

        System.out.println("Lunghezza della stringa: " + txt.length());  //lunghezza della string compresi gli spazi

        String stringaVuota = "";
        System.out.println("Lunghezza stringa vuota: " + stringaVuota.length());  //prova con Stringa vuota

        System.out.println(txt.toLowerCase());  //tutto in minuscolo

        System.out.println(txt.toUpperCase());  //tutto in maiuscolo

        System.out.println(txt.indexOf("u"));  //prima occurrence della lettera U (volutamente scelta XD) contando gli spazi


        //prova uso metodo .concat()
        String firstName = "Giovanni ";

        String lastName = "Dadone";

        System.out.println(firstName.concat(lastName));

        //concatenazione string e numeri
        String num = 10 + "10";
        System.out.println(num);   //risultato 1010

        String num2 = "10" + 10 + 1;  //risultato 10101
        System.out.println(num2);

        String num3 = 10 + 1 + "10";  //risultato 1110
        System.out.println(num3);


        //special characters prova d'uso
        System.out.println("Ora userò alcuni caratteri speciali: \\backslash \"virgolette \'apostrofo ");

        //sequenze di escape ulteriori
        System.out.println("wewe arriva la nuova riga\n"); 
        System.out.println("eccomi su una nuova riga"+  "\f" + " qualcosa qualcosa qualcosa");

        //prova metodo split()
        String str = "Hello world";
        String[] words = str.split("\\s");
        System.out.println(Arrays.toString(words)); //risultato [Hello, world]

        //risultato prima riga "Hello" e seconda riga "World"
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);  
        }

        String prova1 = "elevata, vorrei agguantarla";
        System.out.println(prova1.contains("au"));  //risultato false
    }
}
