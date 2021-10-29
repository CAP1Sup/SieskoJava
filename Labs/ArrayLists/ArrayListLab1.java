
/**
 * @author Christian Piper
 * @since 10/27/21
 *
 * Write a short program using a for loop to create an ArrayList called multiplesOf3 of the first 100 multiples of 3 starting with 0. Upon completing this ArrayList, have the computer print the contents of the ArrayList. Use eclipse to code and test the program.
 */

package Labs.ArrayLists;

import java.util.ArrayList;

public class ArrayListLab1 {
    public static void main(String[] args) {

        // ArrayList for the multiples of 3
        ArrayList<Integer> multiplesOf3 = new ArrayList<Integer>();

        // Loop through, adding multiples of 3
        for (int i = 0; i < 3*100; i+=3) {
            multiplesOf3.add(i);
        }

        // Print the ArrayList
        System.out.println(multiplesOf3);
    }
}
