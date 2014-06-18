import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The previous challenges covered Insertion Sort, which is a simple and intuitive sorting
 * algorithm. Insertion Sort has a running time of O(N2) which isn't fast enough for most purposes.
 * Instead, sorting in the real-world is done with faster algorithms like Quicksort, which will be
 * covered in the challenges that follow.
 * 
 * The first step of Quicksort is to partition an array into two smaller arrays.
 * 
 * You're given an array ar and a number p. Partition the array, so that, all elements
 * greater than p are to its right, and all elements smaller than p are to its left.
 * 
 * In the new sub-array, the relative positioning of elements should remain the same, i.e., if n1
 * was before n2 in the original array, it must remain before it in the sub-array. The only
 * situation where this does not hold good is when p lies between n1 and n2
 * 
 * i.e., n1 > p > n2.
 * 
 * Guideline
 * 
 * In this challenge, you do not need to move around the numbers 'in-place'. This means
 * you can create 2 lists and combine them at the end.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://www.hackerrank.com/challenges/quicksort1}
 * 
 */
public class quick_sort_no_swap_I {
    public static void printArray(PrintWriter out, int[] array) {
        for (int number : array) {
            out.print(number);
            out.print(" ");
        }
    }

    public static void partition(int[] array) {
        int n = array.length;

        if (n == 0) {
            return;
        }

        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> bigger = new ArrayList<Integer>();

        int pivot = array[0];
        for (int i = 1; i < n; ++i) {
            if (array[i] <= pivot) {
                smaller.add(array[i]);
            } else {
                bigger.add(array[i]);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (i < smaller.size()) {
                array[i] = smaller.get(i);
            } else if (i == smaller.size()) {
                array[i] = pivot;
            } else {
                array[i] = bigger.get(i - smaller.size() - 1);
            }
        }
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

        partition(array);
        printArray(out, array);

        in.close();
        out.close();
    }
}