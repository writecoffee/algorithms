import java.util.Arrays;
import java.util.Comparator;

public class dp_stacking_boxes {
    public class Box {
        public final int vol;
        public final int weight;

        Box(int _h, int _w) {
            vol = _h;
            weight = _w;
        }
    }

    public int maxBoxes(Box[] boxes) {
        int n = boxes.length;

        if (n == 0) {
            return 0;
        }

        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box a, Box b) {
                return a.vol - b.vol;
            }
        });

        int[] dp = new int[n];
        int gMax = 1;

        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; --j) {
                if (boxes[i].vol > boxes[j].vol && boxes[i].weight > boxes[j].weight) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            gMax = Math.max(gMax, dp[i]);
        }

        return gMax;
    }
}