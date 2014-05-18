public class manipulate_vmarea {
    public class Interval {
        public final int start;
        public final int end;

        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public class Node {
        public final Interval interval;
        public Node left, right;

        Node(Interval _interval) {
            interval = _interval;
        }
    }

    private Node root;

    public boolean insert(Interval newInterval) {
        if (root == null) {
            root = new Node(newInterval);
            return true;
        }

        Node c = root, last = null;
        while (c != null) {
            last = c;

            if (c.interval.start >= newInterval.end) {
                c = c.left;
            } else if (c.interval.end <= newInterval.start) {
                c = c.right;
            } else {
                return false;
            }
        }

        if (newInterval.start >= last.interval.end) {
            last.right = new Node(newInterval);
        } else {
            last.left = new Node(newInterval);
        }

        return true;
    }

    public Interval get(int pageNum) {
        Node c = root;

        while (c != null) {
            if (pageNum >= c.interval.start && pageNum < c.interval.end) {
                return c.interval;
            } else if (pageNum < c.interval.start) {
                c = c.left;
            } else {
                c = c.right;
            }
        }

        return null;
    }
}