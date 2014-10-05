/**
 * Given an integer array, heapify it into a min-heap array.
 *
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1]
 * is the left child of A[i] and A[i * 2 + 2] is the right child of A[i]. Have
 * you met this question in a real interview? Yes
 *
 * Example
 *
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 *
 * Challenge
 *
 * O(n) time complexity
 *
 * Clarification
 *
 * What is heap?
 *
 * Heap is a data structure, which usually have three methods: push, pop and
 * top. where "push" add a new element the heap, "pop" delete the
 * minimum/maximum element in the heap, "top" return the minimum/maximum
 * element.
 *
 * What is heapify?
 *
 * Convert an unordered integer array into a heap array. If it is min-heap, for
 * each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 *
 * What if there is a lot of solutions?
 *
 * Return any of them.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/heapify/}
 * [Difficulty] - Medium
 *
 */
public class bd_heapify
{
    public void heapify(int[] data)
    {
        int n = data.length;

        for (int i = n / 2; i >= 0; i--) {
            shifDown(data, i, n);
        }
    }

    private void shifDown(int[] data, int k, int n)
    {
        while (k < n) {
            int smallest = k, lchild = k * 2 + 1, rchild = k * 2 + 2;

            if (lchild < n && data[lchild] < data[smallest]) {
                smallest = lchild;
            }

            if (rchild < n && data[rchild] < data[smallest]) {
                smallest = rchild;
            }

            if (smallest == k) {
                break;
            }

            swap(data, k, smallest);
            k = smallest;
        }
    }

    private void swap(int[] data, int k, int smallest)
    {
        int t = data[k];
        data[k] = data[smallest];
        data[smallest] = t;
    }
}