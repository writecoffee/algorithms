package medium;

public class ll_reverse_nodes_in_k_group {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode cHead = psudoHead, cTail = head;

        for (int i = 0; i < k - 1 && cTail != null; ++i) {
            cTail = cTail.next;
        }

        while (cTail != null) {
            ListNode nxtTail = cTail.next;

            for (int i = 0; i < k - 1; ++i) {
                ListNode t = cTail.next;
                cTail.next = cHead.next;
                cHead.next = cHead.next.next;
                cTail.next.next = t;
            }

            cTail = nxtTail;
            cHead = cHead.next;
            for (int i = 0; i < k - 1 && cTail != null; ++i) {
                cTail = cTail.next;
                cHead = cHead.next;
            }
        }

        return psudoHead.next;
    }
}