public class quick_sort_linked_list {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode sortList(ListNode head) {
        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        partition(psudoHead, null);
        return psudoHead.next;
    }

    public static void partition(ListNode psudoHead, ListNode end) {
        if (psudoHead.next == end || psudoHead.next.next == end) {
            return;
        }

        ListNode pivot = psudoHead.next;
        ListNode bigger = pivot;
        ListNode smaller = psudoHead;

        while (bigger.next != end) {
            if (bigger.next.val > pivot.val) {
                while (bigger.next != end && bigger.next.val > pivot.val) {
                    bigger = bigger.next;
                }

                while (bigger.next != end && bigger.next.val <= pivot.val) {
                    ListNode temp = smaller.next.next;
                    smaller.next.next = bigger.next;
                    bigger.next = bigger.next.next;
                    smaller.next.next.next = temp;
                    smaller = smaller.next;
                }
            } else {
                smaller = smaller.next;
                bigger = bigger.next;
            }
        }

        if (pivot != smaller.next) {
            psudoHead.next = pivot.next;
            ListNode temp = smaller.next.next;
            smaller.next.next = pivot;
            pivot.next = temp;
        }

        assert assertSmallerEquals(psudoHead.next, pivot, pivot.val);
        assert assertBigger(pivot.next, end, pivot.val);

        partition(psudoHead, pivot);
        partition(pivot, end);
    }

    private static boolean assertBigger(ListNode head, ListNode end, int val) {
        ListNode current = head;

        if (head == end) {
            return true;
        }

        while (current.next != end) {
            if (current.val <= val) {
                return false;
            }

            current = current.next;
        }
        
        return true;
    }

    private static boolean assertSmallerEquals(ListNode head, ListNode end, int val) {
        ListNode current = head;

        if (head == end) {
            return true;
        }

        while (current.next != end) {
            if (current.val > val) {
                return false;
            }

            current = current.next;
        }
        
        return true;
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
        assert assertSorted(sortList(toLinkedList(new int[] { 4, 2, 3, 4, 5, 7, 8, 2, 3, 4, 7 })));
        assert assertSorted(sortList(toLinkedList(new int[] { 1, 2, 3, 4 })));
        assert assertSorted(sortList(toLinkedList(new int[] { 4, 3, 2, 1 })));
    }
}
