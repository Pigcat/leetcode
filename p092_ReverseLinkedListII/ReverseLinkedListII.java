package p092_ReverseLinkedListII;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
        int pos = 1;
        ListNode curNode = head;
        ListNode preNode = dummy;
        while(pos != m)
        {
        	preNode = curNode;
        	curNode = curNode.next;
        	pos++;
        }
        ListNode preNode_M = preNode;
        while(pos <= n)
        {
        	ListNode postNode = curNode.next;
        	curNode.next = preNode;
        	preNode = curNode;
        	curNode = postNode;
        	pos++;
        }    	
    	preNode_M.next.next = curNode;
    	preNode_M.next = preNode;
    	return dummy.next;
    	/*
        int pos = 1;
        ListNode curNode = head;
        ListNode preNode = null;
        while(pos != m)
        {
        	preNode = curNode;
        	curNode = curNode.next;
        	pos++;
        }
        ListNode preNode_M = preNode;
        while(pos <= n)
        {
        	ListNode postNode = curNode.next;
        	curNode.next = preNode;
        	preNode = curNode;
        	curNode = postNode;
        	pos++;
        }
        if(preNode_M != null)
        {
        	preNode_M.next.next = curNode;
        	preNode_M.next = preNode;
        }
        else
        {
        	head.next = curNode;
        	head = preNode;
        }
        return head;
        */
    }
}
