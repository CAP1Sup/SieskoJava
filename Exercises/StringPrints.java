// Christian Piper
// 9/10/21

package Exercises.StringPrints;

public class StringPrints {

    static String one = "abcdefghijklm";
    static String two = "109876543210";
    static String three = "01 23 45 67 89 0";
    static String s2 = "beat";
    static String s3 = "even";

    public static void main(String[] args) {
        System.out.println(one.length());
        System.out.println(one.compareTo(s2));
        System.out.println(s3.compareTo(one));
        System.out.println(s3.compareTo(s2.substring(1)));
        System.out.println(one.charAt(1));
        System.out.println(one.charAt(one.length()-1));
        System.out.println(one.charAt(9));
        System.out.println(one.substring(0, 4));
        System.out.println(one.substring(5));
        System.out.println(one.substring(one.length()));
        System.out.println(one.substring(2, 5));
        System.out.println(one.substring(2, one.length()));
        System.out.println(one.indexOf("abc"));
        System.out.println(one.indexOf("e"));
        System.out.println(one.indexOf("hij"));
        System.out.println(two.indexOf("65"));
        System.out.println(two.indexOf("24"));
        System.out.println(one.indexOf('c'));
        System.out.println(three.indexOf(" "));
        System.out.println(two.indexOf(three.charAt(3)));
        System.out.println(two.charAt(three.indexOf(3)));
    }
}
