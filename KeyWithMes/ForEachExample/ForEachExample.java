/**
 * @author Christian Piper
 * @since 10/6/21
 */
package KeyWithMes.ForEachExample;

public class ForEachExample {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int total = 0;

        for (int element : arr) {
            total = total + element;
        }

        System.out.println("Total: " + total);
    }
}
