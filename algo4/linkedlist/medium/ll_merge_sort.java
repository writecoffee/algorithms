package medium;

public class ll_merge_sort {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode current = null;

    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * Quick sort's is O(n * n).
     * 
     * (1) Devise the recursive function: 
     *          sort(length):
     *              l = sort(half)
     *              r = sort(length - half)
     *              return merge(l, r)
     * 
     * (2) What sort returns should be an sorted and independent linked-list,
     *     that means it ends in "null".
     *     
     * (3) Merge should return the start of the sorted list.
     * 
     */
    public ListNode sortList(ListNode head) {
        current = head;
        return sort(getLength(head));
    }

    private ListNode sort(int length) {
        if (length == 0) {
            return null;
        } else if (length == 1) {
            ListNode t = current;
            current = current.next;
            t.next = null;
            return t;
        }

        int half = length / 2;
        ListNode l = sort(half);
        ListNode r = sort(length - half);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
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
        } else if (r != null) {
            c.next = r;
        }

        return psudoHead.next;
    }

    private int getLength(ListNode c) {
        int length = 0;

        while (c != null) {
            c = c.next;
            length++;
        }

        return length;
    }
}