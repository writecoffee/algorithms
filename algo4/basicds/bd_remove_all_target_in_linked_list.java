public class bd_remove_all_target_in_linked_list
{
    static class LinkedListNode
    {
        int            val;
        LinkedListNode next;
    }

    static LinkedListNode removeAll(int val, LinkedListNode list)
    {
        LinkedListNode psudoHead = new LinkedListNode();
        psudoHead.next = list;

        LinkedListNode c = psudoHead;
        while (c.next != null) {
            if (c.next.val == val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return psudoHead.next;
    }
}