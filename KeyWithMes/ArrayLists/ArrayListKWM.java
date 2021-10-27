/**
 * @author Christian Piper
 * @since 10/27/21
 */

import java.awt.Color;
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
    }
}
