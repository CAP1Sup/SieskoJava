public class Test {
    public static void main(String[] args) {
        printBits(0.1);
    }

    public static void printBits(double num) {
        String max = "0" + Long.toBinaryString(Double.doubleToLongBits(num));

        String sign = "Sign: " + max.substring(0, 1);
        String exponent = "Exponent: " + max.substring(1, 12); // 11111111110
        String mantissa = "Mantissa: " + max.substring(12);

        System.out.println(sign); // 0 - positive
        System.out.println(exponent); // 2046 - 1023 = 1023
        System.out.println(mantissa); // 0.99999...8
    }
}
