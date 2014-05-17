package medium;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only
 * nodes itself can be changed.
 * 
 * http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 */
public class ll_swap_nodes_in_pairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;

        ListNode p = psudoHead, q = head;

        while (q != null && q.next != null) {
            ListNode t = p.next;
            p.next = q.next;
            q.next = q.next.next;
            p.next.next = t;
            p = p.next.next;
            q = q.next;
        }

        return psudoHead.next;
    }
}