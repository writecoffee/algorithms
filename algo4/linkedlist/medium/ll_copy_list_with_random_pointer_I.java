package medium;

import java.util.HashMap;

/**
 * A linked list is given such that each node contains an additional random pointer which
 * could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * You are allowed to use up to O(n) extra space.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/copy-list-with-random-pointer/}
 *                {@linkplain http://www.itint5.com/oj/#19}
 *
 */
public class ll_copy_list_with_random_pointer_I {
    private class RandomListNode {
        private int label;
        private RandomListNode next, random;

        private RandomListNode(int x) {
            this.label = x;
        }

        private RandomListNode() { }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<Integer, RandomListNode> h = new HashMap<Integer, RandomListNode>();
        RandomListNode headCloned = new RandomListNode(head.label);
        h.put(head.label, headCloned);

        for (RandomListNode c1 = head, c2 = null; c1 != null; c1 = c1.next) {
            c2 = h.get(c1.label);

            if (c1.next != null) {
                if (h.containsKey(c1.next.label)) {
                    c2.next = h.get(c1.next.label);
                } else {
                    RandomListNode nextCloned = new RandomListNode(c1.next.label);
                    c2.next = nextCloned;
                    h.put(c1.next.label, nextCloned);
                }
            }

            if (c1.random != null) {
                if (h.containsKey(c1.random.label)) {
                    c2.random = h.get(c1.random.label);
                } else {
                    RandomListNode randomCloned = new RandomListNode(c1.random.label);
                    c2.random = randomCloned;
                    h.put(c1.random.label, randomCloned);
                }
            }
        }

        return headCloned;
    }
}