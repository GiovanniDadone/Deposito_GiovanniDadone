public class EsempioEccezioni {
    public static void main(String[] args) {

        try {
            int x = 3;
            int y = 2;
            int z = x / y;
            System.out.println("z = " + z);
        } catch (Exception e) {
            System.out.println("Qualcosa è andato storto");
            e.printStackTrace();
        } finally {
            System.out.println("Esecuzione inevitabile del blocco finally");
        }
        System.out.println("Programma terminato");
    }

}
