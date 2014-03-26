public class linked_list_cycle_II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode i = head;
        ListNode j = head.next;

        while (true) {
            if (i == j) {
                break;
            }

            if (i.next == null || j.next == null || j.next.next == null) {
                return null;
            }

            i = i.next;
            j = j.next.next;
        }

        i = i.next;
        j = head;
        while (j != i) {
            i = i.next;
            j = j.next;
        }

        return i;
    }
}