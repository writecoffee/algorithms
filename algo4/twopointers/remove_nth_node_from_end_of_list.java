public class remove_nth_node_from_end_of_list {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prober = head;
        int i = 0;
        while (i != n) {
            prober = prober.next;
            i++;
        }

        if (prober == null) {
            return head.next;
        }

        ListNode result = head;
        while (prober.next != null) {
            prober = prober.next;
            result = result.next;
        }

        result.next = result.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}