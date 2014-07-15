package gmax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/**
 * Box Towers
 * 
 * In the not so distant future, Box has commissioned you to design the new Box Worldwide
 * Headquarters - The Box Towers. The design principal is a series of boxes (what else?), one on top
 * of each other. Each department in Box will be located in a different box.
 * 
 * Now each department has decided they have different needs in terms of the height, width and
 * length (depth) of their box. For structural integrity reasons, you must also not place a box that
 * has a larger footprint on top of a box with a smaller footprint i.e a box can be kept on the top
 * of another box only if the Length of the upper box is not more than the Length of box below and
 * the same for Width. You may rotate the boxes as necessary to make any of the face as base i.e 3D
 * rotation is allowed.
 * 
 * Given the set of boxes, come up with the tallest building possible while satisfying the above
 * constraints. It may not be possible to use all the boxes.
 * 
 * Input Format:
 * 
 * 1st line contains the number of boxes , N.
 * 
 * Then follow N lines describing the configuration of each of the N boxes. Each of these lines
 * contain three integers (length, width and height of the box)
 * 
 * Output Format:
 * 
 * Output a single line which is the height of the tallest possible building that can be formed with
 * some of the boxes given and satisfying the constraints.
 * 
 * Sample Input
 * 
 *    3
 *    5 2 4
 *    1 4 2
 *    4 4 2
 * 
 * Sample Output
 * 
 *    13
 * 
 * Explanation
 * 
 * Place box 2 on top below which is box 1 and the bottom-most box is box 3. Box 2 is placed with
 * base ( 1 2 ) and height 4 , box 1 is placed with base ( 2 4 ) and height 5, and box 3 is placed
 * with base ( 2 4 ) and height 4. So total height of this tower is 13.
 * 
 * Constraints:
 * 
 * N, the number of boxes is not more than 20
 * 
 * For any box , 1 <= Length,Width,Height <= 100
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://box.interviewstreet.com/challenges/dashboard/#problem/4f3c491b4a54c}
 *
 */
public class dp_stacking_boxes_3d_rotatable {
    private static class BoxRotatable {
        private final int[] edges;

        private BoxRotatable(int _l, int _w, int _h) {
            edges = new int[] { _l, _w, _h };
        }

        public Iterator<Box> iterator() {
            return new BoxIterator(edges);
        }

        private class Box implements Comparable<Box> {
            public final int l, w, h;

            private Box(int _l, int _w, int _h) {
                l = _l;
                w = _w;
                h = _h;
            }

            @Override
            public int compareTo(Box o) {
                return l - o.l;
            }
        }

        private class BoxIterator implements Iterator<Box> {
            private Stack<Box> permutation = new Stack<Box>();

            private BoxIterator(int[] edges) {
                explore(edges, edges.length, new Stack<Integer>());
            }

            private void explore(int[] edges, int n, Stack<Integer> path) {
                if (path.size() == n) {
                    permutation.push(new Box(edges[path.get(0)], edges[path.get(1)], edges[path
                                    .get(2)]));
                    return;
                }

                for (int j = 0; j < n; ++j) {
                    if (!path.contains(j)) {
                        path.push(j);
                        explore(edges, n, path);
                        path.pop();
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return !permutation.isEmpty();
            }

            @Override
            public Box next() {
                return permutation.pop();
            }

            @Override
            public void remove() {
            }
        }
    }

    private static int gMax = 0;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        BoxRotatable[] boxes = new BoxRotatable[n];

        for (int i = 0; i < n; ++i) {
            String[] splits = in.readLine().split("\\s+");
            boxes[i] = new BoxRotatable(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]), Integer.parseInt(splits[2]));
        }

        explore(boxes, 0, n, new Stack<BoxRotatable.Box>());

        in.close();
        System.out.println(gMax);
    }

    private static void explore(BoxRotatable[] boxes, int i, int n, Stack<BoxRotatable.Box> path) {
        if (i == n) {
            computeMax(path.toArray(new BoxRotatable.Box[n]), n);
            return;
        }

        Iterator<BoxRotatable.Box> it = boxes[i].iterator();
        while (it.hasNext()) {
            path.push(it.next());
            explore(boxes, i + 1, n, path);
            path.pop();
        }
    }

    private static void computeMax(BoxRotatable.Box[] boxes, int n) {
        Arrays.sort(boxes);
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (boxes[j].w <= boxes[i].w) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i] += boxes[i].h;
            gMax = Math.max(dp[i], gMax);
        }
    }
}