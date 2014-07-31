package gmax;

import java.util.HashMap;

/**
 * You have a stack of n boxes, with widths w, heights h, and depths d, The boxes cannot be rotated
 * and can only be stacked on top of one another if each box in the stack is strictly larger than
 * the box above it in width, height, and depth. Implement a method to build the tallest stack
 * possible, where the heigh t of a stack is the sum of the heights of each box.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-9.10}
 * 
 */
public class dp_stacking_boxes_3d {
    private static class Box {
        public final int l;
        public final int w;
        public final int h;

        Box(int _l, int _w, int _h) {
            l = _l;
            w = _w;
            h = _h;
        }
    }

    private static boolean canBeAbove(Box top, Box bottom) {
        return bottom != top && top.l < bottom.l && top.w < bottom.w;
    }

    private static BtInfo gMax;
    private static Box gBottom;
    private static HashMap<Box, BtInfo> h;

    private static class BtInfo {
        final int height;
        final Box top;

        BtInfo(int _height, Box _top) {
            height = _height;
            top = _top;
        }
    }

    public static int stackBoxes(Box[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        gMax = new BtInfo(-1, null);
        h = new HashMap<Box, BtInfo>();
        for (Box b : boxes) {
            explore(boxes, b);
        }

        return gMax.height;
    }

    private static BtInfo explore(Box[] boxes, Box c) {
        if (h.containsKey(c)) {
            return h.get(c);
        }

        Box tUpper = null;
        int tHeight = 0;

        for (Box b : boxes) {
            if (canBeAbove(b, c)) {
                BtInfo upperStack = explore(boxes, b);

                if (tHeight < upperStack.height) {
                    tUpper = b;
                    tHeight = upperStack.height;
                }
            }
        }

        BtInfo lMax = new BtInfo(tHeight + c.h, tUpper);
        h.put(c, lMax);

        if (gMax.height < lMax.height) {
            gBottom = c;
            gMax = lMax;
        }

        return lMax;
    }

    public static void printStack() {
        Box c = gBottom;

        while (c != null) {
            System.out.println(c.l + " " + c.w);
            c = h.get(c).top;
        }

        System.out.println("height: " + h.get(gBottom).height);
    }

    public static Box[] generateBoxes(int[][] rep) {
        Box[] boxes = new Box[rep.length];
        for (int i = 0; i < rep.length; i++) {
            boxes[i] = new Box(rep[i][0], rep[i][1], rep[i][2]);
        }

        return boxes;
    }

    public static void testCase1() {
        stackBoxes(generateBoxes(new int[][] { { 27, 9, 3 } }));
        printStack();
    }

    public static void testCase2() {
        stackBoxes(generateBoxes(new int[][] { { 27, 9, 3 }, { 29, 12, 7 }, { 29, 27, 22 }, { 9, 3, 5 } }));
        printStack();
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }
}