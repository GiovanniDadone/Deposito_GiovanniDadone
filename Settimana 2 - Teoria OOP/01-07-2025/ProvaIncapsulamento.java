public class ProvaIncapsulamento {

    public static void main(String[] args) {
        Person person = new Person("Carla", 19);

        System.out.println(person.getName());
        person.stampaStatus();
    }

}

class Person {

    private String name;
    private int età;


    //costruttore
    public Person(String name, int età) {
        this.name = name;
        this.età = età;
    }


    //getter e setter della classe
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    //metodo privato usato solo dalla classe interna
    private boolean verificaMaggiorenne() {
        return this.età >= 18;
    }

    //metodo pubblico che usa un metodo privato
    public void stampaStatus() {
        if (verificaMaggiorenne()) {
            System.out.println(this.getName() + " è maggiorenne");
        } else {
            System.out.println(this.getName() + " non è maggiorenne");
        }
    }
}
