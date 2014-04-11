import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class merge_k_sorted_linked_list {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < lists.size(); i++) {
            pq.add(lists.get(i));
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