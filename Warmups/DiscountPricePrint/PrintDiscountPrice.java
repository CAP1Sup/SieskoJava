/**
 * @author Christian Piper
 * @since 9/2/21
 */

// Import package
package Warmups.DiscountPricePrint;

// Main class
public class PrintDiscountPrice {
    public static void main(String[] args) {

        final double INITIAL_PRICE = 55.95;
        final double DIS_PRICE = INITIAL_PRICE * 0.6;

        System.out.println(DIS_PRICE);
        System.out.println("Discount price is: $" + DIS_PRICE);
        System.out.println(
                "The initial price of $55.95 was discounted 40%. The sale price is: $" + DIS_PRICE);
    }
}
