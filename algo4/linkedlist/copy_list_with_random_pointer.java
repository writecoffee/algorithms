import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class copy_list_with_random_pointer {
    class ListNode {
        int label;
        ListNode next, random;

        ListNode(int x) {
            this.label = x;
        }

        ListNode() {
        }
    };

    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, ListNode> visited = new HashMap<Integer, ListNode>();
        Queue<ListNode> q = new LinkedList<ListNode>();
        q.add(head);
        ListNode headCloned = new ListNode(head.label);
        visited.put(head.label, headCloned);

        while (!q.isEmpty()) {
            ListNode c = q.poll();
            ListNode cCloned = visited.get(c.label);

            if (c.next != null) {
                if (visited.containsKey(c.next.label)) {
                    cCloned.next = visited.get(c.next.label);
                } else {
                    ListNode nextCloned = new ListNode(c.next.label);
                    cCloned.next = nextCloned;
                    q.add(c.next);
                    visited.put(c.next.label, nextCloned);
                }
            }

            if (c.random != null) {
                if (visited.containsKey(c.random.label)) {
                    cCloned.random = visited.get(c.random.label);
                } else {
                    ListNode randomCloned = new ListNode(c.random.label);
                    cCloned.random = randomCloned;
                    q.add(c.random);
                    visited.put(c.random.label, randomCloned);
                }
            }
        }

        return headCloned;
    }

    public ListNode copyListWithRandomPtr(ListNode head) {
        ListNode psudoHead = new ListNode();

        for (ListNode i = head; i != null; i = i.next.next) {
            ListNode nodeCloned = new ListNode();
            nodeCloned.next = i.next;
            i.next = nodeCloned;
        }

        for (ListNode i = head; i != null; i = i.next.next) {
            if (i.random != null) {
                i.next.random = i.random.next;
            }
        }

        for (ListNode i = head, j = psudoHead; i != null; i = i.next, j = j.next) {
            j.next = i.next;
            i.next = j.next.next;
        }

        return psudoHead.next;
    }
}