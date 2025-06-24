import java.util.Scanner;

public class ProvaScanner {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);  //creazione nuovo scanner object

        String username = myScanner.nextLine();   //lettura input dello user e registrato all'interno di una variabile 

        System.out.println("Username is: "+ username);   //print a terminale dell'input registrato

        myScanner.close();
    }
}
