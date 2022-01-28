/**
 * @uathor Christian Piper
 * @since 10/29/21
 *     <p>Write a method minToFront that takes an ArrayList of ints as a parameter and that moves
 *     the minimum value in the list to the front, otherwise preserving the order of the elements.
 *     For example, if a variable called list stores the following values: {3, 8, 92, 4, 2, 17, 9}
 *     and you make this call: minToFront(list); it should store the following values after the
 *     call: {2, 3, 8, 92, 4, 17, 9} You may assume that the list stores at least one value.
 */
package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListLab3 {
    public static void main(String[] args) {

        // Create a new list
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(3, 8, 92, 4, 2, 17, 9));

        // Create an ArrayListLab3 object (for sorting the list)
        ArrayListLab3 sorter = new ArrayListLab3();

        // Sort the ArrayList, then print it
        System.out.println(sorter.minToFront(list));
    }

    /**
     * Returns an ArrayList with the minimum value of the ArrayList in the first index
     *
     * @param list The raw ArrayList to sort
     * @return The sorted ArrayList
     */
    public ArrayList<Integer> minToFront(ArrayList<Integer> list) {

        // Create a variable to store index of smallest value
        int smallestValIndex = 0;

        // Loop through the ArrayList
        for (int i = 1; i < list.size(); i++) {
            if (list.get(smallestValIndex) > list.get(i)) {
                smallestValIndex = i;
            }
        }

        // Pop the smallest value, the add it to the first element in the ArrayList
        int val = list.get(smallestValIndex);
        list.remove(smallestValIndex);
        list.add(0, val);

        // Return the sorted list
        return list;
    }
}
