public class merge_two_sorted_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode merge(ListNode l1, ListNode l2) {
        ListNode psudoHead = new ListNode(-1);
        ListNode i = l1;
        ListNode j = l2;
        ListNode k = psudoHead;

        while (i != null && j != null) {
            if (i.val > j.val) {
                k.next = j;
                j = j.next;
            } else {
                k.next = i;
                i = i.next;
            }

            k = k.next;
        }

        if (i != null) {
            k.next = i;
        }

        if (j != null) {
            k.next = j;
        }

        return psudoHead.next;
    }

    private static boolean assertSorted(ListNode head) {
        ListNode current = head;

        if (head == null) {
            return true;
        }

        while (current.next != null) {
            if (current.val > current.next.val) {
                return false;
            }

            current = current.next;
        }

        return true;
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
        assert assertSorted(merge(toLinkedList(new int[] { 1, 4, 5, 9 }),
                                  toLinkedList(new int[] { 2, 3, 7, 8 })));
        assert assertSorted(merge(toLinkedList(new int[] { 1, 1, 1, 1 }),
                                  toLinkedList(new int[] { 1, 1, 1, 1 })));
    }
}