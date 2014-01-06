
public class add_two_numbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumbers(l1, l2, 0);
    }

    public ListNode addNumbers(ListNode l1, ListNode l2, int carry) {
        ListNode result;
        int intermediateResult, c;

        if (l1 == null && l2 == null) {
            if (carry == 0) {
                return null;
            } else {
                result = new ListNode(1);
                return result;
            }
        }

        if (l1 == null) {
            intermediateResult = l2.val + carry;
            if (intermediateResult > 9) {
                intermediateResult -= 10;
                c = 1;
            } else {
                c = 0;
            }

            result = new ListNode(intermediateResult);
            result.next = addNumbers(null, l2.next, c);
        } else if (l2 == null) {
            intermediateResult = l1.val + carry;
            if (intermediateResult > 9) {
                intermediateResult -= 10;
                c = 1;
            } else {
                c = 0;
            }

            result = new ListNode(intermediateResult);
            result.next = addNumbers(l1.next, null, c);
        } else {
            intermediateResult = l1.val + l2.val + carry;
            if (intermediateResult > 9) {
                intermediateResult -= 10;
                c = 1;
            } else {
                c = 0;
            }

            result = new ListNode(intermediateResult);
            result.next = addNumbers(l1.next, l2.next, c);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
