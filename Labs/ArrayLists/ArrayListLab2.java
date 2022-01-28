/**
 * @author Christian Piper
 * @since 10/27/21
 *     <p>Modify the program written for “Make Number List” to remove even multiples of 3 from the
 *     arraylist and display the arraylist to the screen,
 */
package ArrayLists;

import java.util.ArrayList;

public class ArrayListLab2 {
    public static void main(String[] args) {

        // ArrayList for the multiples of 3
        ArrayList<Integer> multiplesOf3 = new ArrayList<Integer>();

        // Loop through, adding multiples of 3
        for (int i = 0; i < 3 * 100; i += 3) {
            multiplesOf3.add(i);
        }

        // Remove even values from the ArrayList
        for (int i = 0; i < multiplesOf3.size(); i++) {
            if (multiplesOf3.get(i) % 2 == 0) {
                multiplesOf3.remove(i);
            }
        }

        // Print the ArrayList
        System.out.println(multiplesOf3);
    }
}
