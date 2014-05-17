package basic;

public class ll_reverse_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * The optimal solution requires one pass.
     * 
     */
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode c = head.next;

        while (c.next != null) {
            ListNode t1 = c.next.next, t2 = psudoHead.next;
            psudoHead.next = c.next;
            psudoHead.next.next = t2;
            c.next = t1;
        }

        return psudoHead.next;
    }
}