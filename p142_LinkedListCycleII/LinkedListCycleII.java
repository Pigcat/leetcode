package p142_LinkedListCycleII;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
        	return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null)
        {
        	fast = fast.next.next;
        	slow = slow.next;
        	while(fast == slow)
        	{
        		fast = head;
        		while(fast != slow)
        		{
        			fast = fast.next;
        			slow = slow.next;
        		}
        		return fast;
        	}
        }
        return null;
    }
}
