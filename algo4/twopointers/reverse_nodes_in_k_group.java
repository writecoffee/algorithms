public class reverse_nodes_in_k_group {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode psudoHead = new ListNode(-1);
        psudoHead.next = head;
        ListNode prev = psudoHead;
        ListNode curr = head;
        ListNode tail = head;
        int n = 1;

        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        
        if (n < k) {
            return head;
        }

        int count = 0;
        while (count < n) {
            int i = 1;
            while (i < k) {
                ListNode temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;
                i++;
            }

            count += k;
            if (count + k > n) {
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        return psudoHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        reverseKGroup(n1, 3);
    }
}