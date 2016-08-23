package p206_ReverseLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode ans = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ans;
	}
	
	
	/*
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode post = head.next.next;
        head.next = null;
        while(cur != null)
        {
        	cur.next = pre;
        	pre = cur;
        	cur = post;
        	if(post != null)
        		post = post.next;
        }
        return pre;
    }
    */
}
