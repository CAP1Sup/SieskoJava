/**
 * @author Christian Piper
 * @since 10/6/21
 */

package KeyWithMes.ArrayAlgorithms;

public class ArrayAlgorithms {

    // Precondition: none
    // Postcondition: The array elements will be displayed to the console
    public void printArray(int a[]) {
        System.out.println("*******************************");
        for (int i = 0; i < a.length; i++)
        System.out.println("a[ " + i + " ] = " + a[i]);
        System.out.println("*******************************");
    }

    // Precondition: none
    // Postcondition: array a will contain random integers where 0 <= n < 100
    public void fillWithRandom(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 100);
        }
    }

    // Precondition: 0 <= index < a.length
    // Postcondition: The value at index is overwritten
    public void deleteAtIndex(int a[], int index) {
        for (int i = index; i < a.length - index; i++) {
            a[i] = a[i + index];
        }
        a[a.length - 1] = 0;
    }

    // Precondition: none
    // Postcondition: the index where the key was found is returned (-1 if not found)
    public int linearSearch(int a[], int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Precondition: array a
    // Postcondition: array will be sorted from least to greatest
    public void bubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * Searches the an array for a value using a binary search method
     * @param a the array to be searched
     * @param key the value to be found
     * @return the index of the value. -1 is returned if value doesn't exist
     */
    public int binarySearch(int a[], int key) {

        // Bubble sort the array
        selectionSort(a);

        int low = 0;
        int high = a.length - 1;
        int middle;

        // Loop until the low index is greater than the high index
        while (low <= high) {

            // Calculate the middle index
            middle = (low + high) / 2;

            // If key matches the middle element
            if (key == a[middle]) {
                return middle;
            }
            else if (key > a[middle]) {
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return -1;
    }


    // Search for the smallest number in the array and store in the minimum variable
    public void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {

            // Create a value to store the minimum index
            int minIndex = i;

            // Loop through the minimum value
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the values
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }


    public static void main(String[] args) {
        int a[] = new int[1000];
        int testCount = 100000;
        ArrayAlgorithms algorithms = new ArrayAlgorithms();

        long start;

        long totalBubbleTime = 0;
        long totalSelectionTime = 0;

        int counter = 0;

        // Loop through, randomizing and counting
        for (int i = 0; i < testCount; i++) {

            // Fill with randoms
            algorithms.fillWithRandom(a);

            // Bubble sort
            start = System.currentTimeMillis();
            algorithms.bubbleSort(a);
            totalBubbleTime += (System.currentTimeMillis() - start);

            // Selection sort
            start = System.currentTimeMillis();
            algorithms.selectionSort(a);
            totalSelectionTime += (System.currentTimeMillis() - start);

            // Print the test number
            System.out.println("Completed test #" + counter);
            counter++;
        }


        // Print average time taken
        System.out.println("Bubble avg time: " + ((double)totalBubbleTime / testCount));
        System.out.println("Selection avg time: " + ((double)totalSelectionTime / testCount));


        /*
        algorithms.fillWithRandom(a);
        algorithms.printArray(a);
        System.out.println("Linear search for 10: " + algorithms.linearSearch(a, 10));
        algorithms.bubbleSort(a);
        algorithms.printArray(a);
        algorithms.deleteAtIndex(a, 3);
        algorithms.printArray(a);
        algorithms.fillWithRandom(a);
        algorithms.selectionSort(a);
        algorithms.printArray(a);
        System.out.println("Binary search for 10: " + algorithms.binarySearch(a, 10));
        */
    }

}
