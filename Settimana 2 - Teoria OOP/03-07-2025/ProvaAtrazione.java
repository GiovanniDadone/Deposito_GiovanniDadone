public class ProvaAtrazione {
    public static void main(String[] args) {
        Animal2 myPig = new Pig2();
        Animal2 myDog = new Dog2();

        myPig.animalSound();
        myDog.animalSound();
    }
}

abstract class Animal2 {
    public abstract void animalSound();
}

class Pig2 extends Animal2 {

    @Override
    public void animalSound() {
        System.out.println("The pig says: weeeee weeeeee");
        
    }
    
}

class Dog2 extends Animal2 {

    @Override
    public void animalSound() {
        System.out.println("The dog says: wooof woof");        
    }
    
}