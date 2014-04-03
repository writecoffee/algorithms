import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class stacking_boxes {
    public static class Box {
        public final int vol;
        public final int weight;

        Box(int _h, int _w) {
            vol = _h;
            weight = _w;
        }
    }

    static boolean canBeAbove(Box top, Box bottom) {
        return bottom != top && top.vol < bottom.vol && top.weight < bottom.weight;
    }

    static BtInfo gMax;
    static Box gOptBox;
    static HashMap<Box, BtInfo> stackMap;

    private static class BtInfo {
        final int depth;
        final Box top;

        BtInfo(int _depth, Box _top) {
            depth = _depth;
            top = _top;
        }
    }

    static int maxBoxesBacktracking(Box[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        gMax = new BtInfo(-1, null);
        stackMap = new HashMap<Box, BtInfo>();
        for (Box b : boxes) {
            explore(boxes, b);
        }

        return gMax.depth;
    }

    static BtInfo explore(Box[] boxes, Box bottom) {
        if (stackMap.containsKey(bottom)) {
            return stackMap.get(bottom);
        }

        Box lOptTop = null;
        int lOptDepth = 0;
        for (Box b : boxes) {
            if (canBeAbove(b, bottom)) {
                BtInfo upperStack = explore(boxes, b);
                lOptTop = lOptDepth < upperStack.depth ? b : lOptTop;
                lOptDepth = lOptDepth < upperStack.depth ? upperStack.depth : lOptDepth;
            }
        }

        BtInfo lMax = new BtInfo(lOptDepth + 1, lOptTop);
        stackMap.put(bottom, lMax);
        gOptBox = lMax.depth > gMax.depth ? bottom : gOptBox;
        gMax = lMax.depth > gMax.depth ? lMax : gMax;
        return lMax;
    }

    static int maxBoxes(Box[] boxes) {
        int n = boxes.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box l, Box r) {
                if (l.vol == r.vol) {
                    return l.weight - r.weight;
                }

                return l.vol - r.vol;
            }
        });

        int[] dp = new int[n];
        int gMax = 1;
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (boxes[i].vol > boxes[j].vol && boxes[i].weight > boxes[j].weight) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            gMax = Math.max(gMax, dp[i]);
        }

        return gMax;
    }

    public static void printStack() {
        Box c = gOptBox;
        while (c != null) {
            System.out.println(c.vol + " " + c.weight);
            c = stackMap.get(c).top;
        }
    }

    public static Box[] generateBoxes(int[][] rep) {
        Box[] boxes = new Box[rep.length];
        for (int i = 0; i < rep.length; i++) {
            boxes[i] = new Box(rep[i][0], rep[i][1]);
        }

        return boxes;
    }

    public static void main(String[] args) {
        maxBoxesBacktracking(generateBoxes(new int[][] { { 27, 9 }, { 29, 12 }, { 29, 27 }, { 9, 3 } }));
        printStack();
    }
}