public class ProvaMath {
    public static void main(String[] args) {
        int a = 9;
        int b = 16;

        //Min e Max, esempi
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        System.out.println("Fra i due numeri \'a\' e \'b\' il numero più piccolo è \'a\': " + min);
        System.out.println("Fra i due numeri \'a\' e \'b\' il numero più grande è \'b\': " + max);

        //Calclo radice quadrata
        double radiceA = Math.sqrt(a);
        double radiceB = Math.sqrt(b);
        System.out.println("La prima radice è: " + radiceA + ", la seconda radice è: " + radiceB);

        //resa valore assoluto di un numero
        double assoluto = Math.abs(-11);
        System.out.println("Il valore assoluto è: " + assoluto);

        //uso di random
        int randomNum = (int)(Math.random()*101);
        System.out.println(randomNum); 
    }
}
