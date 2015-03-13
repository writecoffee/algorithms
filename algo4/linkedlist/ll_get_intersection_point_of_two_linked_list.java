/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/intersection-of-two-linked-lists/}
 *
 */
public class ll_get_intersection_point_of_two_linked_list
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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        int m = getLength(headA), n = getLength(headB);
        ListNode aStart = headA, bStart = headB;

        int diff = m - n;
        if (diff > 0) {
            aStart = stepForward(headA, diff);
        } else if (diff < 0) {
            bStart = stepForward(headB, -diff);
        }

        while (aStart != null && aStart != bStart) {
            aStart = aStart.next;
            bStart = bStart.next;
        }

        return aStart;
    }

    private ListNode stepForward(ListNode head, int step)
    {
        for (int i = 0; i < step; ++i) {
            head = head.next;
        }

        return head;
    }

    private int getLength(ListNode head)
    {
        int n = 0;

        while (head != null) {
            n++;
            head = head.next;
        }

        return n;
    }
}