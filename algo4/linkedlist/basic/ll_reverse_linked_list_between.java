package basic;

public class ll_reverse_linked_list_between {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * 
     * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     * 
     * return 1->4->3->2->5->NULL.
     * 
     * Note:
     * 
     * Given m, n satisfy the following condition:
     * 
     * 1 ≤ m ≤ n ≤ length of list.
     * 
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode psudoHead = new ListNode(-1), start = psudoHead;
        psudoHead.next = head;

        for (int i = 1; i < m; ++i) {
            start = start.next;
        }

        ListNode c = start.next;
        for (int i = 0; i < n - m; ++i) {
            ListNode t1 = c.next.next, t2 = start.next;
            start.next = c.next;
            start.next.next = t2;
            c.next = t1;
        }

        return psudoHead.next;
    }
}