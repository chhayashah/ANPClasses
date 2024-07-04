//overriding

// Write a Java program to demonstrate method overriding by creating an Animal
// class with
// a sound() method, and two subclasses Dog and Cat that override

// the sound() method to produce their respective sounds.

class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Overriding the sound() method for Dog
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Cat.java
class Cat extends Animal {
    // Overriding the sound() method for Cat
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Creating objects of Animal, Dog, and Cat
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        // Calling the sound() method
        myAnimal.sound(); // Output: Animal makes a sound
        myDog.sound(); // Output: Dog barks
        myCat.sound(); // Output: Cat meows
    }
}
