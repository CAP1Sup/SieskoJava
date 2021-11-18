/**
 * @author Christian Piper
 * @since 11/18/21
 */
package KeyWithMes.TwoDArrays;

/**
 * 2  4  8  4
 * 11 12 9  5
 * 10 3  2 -2
 */

public class TwoDimArrayPrints {
    public static void main(String[] args) {

        // Declare 3 by 4 array
        // new int[rows][columns]
        int table[][] = new int[3][4];

        // Set the table values
        table[0] = new int[]{2, 4, 9, 4};
        table[1] = new int[]{11, 12, 9, 5};
        table[2] = new int[]{10, 3, 2, -2};

        // Print the array
        for (int[] row : table) {
            for (int element : row) {
                System.out.print(element + ", ");
            }
            System.out.println();
        }
    }
}
