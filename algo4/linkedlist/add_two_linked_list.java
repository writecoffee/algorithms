public class add_two_linked_list
{
    public static class ListNode
    {
        int      val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        ListNode result = new ListNode(-1);
        ListNode current = result;
        int c = 0;

        while (l1Curr != null && l2Curr != null) {
            int value = (l1Curr.val + l2Curr.val + c) % 10;
            c = (l1Curr.val + l2Curr.val + c) / 10;
            current.next = new ListNode(value);
            l1Curr = l1Curr.next;
            l2Curr = l2Curr.next;
            current = current.next;
        }

        while (l1Curr != null) {
            int value = (l1Curr.val + c) % 10;
            c = (l1Curr.val + c) / 10;
            current.next = new ListNode(value);
            l1Curr = l1Curr.next;
            current = current.next;
        }

        while (l2Curr != null) {
            int value = (l2Curr.val + c) % 10;
            c = (l2Curr.val + c) / 10;
            current.next = new ListNode(value);
            l2Curr = l2Curr.next;
            current = current.next;
        }

        if (c != 0) {
            current.next = new ListNode(1);
        }

        return result.next;
    }
}
