package p148_SortList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class SortList {
	public static void main(String args[])
	{
		ListNode test = new ListNode(2);
		test.next = new ListNode(1);
		SortList te = new SortList();
		te.sortList(test);
		
	}
	
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null)
        {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode post = slow.next;
        slow.next = null;
        head = sortList(head);
        post = sortList(post);
        head = mergeList(head,post);
        return head;
    }
    
    ListNode mergeList(ListNode l1, ListNode l2)
    {
    	ListNode p = l1;
    	ListNode q = l2;
    	ListNode ans = new ListNode(0);
    	ListNode head = ans;
    	while(p != null && q != null)
    	{
    		if(p.val <= q.val)
    		{
    			ans.next = p;
    			p = p.next;
    		}
    		else
    		{
    			ans.next = q;
    			q = q.next;
    		}
    		ans = ans.next;
    		ans.next = null;
    	}
    	if(p != null)
    		ans.next = p;
    	else
    		ans.next = q;
    	return head.next;
    }
}
