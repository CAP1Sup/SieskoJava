public class IntArrayWorker {
    /** two dimensional matrix */
    private int[][] matrix = null;

    /**
     * set the matrix to the passed one
     *
     * @param theMatrix the one to use
     */
    public void setMatrix(int[][] theMatrix) {
        matrix = theMatrix;
    }

    /**
     * Method to return the total
     *
     * @return the total of the values in the array
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                total = total + matrix[row][col];
            }
        }
        return total;
    }

    /**
     * Method to return the total using a nested for-each loop
     *
     * @return the total of the values in the array
     */
    public int getTotalNested() {
        int total = 0;
        for (int[] rowArray : matrix) {
            for (int item : rowArray) {
                total = total + item;
            }
        }
        return total;
    }

    /** Method to fill with an increasing count */
    public void fillCount() {
        int numCols = matrix[0].length;
        int count = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < numCols; col++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }

    /** print the values in the array in rows and columns */
    public void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /** fill the array with a pattern */
    public void fillPattern1() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (row < col) matrix[row][col] = 1;
                else if (row == col) matrix[row][col] = 2;
                else matrix[row][col] = 3;
            }
        }
    }

    /**
     * Gets the number of times a number shows up in the array
     *
     * @param number The number that should be counted
     * @return The number of times the number appears in the array
     */
    public int getCount(int number) {

        // Start the counter at 0
        int count = 0;

        // Loop through each row
        for (int[] row : matrix) {

            // Loop through each column
            for (int element : row) {

                // Check if the number is the same
                if (element == number) {
                    count++;
                }
            }
        }

        // Return the count
        return count;
    }

    /**
     * Gets the largest number in the array
     *
     * @return The largest number in the array
     */
    public int getLargest() {

        // Set the largest to the first value in the array
        int largest = matrix[0][0];

        // Loop through each row
        for (int[] row : matrix) {

            // Loop through each column
            for (int element : row) {

                // Check if the number is larger than the largest
                if (element > largest) {
                    largest = element;
                }
            }
        }

        // Return the largest number
        return largest;
    }

    /**
     * Gets the total of a column in the array
     *
     * @param column The column to be totalled
     * @return The total of the column
     */
    public int getColTotal(int column) {

        // Start the total at 0
        int total = 0;

        // Loop through each row, adding each element to the total
        for (int[] row : matrix) {
            total += row[column];
        }

        // Return the total
        return total;
    }
}
