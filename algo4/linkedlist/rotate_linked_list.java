public class rotate_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode a = psudoHead, b = a;

        if (head == null) {
            return null;
        }

        int n = getLength(head);
        k %= n;

        for (int i = 0; i < n - k; ++i) {
            a = a.next;
        }

        while (a.next != null) {
            ListNode t = b.next;
            b.next = a.next;
            a.next = a.next.next;
            b = b.next;
            b.next = t;
        }

        return psudoHead.next;
    }

    private int getLength(ListNode t) {
        int result = 0;
        while (t != null) {
            t = t.next;
            result++;
        }

        return result;
    }
}