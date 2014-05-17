import java.util.HashSet;

public class delete_node_in_linked_list {
    public static class ListNode {
        char val;
        ListNode next;

        ListNode(char x) {
            val = x;
            next = null;
        }
    }

    public static ListNode delete_targets(HashSet<Character> targets, ListNode head) {
        ListNode psudoHead = new ListNode(' ');
        psudoHead.next = head;
        ListNode current = psudoHead;

        while (current.next != null) {
            if (targets.contains(current.next.val)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode('a');
        ListNode b = new ListNode('b');
        ListNode c = new ListNode('c');
        ListNode d = new ListNode('d');
        a.next = b;
        b.next = c;
        c.next = d;
        HashSet<Character> targets = new HashSet<Character>();
        targets.add('a');
        targets.add('b');
        targets.add('c');
        targets.add('d');
        
        delete_targets(targets, a);
    }
}