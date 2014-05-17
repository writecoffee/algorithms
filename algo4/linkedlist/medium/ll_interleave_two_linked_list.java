package medium;

public class ll_interleave_two_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode interleave(ListNode l1, ListNode l2) {
        ListNode i = l1;
        ListNode j = l2;
        ListNode psudoHead = new ListNode(-1);
        ListNode k = psudoHead;

        while (i != null && j != null) {
            k.next = i;
            i = i.next;
            k.next.next = j;
            j = j.next;
            k = k.next.next;
        }

        if (i != null) {
            k.next = i;
        }

        if (j != null) {
            k.next = j;
        }

        return psudoHead.next;
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
        interleave(toLinkedList(new int[] { 1, 2, 3, 4 }),
                   toLinkedList(new int[] { 99, 100, 101, 102 }));
    }
}