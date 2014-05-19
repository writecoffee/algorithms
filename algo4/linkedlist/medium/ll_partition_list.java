package medium;

public class ll_partition_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before
     * nodes greater than or equal to x.
     * 
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * 
     * For example,
     * 
     * Given 1->4->3->2->5->2 and x = 3,
     * 
     * return 1->2->2->4->3->5.
     * 
     */
    public ListNode partition(ListNode head, int x) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode i = psudoHead, j = psudoHead;

        while (j.next != null) {
            if (j.next.val < x && i != j) {
                ListNode t = i.next;
                i.next = j.next;
                j.next = j.next.next;
                i.next.next = t;
                i = i.next;
            } else if (j.next.val < x) {
                j = j.next;
                i = i.next;
            } else {
                j = j.next;
            }
        }

        return psudoHead.next;
    }
}