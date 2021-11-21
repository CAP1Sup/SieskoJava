/**
 * @author Christian Piper
 * @since 10/27/21
 */
package KeyWithMes.ArrayLists;

import java.util.ArrayList;

public class ArrayListKWM {

    // Main method
    public static void main(String[] args) {

        // Declare an ArrayList to store String types
        ArrayList<String> list = new ArrayList<String>();

        // Add items to the end of the list
        list.add("red");
        list.add("white");
        list.add("blue");

        // Print the list
        System.out.println(list);

        // Print the list another way
        for (String e : list) {
            System.out.println(e);
        }

        // Print the list another way
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Print the size of the list
        System.out.println("The size of the ArrayList is: " + list.size());

        ArrayList<Object> newList = new ArrayList<Object>();

        // Add a string object
        newList.add("We the People");

        // Not on AP exam (only for Java 9+)
        newList.add(42);

        // On the AP exam
        Integer theOne;
        theOne = 3;
        newList.add(theOne);
        newList.add((Double) 2.42);

        // Print out the new list
        System.out.println(newList);
    }
}
