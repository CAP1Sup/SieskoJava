/**
 * @author Christian Piper
 * @since 9/20/21
 */
package Review.Unit_1_Rev_II;

public class ReviewQuestions {

    static int test1Score = 90;
    static int test2Score = 100;
    static int side1 = 3;
    static int side2 = 4;
    static String room1 = "Chalmers 303";
    static String room2 = "Rugby 202";
    static String name = "ChRisTian PiPER";

    public static void main(String[] args) {

        // #13
        System.out.println("Test average: " + (((double) test1Score + (double) test2Score)) / 2);

        // #14
        System.out.println("Hypotenuse: " + Math.sqrt((double) (side1 * side1 + side2 * side2)));

        // #15
        System.out.println("Random num: " + (int) (Math.random() * 23 + 83));

        // #16
        System.out.println("Room 1 number: " + getRoomNumber(room1));
        System.out.println("Room 2 number: " + getRoomNumber(room2));

        // #17
        System.out.println("Fixed name: " + fixCapital(name));
    }

    // #16
    static int getRoomNumber(String room) {
        return Integer.parseInt(room.substring(room.indexOf(' ') + 1));
    }

    // #17
    static String fixCapital(String str) {
        String[] fixedName = str.toLowerCase().split("");
        fixedName[0] = fixedName[0].toUpperCase();

        int index = str.indexOf(" ") + 1;
        fixedName[index] = fixedName[index].toUpperCase();

        String joinedString = "";
        for (String s : fixedName) {
            joinedString += s;
        }

        return joinedString;
    }
}
