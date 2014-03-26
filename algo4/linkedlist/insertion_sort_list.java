public class insertion_sort_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode c = psudoHead;

        while (c.next != null) {
            ListNode pre = psudoHead;

            while (pre.next != c.next && pre.next.val <= c.next.val) {
                pre = pre.next;
            }

            if (pre.next == c.next) {
                c = c.next;
            } else {
                ListNode temp = c.next.next;
                c.next.next = pre.next;
                pre.next = c.next;
                c.next = temp;
            }
        }

        return psudoHead.next;
    }
}