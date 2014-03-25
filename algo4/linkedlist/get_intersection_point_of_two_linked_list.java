import java.util.HashMap;

public class get_intersection_point_of_two_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        assert head1 != null && head2 != null;

        int m = getLength(head1);
        int n = getLength(head2);
        ListNode i = head1;
        ListNode j = head2;

        if (m > n) {
            int k = m - n;
            while (k > 0) {
                i = i.next;
                k--;
            }
        } else if (n > m) {
            int k = n - m;
            while (k > 0) {
                j = j.next;
                k--;
            }
        }

        while (i != null && i != j) {
            i = i.next;
            j = j.next;
        }

        return i;
    }

    private static int getLength(ListNode head) {
        int result = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            result++;
        }

        return result;
    }

    private static ListNode toLinkedList(int[] numbers, HashMap<Integer, ListNode> created) {
        ListNode psudoHead = new ListNode(-1);
        for (int i = numbers.length - 1; i >= 0; --i) {
            ListNode temp = psudoHead.next;
            if (created.containsKey(numbers[i])) {
                psudoHead.next = created.get(numbers[i]);
            } else {
                psudoHead.next = new ListNode(numbers[i]);
                created.put(numbers[i], psudoHead.next);
            }
            psudoHead.next.next = temp;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        HashMap<Integer, ListNode> created = new HashMap<Integer, ListNode>();
        int[] a = new int[] { 3, 6, 9, 15, 30 };
        int[] b = new int[] { 10, 15, 30 };
        findIntersection(toLinkedList(a, created), toLinkedList(b, created));
    }
}