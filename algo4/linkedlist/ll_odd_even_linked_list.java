
/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 *
 * Example:
 *
 * Given 1->2->3->4->5->NULL,
 *
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it
 * was in the input.
 *
 * The first node is considered odd, the second node even and so on ...
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/odd-even-linked-list/}
 *
 */
public class ll_odd_even_linked_list
{
    public class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head)
    {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode i = head;
        ListNode j = head.next;

        while (j != null && j.next != null) {
            ListNode nextOdd = j.next;
            ListNode t = i.next;
            ListNode rest = nextOdd.next;

            i.next = nextOdd;
            i.next.next = t;
            j.next = rest;

            i = i.next;
            j = j.next;
        }

        return head;
    }
}
