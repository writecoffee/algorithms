public class non_duplicated_intersections_of_two_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode intersect(ListNode l1, ListNode l2) {
        ListNode psudoHead = new ListNode(-1);
        ListNode i = l1;
        ListNode j = l2;
        ListNode k = psudoHead;
        
        while (i != null && j != null) {
            if (i.val == j.val) {
                while (i != null && i.val == j.val) {
                    i = i.next;
                }

                k.next = new ListNode(j.val);
                j = j.next;
                k = k.next;
            } else if (i.val > j.val) {
                j = j.next;
            } else {
                i = i.next;
            }
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
        intersect(toLinkedList(new int[] { 1, 2, 2, 3, 4 }),
                   toLinkedList(new int[] { 1, 2, 4, 4 }));
    }
 
}