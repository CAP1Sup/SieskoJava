/**
 * @author Christian Piper
 * @since 11/21/21
 */

package Labs.Arrays.TwoDArrays;

public class ASCIIArtII {

    public static void main(String[] args) {
        String[][] asciiArt = {
            {" ", " ", "_", "_", "_", " ", " "},
            {" ", "(", "o", " ", "o", ")", " "},
            {"(", " ", " ", "V", " ", " ", ")"},
            {" ", "-", "m", "-", "m", "-", " "},
        };

        // Part 1: Add 2 assignment statements to change "o" to "@"
        for (int i = 0; i < asciiArt.length; i++) {
            for (int j = 0; j < asciiArt[0].length; j++) {
                if (asciiArt[i][j].equals("o")) {
                    asciiArt[i][j] = "@";
                }
            }
        }

        // print the asciiArt for Part 1
        System.out.println("ASCII Art:");
        for (String[] row : asciiArt) {
            for (String column : row) System.out.print(column);
            System.out.println();
        }

        // Part 2: Create your own ASCII art array and print it out!
        String[][] artPart2 = {
            {"H", " ", " ", " ", "H", " ", " ", "H", " ", " ", "H"},
            {"H", " ", " ", " ", "H", " ", " ", " ", " ", " ", "H"},
            {"H", "H", "H", "H", "H", " ", " ", "H", " ", " ", "H"},
            {"H", " ", " ", " ", "H", " ", " ", "H", " ", " ", " "},
            {"H", " ", " ", " ", "H", " ", " ", "H", " ", " ", "H"}
        };

        // print the asciiArt for Part 1
        System.out.println("ASCII Art Part 2:");
        for (String[] row : artPart2) {
            for (String column : row) System.out.print(column);
            System.out.println();
        }
    }
}
