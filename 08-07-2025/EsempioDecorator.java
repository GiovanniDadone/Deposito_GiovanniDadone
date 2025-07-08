public class EsempioDecorator {
    public static void main(String[] args) {
        Component componente = new ConcreteComponent();
        Component decorator = new ConcreteDecorator(componente);

        componente.operation();
        decorator.operation();
    }
}


//interfaccia Component
interface Component {
    void operation();
}

//componente concreto implementato
class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("Operazione base");
    }

}

//classe Decorator astratta
abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

//classe Decorator concreto
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        System.out.println("Aggiunta funzionalità A");
    }
}