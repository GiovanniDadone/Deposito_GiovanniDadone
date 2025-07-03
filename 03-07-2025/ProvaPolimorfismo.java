import java.util.ArrayList;

public class ProvaPolimorfismo {

    void azionatore(X obj) {

        obj.azione();

    }

    public static void main(String[] args) {
        ArrayList<X> InsiemeX = new ArrayList<X>();

        InsiemeX.add(new X());
        InsiemeX.add(new X1());
        InsiemeX.add(new X2());

        for (X x : InsiemeX) {
            x.azione();
        }
    }

}

class X {

    void azione() {
        System.out.println("azione generica");
    }

}

class X2 extends X {

    void azione() {
        System.out.println("azione x2");
    }

}

class X1 extends X {

    void azione() {
        System.out.println("azione x1");
    }

}
