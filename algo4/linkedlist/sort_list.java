public class sort_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode current = null;

    public ListNode sort(ListNode head) {
        current = head;
        int length = getLength(head);
        return mergeHelper(length);
    }

    public ListNode mergeHelper(int length) {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            ListNode t = current;
            current = current.next;
            t.next = null;
            return t;
        }

        int half = length / 2;
        ListNode l = mergeHelper(half);
        ListNode r = mergeHelper(length - half);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode psudoHead = new ListNode(-1);
        ListNode c = psudoHead;

        while (l != null && r != null) {
            if (l.val < r.val) {
                c.next = l;
                l = l.next;
            } else {
                c.next = r;
                r = r.next;
            }
            c = c.next;
        }

        if (l != null) {
            c.next = l;
        }

        if (r != null) {
            c.next = r;
        }

        return psudoHead.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }
}
