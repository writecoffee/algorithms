public class fold_linked_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode i = psudoHead;
        ListNode j = psudoHead;

        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }

        ListNode half = i;
        reverse(i);
        j = head;

        while (j != half && half.next != null) {
            ListNode temp = j.next;
            j.next = i.next;
            i.next = i.next.next;
            j.next.next = temp;
            j = j.next.next;
        }
    }

    public static void reverse(ListNode psudoHead) {
        if (psudoHead.next == null) {
            return;
        }

        ListNode c = psudoHead.next;
        while (c.next != null) {
            ListNode temp = psudoHead.next;
            psudoHead.next = c.next;
            c.next = c.next.next;
            psudoHead.next.next = temp;
        }
    }

    private static ListNode toLinkedList(int[] numbers) {
        ListNode psudoHead = new ListNode(-1);
        for (int i = numbers.length - 1; i >= 0; --i) {
            ListNode temp = psudoHead.next;
            psudoHead.next = new ListNode(numbers[i]);
            psudoHead.next.next = temp;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        reorderList(toLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
        reorderList(toLinkedList(new int[] { 1, 2 }));
        reorderList(toLinkedList(new int[] { 1, 2, 3, 4 }));
        reorderList(toLinkedList(new int[] { 1, 2, 3, 4, 5 }));
    }
}