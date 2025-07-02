import java.util.ArrayList;

public class ProvaOverride {
    public static void main(String[] args) {

        ArrayList<Bank> banche = new ArrayList<>();
        banche.add(new SBI());
        banche.add(new Mediolanum());
        banche.add(new ISP());

        for (Bank bank : banche) {
            System.out.println( "Banca: " + bank.getClass().getSimpleName() + "Tasso d'interesse: " + bank.getRateOfInterest());
        }
    }
}

class Bank {
    int getRateOfInterest() {
        return 0;
    }
}

class SBI extends Bank {
    int getRateOfInterest() {
        return 1;
    }
}

class Mediolanum extends Bank {
    int getRateOfInterest() {
        return 2;
    }
}

class ISP extends Bank {
    int getRateOfInterest() {
        return 3;
    }
}
