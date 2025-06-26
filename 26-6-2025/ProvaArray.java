public class ProvaArray {
    public static void main(String[] args) {
        // inizializzazione array
        int[] numeri = new int[5]; // array di dimensione 5, ma ogni valore sarà nullo che per gli int è zero

        // inizializzazine diretta di un array di dimensione 5 coi valori già
        // assegnati
        int[] valori = { 1, 2, 3, 4, 5 };

        // stampa primo elemento array[] valori
        System.out.println("Primo numero: " + valori[0]);

        // riempimento array[] "numeri"
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = i + 1;
        }

        // stampa tutti gli elementi dell'array
        System.out.println("Elementi degli array");
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i] + " ");
        }
        System.out.println();

        // Array2D
        int[][] matrice = new int[3][3];
        int valore = 1;

        // inizializzazione diretta
        int[][] matricePredefinita = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        //rimepimento matrice con numeri progressivi
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                matrice[i][j] = valore++;
            }
        }

        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                System.out.print(matrice[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
