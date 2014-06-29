package basic;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/merge-two-sorted-lists/}
 * 
 */
public class ll_merge_two_sorted_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2, psudoHead = new ListNode(-1), c = psudoHead;

        while (i != null && j != null) {
            if (i.val > j.val) {
                c.next = j;
                j = j.next;
            } else {
                c.next = i;
                i = i.next;
            }

            c = c.next;
        }

        if (i != null) {
            c.next = i;
        } else if (j != null) {
            c.next = j;
        }

        return psudoHead.next;
    }
}