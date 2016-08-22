package p82_RemoveDuplicatesFromSortedListII;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode fake = new ListNode(Integer.MAX_VALUE);
        fake.next = head;
        if(head.val == Integer.MAX_VALUE)
        	fake.val = Integer.MIN_VALUE;
        ListNode p = fake;
        while(p.next != null)
        {
        	ListNode first = p.next;
        	ListNode second = p.next.next;
        	if(second == null || first.val != second.val)
        	{
        		p = first;
        		continue;
        	}
        	while(second != null && first.val == second.val)
        		second = second.next;
        	p.next = second;
        }
        return fake.next;
    }
}
