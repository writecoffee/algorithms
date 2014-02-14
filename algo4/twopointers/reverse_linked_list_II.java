public class reverse_linked_list_II {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode psudoHead = new ListNode(0);
        psudoHead.next = head;

        ListNode prev = psudoHead;
        ListNode curr = head;
        int pos = 1;

        while (pos < m && curr != null) {
            prev = curr;
            curr = curr.next;
            ++pos;
        }

        while (pos < n && curr != null) {
            ListNode nt = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = nt;
            ++pos;
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

        reverseBetween(n1, 2, 4);
    }
}