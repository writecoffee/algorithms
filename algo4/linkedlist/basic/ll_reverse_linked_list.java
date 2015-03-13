package basic;

/**
 * Reverse a singly linked list.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/reverse-linked-list/}
 *
 */
public class ll_reverse_linked_list
{
    public class ListNode
    {
        int      val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head)
    {
        ListNode ph = new ListNode(-1),
                 c = head;

        ph.next = head;

        if (c == null) {
            return null;
        }

        while (c.next != null) {
            ListNode t = ph.next;
            ph.next = c.next;
            c.next = c.next.next;
            ph.next.next = t;
        }

        return ph.next;
    }
}
