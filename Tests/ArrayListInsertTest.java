/**
 * @author Christian Piper
 * @since 11/18/21
 */
package Tests;

import java.util.ArrayList;
import java.util.List;

public class ArrayListInsertTest {
  public static void main(String[] args) {

    // Declare the number of iterations to do
    final int iterations = 100000;

    // Get the current time
    long startTime = System.currentTimeMillis();

    // Loop through a set number of iterations
    for (int i = 0; i < iterations; i++) process1(i);

    // Log the time taken
    long process1Time = System.currentTimeMillis() - startTime;
    startTime = System.currentTimeMillis();

    // Loop through a set number of iterations
    for (int i = 0; i < iterations; i++) process2(i);

    // Get the time taken
    long process2Time = System.currentTimeMillis() - startTime;

    // Print out the time taken
    System.out.println("Process 1 time: " + process1Time);
    System.out.println("Process 2 time: " + process2Time);
  }

  public static List<Integer> process1(int n) {
    List<Integer> someList = new ArrayList<Integer>();
    for (int k = 0; k < n; k++) someList.add(k);
    return someList;
  }

  public static List<Integer> process2(int n) {
    List<Integer> someList = new ArrayList<Integer>();
    for (int k = 0; k < n; k++) someList.add(k, k);
    return someList;
  }
}
