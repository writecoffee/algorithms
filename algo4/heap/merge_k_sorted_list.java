import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class merge_k_sorted_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Should discuss if the {@code lists} contains {@code null}, a.k.a empty list. This is
     * what the contract should specify.
     * 
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int n = lists.size();
        if (n == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(n * 10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < n; ++i) {
            if (lists.get(i) != null) {
                pq.add(lists.get(i));
            }
        }

        ListNode psudoHead = new ListNode(-1);
        ListNode c = psudoHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            c.next = minNode;
            c = minNode;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return psudoHead.next;
    }
}