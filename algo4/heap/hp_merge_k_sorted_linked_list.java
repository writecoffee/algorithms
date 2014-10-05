import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/merge-k-sorted-lists/}
 *
 */
public class hp_merge_k_sorted_linked_list
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

    /**
     * Should discuss if the {@code lists} contains {@code null}, a.k.a empty list. This is
     * what the contract should specify.
     *
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists)
    {
        if (lists.size() == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b)
            {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.add(lists.get(i));
            }
        }

        ListNode psudoHead = new ListNode(-1), h = psudoHead;
        while (!pq.isEmpty()) {
            ListNode c = pq.poll();

            h.next = c;
            h = h.next;

            if (c.next != null) {
                pq.add(c.next);
            }
        }

        return psudoHead.next;
    }
}
