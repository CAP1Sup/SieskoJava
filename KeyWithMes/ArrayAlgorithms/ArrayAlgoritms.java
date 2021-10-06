/**
 * @author Christian Piper
 * @since 10/6/21
 */

package KeyWithMes.ArrayAlgorithms;

public class ArrayAlgoritms {

    // Precondition: none
    // Postcondition: The array elements will be displayed to the console
    public void printArray(int a[]) {
        System.out.println("*******************************");
        for (int i = 0; i < a.length; i++)
        System.out.println("a[ " + i + " ] = " + a[i]);
        System.out.println("*******************************");
    }


}
