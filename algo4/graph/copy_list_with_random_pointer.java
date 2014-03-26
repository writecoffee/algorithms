import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class copy_list_with_random_pointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, RandomListNode> visited = new HashMap<Integer, RandomListNode>();
        Queue<RandomListNode> q = new LinkedList<RandomListNode>();
        q.add(head);
        RandomListNode headCloned = new RandomListNode(head.label);
        visited.put(head.label, headCloned);

        while (!q.isEmpty()) {
            RandomListNode c = q.poll();
            RandomListNode cCloned = visited.get(c.label);

            if (c.next != null) {
                if (visited.containsKey(c.next.label)) {
                    cCloned.next = visited.get(c.next.label);
                } else {
                    RandomListNode nextCloned = new RandomListNode(c.next.label);
                    cCloned.next = nextCloned;
                    q.add(c.next);
                    visited.put(c.next.label, nextCloned);
                }
            }

            if (c.random != null) {
                if (visited.containsKey(c.random.label)) {
                    cCloned.random = visited.get(c.random.label);
                } else {
                    RandomListNode randomCloned = new RandomListNode(c.random.label);
                    cCloned.random = randomCloned;
                    q.add(c.random);
                    visited.put(c.random.label, randomCloned);
                }
            }
        }

        return headCloned;
    }
}