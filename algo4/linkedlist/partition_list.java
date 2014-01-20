public class partition_list {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode current = psudoHead;
        ListNode insertPoint = psudoHead;

        while (current.next != null) {
            if (current.next.val >= x) {
                current = current.next;
            } else {
                if (current == insertPoint) {
                    current = current.next;
                    insertPoint = insertPoint.next;
                } else {
                    ListNode move = current.next;
                    current.next = move.next;
                    move.next = insertPoint.next;
                    insertPoint.next = move;
                    insertPoint = move;
                }
            }
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {

    }
}