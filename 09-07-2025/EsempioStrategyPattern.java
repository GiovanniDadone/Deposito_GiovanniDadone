public class EsempioStrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.performTask();
        context.setStrategy(new ConcreteStrategyB());
        context.performTask();
    }
}

// interfaccia Strategy (può essere una classe astratta)
interface Strategy {
    void execute();
}

// strategie concrete, sono intercambiabili fra di loro (ovviamente fanno cose differenti)
class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategia A Eseguita");
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Strategia B Eseguita");
    }
}

// Context
class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // performTask() esegue l'execute riferito all'oggetto nella variabile strategy.
    // poi quale variante di Strategy non è un problema che pesa su questo metodo
    public void performTask() {
        strategy.execute();
    }
}