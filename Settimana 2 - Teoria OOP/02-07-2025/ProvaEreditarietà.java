public class ProvaEreditarietà {
    public static void main(String[] args) {
        Car myCar = new Car();
        Bike myBike = new Bike();

        myBike.run();
        myCar.run();
    }
}

class Vehicle {
    protected String brand = "Ford";

    public void honk() {
        System.out.println("Peeee peeeee");
    }

    void run() {
        System.out.println("Il veicolo è in marcia");
    }
}

class Car extends Vehicle {
    private String modelName = "Fiat";

    public String getModelName() {
        return modelName;
    }

    @Override
    void run() {
        System.out.println("La macchina sta correndo");
    }

}

class Bike extends Vehicle {
    private String modello = "Mountain Bike";

    public String getModello() {
        return modello;
    }

    @Override
    void run() {
        System.out.println("La bici sta biciclando");
    }

}