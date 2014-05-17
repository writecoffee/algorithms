package basic;

public class ll_remove_nth_node_from_end {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;

        ListNode prober = psudoHead;
        for (int i = 0; i < n; ++i) {
            prober = prober.next;
        }

        ListNode target = psudoHead;
        while (prober.next != null) {
            target = target.next;
            prober = prober.next;
        }

        target.next = target.next.next;
        return psudoHead.next;
    }
}