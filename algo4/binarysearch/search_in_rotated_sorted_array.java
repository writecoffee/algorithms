/**
 * 
 *
 */
public class search_in_rotated_sorted_array
{
    public int search(int[] array, int target)
    {
        int n = array.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[l] <= array[mid]) {
                if (target >= array[l] && target < array[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > array[mid] && target <= array[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}