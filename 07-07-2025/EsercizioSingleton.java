public class EsercizioSingleton {
    public static void main(String[] args) {
        System.out.println("Controlliamo se sono lo stesso oggetto");
        System.out.println(Logger.getInstance().equals(Logger.getInstance()));
        System.out.println(Logger.getInstance()==Logger.getInstance());
    }
}
