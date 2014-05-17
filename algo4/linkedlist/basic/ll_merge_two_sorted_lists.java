package basic;

public class ll_merge_two_sorted_lists {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode psudoHead = new ListNode(-1);
        ListNode c = psudoHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                c.next = l1;
                c = c.next;
                l1 = l1.next;
            } else {
                c.next = l2;
                c = c.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            c.next = l2;
        } else {
            c.next = l1;
        }

        return psudoHead.next;
    }
}
