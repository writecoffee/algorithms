public class sort_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode _head;
    public static ListNode sortList(ListNode head) {
        _head = head;
        return sortHelper(getLength(head));
    }

    private static ListNode sortHelper(int length) {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            ListNode current = _head;
            _head = _head.next;
            current.next = null;
            return current;
        }

        int half = length / 2;
        ListNode head1 = sortHelper(half);
        ListNode head2 = sortHelper(length - half);
        return mergeList(head1, head2);
    }

    private static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode psudoHead = new ListNode(0);
        psudoHead.next = null;
        ListNode current = psudoHead;

        while (head1 != null && head2 != null) {
            ListNode minNode;
            if (head1.val < head2.val) {
                minNode = head1;
                head1 = head1.next;
            } else {
                minNode = head2;
                head2 = head2.next;
            }

            current.next = minNode;
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else if (head2 != null) {
            current.next = head2;
        }

        return psudoHead.next;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
