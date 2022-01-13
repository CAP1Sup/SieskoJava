/**
 * @author Christian Piper
 * @since 9/2/21
 */

// Import package
package CatDogSubclasses;

public class Animal {

    // Define variables
    private String color;
    private String breed;
    private int age;

    // Main constructor
    Animal() {
        this.color = "";
        this.breed = "";
        this.age = 0;
    }

    // Constructor with color
    Animal(String color) {
        this.color = color;
        this.breed = "";
        this.age = 0;
    }

    // Constructor with color and breed
    Animal(String newColor, String newBreed) {
        this.color = newColor;
        this.breed = newBreed;
        this.age = 0;
    }

    // Constructor with color, breed, and age
    Animal(String newColor, String newBreed, int newAge) {
        this.color = newColor;
        this.breed = newBreed;
        this.age = newAge;
    }

    // Get Methods
    String getColor() {
        return this.color;
    }

    String getBreed() {
        return this.breed;
    }

    int getAge() {
        return this.age;
    }

    // Set Methods
    void setColor(String color) {
        this.color = color;
    }

    void setBreed(String breed) {
        this.breed = breed;
    }

    void setAge(int age) {
        this.age = age;
    }
}
