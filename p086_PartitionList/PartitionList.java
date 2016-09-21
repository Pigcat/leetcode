package p086_PartitionList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while( p.next != null && p.next.val < x)
        	p = p.next;
        ListNode q = p.next;
        while( q != null && q.next != null )
        {
        	if( q.next.val < x)
        	{
        		ListNode t = q.next;
        		q.next = q.next.next;
        		t.next = p.next;
        		p.next = t;
        		p = t;
        	}
        	else
        		q = q.next;
        }
        return dummy.next;
    }
}
