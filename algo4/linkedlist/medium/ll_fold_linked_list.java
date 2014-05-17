package medium;

/**
 * Given a singly linked list L: L0→L1→...→Ln-1→Ln,
 * 
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * http://oj.leetcode.com/problems/reorder-list/
 * 
 */
public class ll_fold_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode mid = psudoHead, j = psudoHead, i = head;

        while (j != null && j.next != null) {
            mid = mid.next;
            j = j.next.next;
        }

        reverse(mid);

        while (i != mid) {
            ListNode t = i.next;
            i.next = mid.next;
            mid.next = mid.next.next;
            i.next.next = t;
            i = i.next.next;
        }
    }

    private void reverse(ListNode psudoHead) {
        if (psudoHead.next == null) {
            return;
        }

        ListNode i = psudoHead.next;

        while (i.next != null) {
            ListNode t = psudoHead.next;
            psudoHead.next = i.next;
            i.next = i.next.next;
            psudoHead.next.next = t;
        }
    }
}