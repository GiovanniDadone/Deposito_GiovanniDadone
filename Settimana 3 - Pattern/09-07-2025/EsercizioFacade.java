public class EsercizioFacade {
    public static void main(String[] args) {
        GestioneLuciFacade facade = new GestioneLuciFacade();
        facade.accendiTutte();
    }
}

class LuceCamera {
    public void accendi() {
        System.out.println("Luce camera accesa");
    }
}

class LuceCucina {
    public void accendi() {
        System.out.println("Luce cucina accesa");
    }
}

class GestioneLuciFacade {
    private LuceCamera luceA = new LuceCamera();
    private LuceCucina luceB = new LuceCucina();

    public void accendiTutte() {
        luceA.accendi();
        luceB.accendi();
    }
}