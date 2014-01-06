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
     * Should discuss if the {@code lists} contains {@code null} element. This is
     * what the contract should specify.
     * 
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int listsCount = lists.size();
        if (listsCount == 0) {
            return null;
        }
        if (listsCount == 1) {
            return lists.get(0);
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(listsCount * 10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        
        ListNode pivotNode = new ListNode(-1);
        ListNode psudoHead = pivotNode;
        
        for (int i = 0; i < listsCount; ++i) {
            if (lists.get(i) != null) {
                queue.add(lists.get(i));
            }
        }
        
        while (!queue.isEmpty()) {
            ListNode nextSmallestNode = queue.poll();
            pivotNode.next = nextSmallestNode;
            pivotNode = nextSmallestNode;

            if (nextSmallestNode.next != null) {
                queue.add(nextSmallestNode.next);
            }
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {

    }
}