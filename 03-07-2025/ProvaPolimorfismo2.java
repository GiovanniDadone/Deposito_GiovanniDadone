public class ProvaPolimorfismo2 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Pig myPig = new Pig();
        Dog myDog = new Dog();

        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
}

class Animal {
    public void animalSound() {
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal {
    public void animalSound() {
        System.out.println("The pig makes a sound: Wee Wee");
    }
}

class Dog extends Animal {
    public void animalSound() {
        System.out.println("The dog makes a sound: woof woof");
    }
}

