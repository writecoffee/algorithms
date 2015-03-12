import java.util.ArrayList;

/**
 * On a W * H screen, the upper left corner is of coordinate (0, 0), the bottom
 * right corner is of coordinate (W, H). There are N windows in the screen which
 * we can consider them as "Box". You are required to place these N windows on
 * the screen such that the overall overlapping area is minimal.
 *
 * [Difficulty] - Hard
 * [Source]     - imo.im interview, itint5 - 47
 * [Tag]        - $greedy$, $geometry$
 *
 */
public class place_windows
{
    private class Rect
    {
        public Rect(int _x1, int _y1, int _x2, int _y2)
        {
            x1 = _x1;
            x2 = _x2;
            y1 = _y1;
            y2 = _y2;
        }

        int x1, y1, x2, y2;
    }

    public int minOverlapping(Rect[] rects, int W, int H, int w, int h)
    {
        if (rects.length == 0) {
            return 0;
        }

        ArrayList<Integer> x = new ArrayList<Integer>(), y = new ArrayList<Integer>();
        x.add(0);
        x.add(H - h);
        y.add(0);
        y.add(W - w);

        for (int i = 0; i < rects.length; ++i) {
            if (rects[i].x1 - h >= 0) {
                x.add(rects[i].x1 - h);
            }

            if (rects[i].y1 - w >= 0) {
                y.add(rects[i].y1 - w);
            }

            if (rects[i].x2 + h <= H) {
                x.add(rects[i].x2);
            }

            if (rects[i].y2 + w <= W) {
                y.add(rects[i].y2);
            }
        }

        int gMin = w * h;
        for (int i = 0; i < x.size(); ++i) {
            for (int j = 0; j < y.size(); ++j) {
                Rect t = new Rect(x.get(i), y.get(j), x.get(i) + h, y.get(j) + w);

                int overlap = 0;
                for (Rect rect : rects) {
                    overlap += calculateOverlappingRegion(rect, t);
                }

                gMin = Math.min(overlap, gMin);
            }
        }

        return gMin;
    }

    private int calculateOverlappingRegion(Rect a, Rect b)
    {
        int x = Math.max(0, Math.min(a.x2, b.x2) - Math.max(a.x1, b.x1));
        int y = Math.max(0, Math.min(a.y2, b.y2) - Math.max(a.y1, b.y1));
        return x * y;
    }
}