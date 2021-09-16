/**
 * @author Christian Piper
 * @since 9/16/21
 */

package Exercises.PlayingWithCasting;

public class PlayingWithCasting {

    public static void main(String[] args) {
        int x = 5;
        int y = 2;
        double z = 4.0;

        int k;
        double p;

        k = x / y;
        System.out.println("Line 1: " + k);

        k = (int) z / x;
        System.out.println("Line 2: " + k);

        k = (int) z / y;
        System.out.println("Line 3: " + k);

        k = (int) (z / y);
        System.out.println("Line 4: " + k);

        p = x / y;
        System.out.println("Line 5: " + p);

        p = z / x;
        System.out.println("Line 6: " + p);

        p = (int) z / y;
        System.out.println("Line 7: " + p);

        p = (double) x / y;
        System.out.println("Line 8: " + p);

        p = (double) (x / y);
        System.out.println("Line 9: " + p);
    }
}
