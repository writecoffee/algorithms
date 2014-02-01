public class container_with_most_water {

    public static int maxArea(int[] height) {
        int len = height.length, low = 0, high = len - 1;
        int maxArea = 0;

        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 4, 5, 9, 2, 6 }));
    }
}