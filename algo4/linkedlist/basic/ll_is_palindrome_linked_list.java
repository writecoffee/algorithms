package basic;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/palindrome-linked-list/}
 * [Difficulty] - Medium
 *
 */
public class ll_is_palindrome_linked_list
{
    public class ListNode
    {
        int      val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head)
    {
        ListNode ph = new ListNode(-1);
        ph.next = head;
        int n = getLength(head), mid = (n % 2 == 0) ? n / 2 : (n / 2 + 1);

        if (n == 1 || n == 0) {
            return true;
        }

        for (int i = 0; i < mid; ++i) {
            ph = ph.next;
        }

        ListNode ppp = ph.next;
        while (ppp.next != null) {
            ListNode t = ph.next;
            ph.next = ppp.next;
            ppp.next = ppp.next.next;
            ph.next.next = t;
        }

        ListNode c1 = ph.next, c2 = head;
        while (c1 != null) {
            if (c1.val != c2.val) {
                return false;
            }

            c1 = c1.next;
            c2 = c2.next;
        }

        return true;
    }

    private int getLength(ListNode head)
    {
        ListNode c = head;
        int i = 0;

        while (c != null) {
            i++;
            c = c.next;
        }

        return i;
    }
}
