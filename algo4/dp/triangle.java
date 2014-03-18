import java.util.ArrayList;

public class triangle {
    public int minimumTotalInplace(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < i + 1; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                                       Math.min(triangle.get(i + 1).get(j),
                                                triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] dp = new int[triangle.size()];

        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}