package medium;

/**
 * A linked list is given such that each node contains an additional random pointer which
 * could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * You are not allowed to use extra space. Try O(n) solution.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/copy-list-with-random-pointer/}
 *                {@linkplain http://www.itint5.com/oj/#19}
 *
 */
public class ll_copy_list_with_random_pointer_II {
    private class RandomListNode {
        private RandomListNode next, random;

        private RandomListNode() { }
    };

    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode psudoHead = new RandomListNode();

        for (RandomListNode i = head; i != null; i = i.next.next) {
            RandomListNode nodeCloned = new RandomListNode();
            nodeCloned.next = i.next;
            i.next = nodeCloned;
        }

        for (RandomListNode i = head; i != null; i = i.next.next) {
            if (i.random != null) {
                i.next.random = i.random.next;
            }
        }

        for (RandomListNode i = head, j = psudoHead; i != null; i = i.next, j = j.next) {
            j.next = i.next;
            i.next = j.next.next;
        }

        return psudoHead.next;
    }
}