/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 *
 * Can you solve it without using extra space?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/linked-list-cycle-ii/}
 * [Difficulty] - Hard
 *
 */
public class ll_linked_list_cycle_II
{
    class ListNode
    {
        int      val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    /**
     *              d
     * ----------------------------^
     *                           /   \       cycle diameter: r
     *                          |     |      meet-up point: x
     *                           \___/
     *
     * We have:
     *   (1) 2S = S + nr
     *   (2) d + x = S   => S = d + x
     *   (3) S = nr      => S = (n - 1) r + r
     *
     * Plug in (2) into (3), we get
     *
     *   d = (n - 1) r + (r - x)
     *
     *
     */
    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode i = head;
        ListNode j = head.next;

        while (true) {
            if (i == j) {
                break;
            }

            if (i.next == null || j.next == null || j.next.next == null) {
                return null;
            }

            i = i.next;
            j = j.next.next;
        }

        i = i.next;
        j = head;
        while (j != i) {
            i = i.next;
            j = j.next;
        }

        return i;
    }
}
