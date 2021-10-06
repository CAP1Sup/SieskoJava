/**
 * @author Christian Piper
 * @since 10/4/21
 */

package Labs.ArrayLab2;

public class LinearSearch {
/*
setData method

print method

findStudent method.

The set_data method should prompt for the social security number and last name for five people.
The print_data function should print the names and ss# of the five people from the array.
The find_student function should use a linear search through the array by ss#.
If the ss# is found print the name and ss# is in the list in the main function using the index which was returned from find_Student()

If the ss# is not found print not found.
*/
    private int[] ssNums;
    private String[] lastNames;

    LinearSearch() {
        ssNums = new int[5];
        lastNames = new String[5];
    }

    public void setData(int ssNums[], String lastNames[]) {
        this.ssNums = ssNums;
        this.lastNames = lastNames;
    }

    public void printData() {
        for (int index = 0; index < ssNums.length; index++) {
            System.out.println("Last name: " + lastNames[index]);
            System.out.println("Social Security number: " + ssNums[index]);
            System.out.println();
        }
    }

    public String findStudent(int ssNum) {
        for (int index = 0; index < ssNums.length; index++) {
            if (ssNums[index] == ssNum) {
                return lastNames[index];
            }
        }
        return "Not found";
    }

    public static void main(String[] args) {
        LinearSearch search = new LinearSearch();
        search.setData(new int[]{1, 2, 3, 4, 5}, new String[]{"Billy", "Bob", "Joe", "Jimmy", "Ryan"});
        search.printData();
        System.out.println(search.findStudent(2));
    }
}
