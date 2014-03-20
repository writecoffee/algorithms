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
        Comparator<ListNode> comp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), comp);
        for (int i = 0; i < lists.size(); i++) {
            q.add(lists.get(i));
        }

        ListNode psudoHead = new ListNode(-1);
        ListNode curr = psudoHead;
        while (!q.isEmpty()) {
            ListNode minNode = q.poll();

            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                q.add(minNode.next);
            }
        }

        return psudoHead.next;
    }

    private static ListNode toLinkedList(int[] numbers) {
        ListNode psudoHead = new ListNode(-1);
        for (int i = numbers.length - 1; i >= 0; --i) {
            ListNode temp = psudoHead.next;
            psudoHead.next = new ListNode(numbers[i]);
            psudoHead.next.next = temp;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = toLinkedList(new int[] { 1, 2, 2, 3, 4 });
        ListNode l2 = toLinkedList(new int[] { 1, 2 });
        ListNode l3 = toLinkedList(new int[] { 6, 9 });

        ArrayList<ListNode> myList = new ArrayList<ListNode>();
        myList.add(l1);
        myList.add(l2);
        myList.add(l3);
        
        mergeKLists(myList);
    }
}