// Christian Piper
// 9/2/21

// Import the package
package Exercises.CatDogSubclasses;

// Import both cat and dog classes
import Exercises.CatDogSubclasses.Cat;
import Exercises.CatDogSubclasses.Dog;

public class Tester {
    public static void main(String[] args) {

        // Create the objects
        Dog theDog = new Dog();
        Cat theCat = new Cat();

        theDog.bark();
        theCat.meow();
    }
}
