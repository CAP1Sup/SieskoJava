/**
 * @author Christian Piper
 * @since 10/4/21
 */

package Labs.Arrays;

class Average {

    // Arrays of student data
    private static double[] exam1;
    private static double[] exam2;
    private static double[] averages;
    private static int[] studentIDs;

    Average() {
        studentIDs = new int[10];
        for (int i = 0; i < studentIDs.length; i++) {
            studentIDs[i] = i;
        }
        exam1 = new double[10];
        exam2 = new double[10];
        averages = new double [10];
    }

    public static void main(String[] args) {
        Average average = new Average();
        average.setData(exam1, exam2);
        average.calcAverage(exam1, exam2, averages);
        int index = average.linearSearch(studentIDs, 3);
        System.out.println("Student ID: " + studentIDs[index]);
        System.out.println("Exam 1:     " + exam1[index]);
        System.out.println("Exam 2:     " + exam2[index]);
        System.out.println("Averages:   " + averages[index]);
    }

    /**
     * Sets the arrays to random values between 0 and 100. Arrays must be the same length
     * @param array1 The first array to fill with random values
     * @param array2 The second array to fill with random values
     */
    public void setData(double[] array1, double[] array2) {
        for (int i = 0; i < array1.length; i++) {
            array1[i] = roundToPlace(Math.random() * 100, 2);
            array2[i] = roundToPlace(Math.random() * 100, 2);
        }
    }

    /**
     * Sets the respective values of the averages list to the average of the array 1 and array 2 at each index
     * @param array1 The first array to look at
     * @param array2 The second array to look at
     * @param averages The averages array
     */
    public void calcAverage(double[] array1, double[] array2, double[] averages) {
        for (int i = 0; i < array1.length; i++) {
            averages[i] = roundToPlace((array1[i] + array2[i]) / 2, 2);
        }
    }

    /**
     * Looks through the student ID array to find the target.
     * @param studentIDs an array of all of the student IDs
     * @param target the student ID to search for
     * @return index of student, -1 and prints "Invalid Student ID" if student doesn't exist
     */
    public int linearSearch(int[] studentIDs, int target) {
        for (int i = 0; i < studentIDs.length; i++) {
            if (studentIDs[i] == target) {
                return i;
            }
        }
        System.out.println("Invalid Student ID");
        return -1;
    }


    /**
     * Rounds the double to a particular place
     * @param num The number to round
     * @param place The place to round to (count of numbers after decimal place)
     * @return The rounded number
     */
    public double roundToPlace(double num, int place) {
        return ((double)((int)Math.round(num * Math.pow(10, place))) / Math.pow(10, place));
    }
}