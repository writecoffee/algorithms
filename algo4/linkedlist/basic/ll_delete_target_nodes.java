package basic;

import java.util.HashSet;

public class ll_delete_target_nodes {
    public class ListNode {
        char val;
        ListNode next;

        ListNode(char x) {
            val = x;
            next = null;
        }
    }

    public ListNode delete_targets(HashSet<Character> targets, ListNode head) {
        ListNode psudoHead = new ListNode(' ');
        psudoHead.next = head;
        ListNode c = psudoHead;

        while (c.next != null) {
            if (targets.contains(c.next.val)) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return psudoHead.next;
    }
}