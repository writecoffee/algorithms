import java.util.ArrayList;

public class place_windows {
    static class Rect {
        public Rect(int _x1, int _y1, int _x2, int _y2) {
            x1 = _x1;
            x2 = _x2;
            y1 = _y1;
            y2 = _y2;
        }

        int x1, y1, x2, y2;
    }

    public int minOverlapping(Rect[] rects, int W, int H, int w, int h) {
        if (rects.length == 0) {
            return 0;
        }

        ArrayList<Integer> x = new ArrayList<Integer>(), y = new ArrayList<Integer>();
        y.add(0);
        y.add(H - h);
        x.add(0);
        x.add(W - w);

        for (int i = 0; i < rects.length; ++i) {
            if (rects[i].x1 - w >= 0) {
                x.add(rects[i].x1 - w);
            }

            if (rects[i].y1 - h >= 0) {
                y.add(rects[i].y1 - h);
            }

            if (rects[i].x2 + w <= W) {
                x.add(rects[i].x2);
            }

            if (rects[i].y2 + h <= H) {
                y.add(rects[i].y2);
            }
        }

        int gMin = w * h;
        for (int i = 0; i < x.size(); ++i) {
            for (int j = 0; j < y.size(); ++j) {
                Rect r = new Rect(x.get(i), y.get(j), x.get(i) + w, y.get(j) + h);

                int tOverlap = 0;
                for (int k = 0; k < rects.length; ++k) {
                    tOverlap += getOverlappingArea(rects[k], r);
                }

                gMin = Math.min(gMin, tOverlap);
            }
        }

        return gMin;
    }

    private int getOverlappingArea(Rect a, Rect b) {
        int x = Math.max(0, Math.min(a.x2, b.x2) - Math.max(a.x1, b.x1));
        int y = Math.max(0, Math.min(a.y2, b.y2) - Math.max(a.y1, b.y1));
        return x * y;
    }
}