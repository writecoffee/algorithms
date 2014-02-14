public class reverse_linked_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;

        while (tail != psudoHead.next) {
            ListNode temp = psudoHead.next;
            psudoHead.next = head.next;
            head.next = head.next.next;
            psudoHead.next.next = temp;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverse(n1);
    }
}