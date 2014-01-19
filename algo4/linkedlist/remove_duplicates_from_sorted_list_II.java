public class remove_duplicates_from_sorted_list_II {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode psudoHead = new ListNode(-1); 
        psudoHead.next = head;
        ListNode current = psudoHead;
        while (current != null && current.next != null && current.next.next != null) {
            if (current.next.val != current.next.next.val) {
                current = current.next;
                continue;
            }

            ListNode probe = current.next;
            while (probe != null && probe.next != null && probe.val == probe.next.val) {
                probe = probe.next;
            }

            current.next = probe.next;
        }

        return psudoHead.next;
    }
}
