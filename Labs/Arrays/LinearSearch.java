/**
 * @author Christian Piper
 * @since 10/4/21
 */
package Arrays;

public class LinearSearch {
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
        search.setData(
                new int[] {1, 2, 3, 4, 5}, new String[] {"Billy", "Bob", "Joe", "Jimmy", "Ryan"});
        search.printData();
        System.out.println(search.findStudent(2));
    }
}
