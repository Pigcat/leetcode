package p024_SwapNodesInPairs;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode cur = head;
    	ListNode pre = dummy;
    	while(cur != null)
    	{
    		if(cur.next == null)
    			break;
    		ListNode post = cur.next;
    		pre.next = post;
    		cur.next = post.next;
    		post.next = cur;
    		pre = cur;
    		cur = cur.next;
    	}
    	return dummy.next;
    }
}
