/**
 * @author Christian Piper
 * @since 11/5/21
 */
package Labs.ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a method markLength4 that takes an ArrayList of Strings as a parameter and that places a
 * string of four asterisks "****" in front of every string of length 4. For example, suppose that a
 * variable called list contains the following values: {"this", "is", "lots", "of", "fun", "for",
 * "every", "Java", "programmer"} And you make the following call: markLength4(list); then list
 * should store the following values after the call: {"****", "this", "is", "****", "lots", "of",
 * "fun", "for", "every", "****", "Java", "programmer"} Notice that you leave the original strings
 * in the list, "this", "lots", "Java", but include the four-asterisk string in front of each to
 * mark it.
 */
public class ArrayListLab4 {

    /**
     * Adds a String "****" in front of every String with a length of 4 or greater
     *
     * @param list The list to look through and add markers to
     */
    public void markLength4(ArrayList<String> list) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).length() >= 4) {
                list.add(index, "****");
                index++;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list =
                new ArrayList<String>(
                        Arrays.asList(
                                "this",
                                "is",
                                "lots",
                                "of",
                                "fun",
                                "for",
                                "every",
                                "Java",
                                "programmer"));
        ArrayListLab4 marker = new ArrayListLab4();
        marker.markLength4(list);
        System.out.println(list);
    }
}
