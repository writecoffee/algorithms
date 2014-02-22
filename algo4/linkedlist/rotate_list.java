public class rotate_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int n) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode probe = psudoHead;
        ListNode stitchPoint = psudoHead;

        if (head == null) {
            return null;
        }

        for (int j = 0; j < n; j++) {
            probe = probe.next;

            if (probe == null) {
                probe = head;
                n -= j;
                j = 0;
            }
        }

        ListNode knot = psudoHead;
        while (probe != null && probe.next != null) {
            probe = probe.next;
            knot = knot.next;
        }

        if (knot == psudoHead) {
            return head;
        }

        for (int i = 0; i < n; i++) {
            ListNode temp = stitchPoint.next;
            stitchPoint.next = knot.next;
            knot.next = knot.next.next;
            stitchPoint.next.next = temp;
            stitchPoint = stitchPoint.next;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;

        rotateRight(n1, 5);
    }
}