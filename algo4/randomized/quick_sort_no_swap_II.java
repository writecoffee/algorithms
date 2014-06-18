import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * In the previous challenge, you wrote a partition method to split an array into 2 sub-arrays, one
 * containing smaller elements and one containing larger elements. This means you 'sorted' half the
 * array with respect to the other half. Can you repeatedly use partition to sort an entire array?
 * 
 * In this challenge, print your array every time your partitioning method finishes, i.e. print
 * every sorted sub-array The first element in a sub-array should be used as a pivot. Partition the
 * left side before partitioning the right side. The pivot should not be added to either side.
 * Instead, put it back in the middle when combining the sub-arrays together.
 * 
 * Sample Input
 * 
 * 7 
 * 5 8 1 3 7 9 2
 * 
 * Sample Output 
 * 
 * 2 3 
 * 1 2 3 
 * 7 8 9 
 * 1 2 3 5 7 8 9
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://www.hackerrank.com/challenges/quicksort2}
 * 
 */
public class quick_sort_no_swap_II {
    public static void printArray(PrintWriter out, int[] array, int start, int end) {
        for (int i = start; i < end; ++i) {
            out.print(array[i]);
            out.print(" ");
        }

        out.println();
    }

    public static void quickSort(PrintWriter out, int[] array, int start, int end) {
        int n = end - start;

        if (n <= 1) {
            return;
        }

        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> bigger = new ArrayList<Integer>();
        int pivot = array[start];

        for (int i = start + 1; i < end; ++i) {
            if (array[i] > pivot) {
                bigger.add(array[i]);
            } else {
                smaller.add(array[i]);
            }
        }

        for (int i = start; i < end; ++i) {
            if (i - start < smaller.size()) {
                array[i] = smaller.get(i - start);
            } else if (i - start == smaller.size()) {
                array[i] = pivot;
            } else {
                array[i] = bigger.get(i - smaller.size() - start - 1);
            }
        }

        quickSort(out, array, start, start + smaller.size());
        quickSort(out, array, start + smaller.size() + 1, end);
        printArray(out, array, start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());

        String[] numbers = in.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }

        quickSort(out, array, 0, n);

        in.close();
        out.close();
    }
}