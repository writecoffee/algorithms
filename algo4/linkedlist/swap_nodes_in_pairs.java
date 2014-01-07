
public class swap_nodes_in_pairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode before = new ListNode(-1);
        before.next = head;
        ListNode psudoHead = before;
        ListNode first = before.next;
        ListNode second = first.next;
        ListNode after = second.next;

        while (after != null && after.next != null) {
            second.next = first;
            before.next = second;
            first.next = after;

            before = first;
            first = before.next;
            second = first.next;
            after = second.next;
        }

        second.next = first;
        before.next = second;
        first.next = after;

        return psudoHead.next;
    }
    
    public static void main(String[] args) {
        
    }
}